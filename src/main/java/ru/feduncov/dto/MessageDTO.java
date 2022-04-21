package ru.feduncov.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

    private Integer count;
    private String email;
    private String subject;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(Integer count, String email, String subject, String message) {
        this.count = count;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "count=" + count +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
