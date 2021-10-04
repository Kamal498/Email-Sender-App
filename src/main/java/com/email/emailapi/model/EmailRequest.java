package com.email.emailapi.model;

import java.util.Arrays;

public class EmailRequest {

private String message;
private String subject;
private String[] to;

    public EmailRequest() {
    }

    public EmailRequest(String message, String subject, String[] to) {
        this.message = message;
        this.subject = subject;
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "message='" + message + '\'' +
                ", subject='" + subject + '\'' +
                ", to=" + Arrays.toString(to) +
                '}';
    }
}
