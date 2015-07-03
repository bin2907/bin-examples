package com.bin.framework.util;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailSender {

	private String from = "binh.nguyenthanh@vsl.com";
	private Session session;

    
    /**
     * Build the mail sender.
     */
    public MailSender() {
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "exchgway.bouygues-construction.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "false");
        
        /*props.setProperty("proxySet","true");
        props.setProperty("socksProxyHost","10.5.253.125");
        props.setProperty("socksProxyPort","8080");*/
        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        });
    }

    /**
     * 
     * Send mail.
     * 
     * @param to
     * @param subject
     * @param body
     * @param attachmentFiles
     */
    public void sendMail(String[] to, String subject, String body, String[] attachmentFiles) {
    	if (session != null) {
            try {
                System.out.println("Sending...");

                MimeMessage msg = new MimeMessage(session);
                msg.setHeader("X-Mailer", "JavaMailer");
                msg.setSentDate(new Date());
                msg.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
                msg.setFrom(new InternetAddress("", from));

                if ((to != null) && (to.length != 0)) {
                    for (String address : to) {
                        if ((address != null) && !address.isEmpty()) {
                            System.out.println("Send to address: " + address);
                            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
                        }
                    }
                }
                
                // Create the message body part
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                
                // Fill the message
                messageBodyPart.setContent(body, "text/html; charset=utf-8");
                
                //Create a multipart message for attachment
                Multipart multipart = new MimeMultipart();
        
                // Set text message part
                multipart.addBodyPart(messageBodyPart);
                
                if(attachmentFiles != null){
                	for(String file : attachmentFiles){
                    	addAttachment(multipart, file);
                    }
                }
        
                // Send the complete message parts
                msg.setContent(multipart);

                Transport.send(msg);
                System.out.println("Finish");

            } catch (Exception ex) {
                System.out.println("Send email error: " + ex.toString());
                ex.printStackTrace();
            }
        }
    }
    
    private void addAttachment(Multipart multipart, String filename) throws MessagingException
    {
        DataSource source = new FileDataSource(filename);
        BodyPart messageBodyPart = new MimeBodyPart();        
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(source.getName());
        multipart.addBodyPart(messageBodyPart);
    }
    
    public static void main(String[] args){
    	
    	// Mail 1
    	MailSender mailSender = new MailSender();
    	String objet = "POSTER : Affaire BNG.Binh Test Dossier 2 - Binh Test Dossier 2";
    	String content = "<b>Montant : </b><i>100.00 €</i> <br /> <b>Marge Brute : </b><i>-100,00 %</i> <br /> <b>Marge Affaire : </b><i>-168,33 €</i> <br /><br /> <a href='http://localhost:8080/poster-web/feuille-de-marge.action?idAffaireVersion=2205&send=mail'>Cliquer ici</a> pour accéder à l’affaire à valider présentée par : NGUYEN THANH Binh";
    	mailSender.sendMail(new String[]{"binh.nguyenthanh@vsl.com"}, objet, content, null);
    	
    	mailSender = new MailSender();
    	objet = "POSTER : Validation objectif affaire BNG.DPROC-1196 2 - DPROC-1196 2";
    	//content = "<b>Affaire :  a �t� valid� par: </b><i></i> <br/><br /> <b>Commande : </b><i style='color: #1F497D'>Commande</i> <br /> <b>Prix de vente : </b><i>636,00 �</i> <br /><br /> <b>Commentaire : </b><i></i> <br /><br /> Merci de ne pas r�pondre � cet email automatique. <br /> ----------------------------------------------------------------------------------- <br /> <b><i>P.J : <i></b>le fichier d�import ZPS_EDF EDIFICE (CSV) et la feuille de Marge (PDF)";
    	content = "<b>Affaire : </b><i>BNG.DPROC-1196 2 - DPROC-1196 2 </i><b>a été validé par: </b><i>NGUYEN THANH Binh</i> <br /><br /> <b>Commande : </b><i style=color: #1F497D></i> <br /> <b>Prix de vente : </b><i></i> <br /><br /> Merci de ne pas répondre à cet email automatique. <br /> ----------------------------------------------------------------------------------- <br /> <b><i>P.J : <i></b>le fichier d’import ZPS_EDF EDIFICE (CSV) et la feuille de Marge (PDF)";
    	String[] attachmentFiles = {"C:\\Users\\Administrator\\Desktop\\abc.csv", "C:\\Users\\Administrator\\Desktop\\abc.pdf"};
    	mailSender.sendMail(new String[]{"binh.nguyenthanh@vsl.com"}, objet, content, attachmentFiles);
    	
    	
    }

}
