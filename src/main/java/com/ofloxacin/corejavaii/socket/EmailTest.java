package com.ofloxacin.corejavaii.socket;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/4 21:11
 */
public class EmailTest {
    public static void main(String[] args) throws IOException, MessagingException {
        Properties props = new Properties();
        props.load(Object.class.getResourceAsStream("/email.properties"));

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("chenshuai1992@qq.com"));
        message.addRecipients(Message.RecipientType.TO, "729889948@qq.com");
        message.setSubject("测试邮件标题", "UTF-8");
        message.setText("这是一封测试邮件", "UTF-8");

        Transport transport = mailSession.getTransport();
        transport.connect(null, password);
        transport.sendMessage(message, message.getAllRecipients());
    }
}
