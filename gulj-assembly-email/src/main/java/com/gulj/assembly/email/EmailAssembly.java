package com.gulj.assembly.email;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import java.io.File;

/**
 * 邮件接口
 *
 * @author gulj
 * @create 2017-05-24 下午4:41
 **/
public interface EmailAssembly {


    /**
     * 发送普通文本邮件
     *
     * @param simpleMailMessage
     * @throws MailException
     */
    void sendSimpleMail(SimpleMailMessage simpleMailMessage) throws MailException;


    /**
     * 发送嵌入静态资源邮件
     *
     * @param assemblyEmailBo
     * @param file
     * @throws Exception
     */
    void sendInlineMail(AssemblyEmailBo assemblyEmailBo, File file) throws Exception;


    /**
     * 发送带有附件的邮件
     *
     * @param assemblyEmailBo
     * @param files
     * @throws MailException
     */
    void sendAttachmentsMail(AssemblyEmailBo assemblyEmailBo, File[] files) throws Exception;


}
