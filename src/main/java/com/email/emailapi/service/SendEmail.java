package com.email.emailapi.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class SendEmail {

    public static Boolean sendEmailToMultiple(String message, String subject, String[] to) {

        Boolean flag=false;

        String from = "developerindia98@gmail.com";

        //Variable for gmail host
        String host = "smtp.gmail.com";

        //get the system properties (Load properties from system)
        Properties properties = System.getProperties();
        System.out.println("Properties "+ properties);


        //setting important info to properties object

        //host set(put the information in properties object)
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1: to get the session object..(by authenticating by providing email id and password)
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("developerindia98@gmail.com","justfortesting");
            }


        });
        //For getting the information in the console
        session.setDebug(true);

        //Step2 : compose the message [text, multimedia, file etc]
        MimeMessage m = new MimeMessage(session);

        try{
            //from email
            m.setFrom(from);

            //Add multiple recipients to send email to
            int c = 0;
            while(c<to.length){

                //adding multiple recipients to message
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to[c]));
                c++;
            }


            //adding subject to message
            m.setSubject(subject);

            //adding text to message body
            m.setText(message);


            //Step 3: send the message using transport class
            Transport.send(m);

            //If message successfully sent
            System.out.println("Sent success.............");
            flag=true;


        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Oops!! there was an error :(");
            flag=false;
        }
        return flag;
    }
}
