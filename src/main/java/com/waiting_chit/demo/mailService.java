package com.waiting_chit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class mailService {
	
	@Autowired
    private MailSender mailSender;

    private SimpleMailMessage templateMessage;

//    @Value("${send.from.email}")
    private String fromEmail = "neo.wtesting@gmail.com";

//    @Value("${send.to.email}")
    private String toEmail = "neo.wongkl@gmail.com";

    public void sendEmailToNewCustomer(Customer customer){
        System.out.println("Starting Send...");
        String response = "OK";
        this.templateMessage = new SimpleMailMessage();

        this.templateMessage.setSubject("Your ID");
        this.templateMessage.setFrom(this.fromEmail);
        this.templateMessage.setTo(customer.getEmail());

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setText("Your ID is " + customer.getId());

        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex){
            response = "NO_OK";
            System.err.println(ex.getMessage());
        }
        System.out.println("Finished Send...");
    }
    
    public void sendEmailToCurrentCustomer(Customer customer){
        System.out.println("Starting Send...");
        String response = "OK";
        this.templateMessage = new SimpleMailMessage();

        this.templateMessage.setSubject("Your ID");
        this.templateMessage.setFrom(this.fromEmail);
        this.templateMessage.setTo(customer.getEmail());

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setText("Your ID is " + customer.getId() + ".\nYou can get in now.");

        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex){
            response = "NO_OK";
            System.err.println(ex.getMessage());
        }
        System.out.println("Finished Send...");
    }
    
    public void sendEmailToNextCustomer(Customer customer){
        System.out.println("Starting Send...");
        String response = "OK";
        this.templateMessage = new SimpleMailMessage();

        this.templateMessage.setSubject("Your ID");
        this.templateMessage.setFrom(this.fromEmail);
        this.templateMessage.setTo(customer.getEmail());

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setText("Your ID is " + customer.getId() + ".\nYou are the next one.");

        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex){
            response = "NO_OK";
            System.err.println(ex.getMessage());
        }
        System.out.println("Finished Send...");
    }
    
    

}
