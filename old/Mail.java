package veri;

import java.util.*;    
import javax.mail.*;    
import javax.mail.internet.*; 
import javax.activation.*;  

public class Mail {
    
    public static void sendMail() throws Exception{
        
        String to = "";
        
        String from = "nsrlhn@gmail.com";
        String password = "4en5sar3";
        String sub = "Auto mail send by Java App";
        String msg = "Nihat abi merhaba,,\n\nPrograma id ve sifre girerek, direk program uzerinden mail atiliyor. Bu sekilde epey de basit."
                + "\n\nSadece gmail kullanilirsa, hesap ayarlarindan daha az guvenli uygulamalara izin verilmesi gerekiyor. Ama firmalar zaten kendi mail serverlarini kullandiklari icin orada oyle bir ayara ihtiyac olmayabilir.";
        
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
          
        Session session = Session.getDefaultInstance(props,    
        new javax.mail.Authenticator() {    
        protected PasswordAuthentication getPasswordAuthentication() {    
        return new PasswordAuthentication(from,password);  
        }    
        });    
        //compose message    
        try {    
            MimeMessage message = new MimeMessage(session);    
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
            message.setSubject(sub);    
           
            BodyPart messageBodyPart1 = new MimeBodyPart();  
            messageBodyPart1.setText(msg);
           
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
  
            String filename = "RCO#2Rev1.pdf";
            DataSource source = new FileDataSource(filename);  
            messageBodyPart2.setDataHandler(new DataHandler(source));  
            messageBodyPart2.setFileName(filename);
            
            Multipart multipart = new MimeMultipart();  
            multipart.addBodyPart(messageBodyPart1);  
            multipart.addBodyPart(messageBodyPart2);  

            message.setContent(multipart);  
            
            //send message  
            Transport.send(message);    
            System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
    
    }
}
