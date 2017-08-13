package in.dharamshala.booking.service;


import in.dharamshala.booking.model.Mail;
/**
*
* @author ShwetaJain
*/
public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);


    public void sendEmail(Mail mail,String templateFile);
    void sendMessageWithAttachment(String to,
                                   String subject,
                                   String text,
                                   String pathToAttachment);
}
