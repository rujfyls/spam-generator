package ru.feduncov.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.feduncov.dto.MessageDTO;

@Service
public class KafkaConsumer {

    private final JavaMailSender javaMailSender;

    public KafkaConsumer(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @KafkaListener(
            topics = "${topic}",
            containerFactory = "greetingKafkaListenerContainerFactory",
            groupId = "groupId")
    public void greetingListener(MessageDTO messageDTO) {

        for (int i = 0; i < messageDTO.getCount(); i++) {
            sendMail(messageDTO.getEmail(),
                    messageDTO.getSubject(),
                    messageDTO.getMessage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sendMail(String toEmail, String subject, String message) {

        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailMessage.setFrom("spam-generator");

        javaMailSender.send(mailMessage);
    }
}
