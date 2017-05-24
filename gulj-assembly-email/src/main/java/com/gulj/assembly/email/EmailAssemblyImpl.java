package com.gulj.assembly.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gulj
 * @create 2017-05-24 下午4:44
 **/
@Service
public class EmailAssemblyImpl implements EmailAssembly {

    @Autowired
    private JavaMailSender mailSender;


    /**
     * 获取MimeMessage对象
     *
     * @return
     */
    private MimeMessage getMimeMessage() {
        return mailSender.createMimeMessage();
    }

    /**
     * 获取MimeMessageHelper对象
     *
     * @param assemblyEmailBo email 实体
     * @param mimeMessage     消息对象
     * @param mutipart        是否支持多附件
     * @param html            是否是html文件
     * @return
     * @throws Exception
     */
    private MimeMessageHelper getMimeMessageHelper(AssemblyEmailBo assemblyEmailBo, MimeMessage mimeMessage, boolean mutipart, boolean html) throws Exception {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, mutipart);
        helper.setFrom(assemblyEmailBo.getFrom());
        helper.setTo(assemblyEmailBo.getTo());
        helper.setSubject(assemblyEmailBo.getSubject());
        helper.setText(assemblyEmailBo.getText(), html);
        return helper;
    }


    @Override
    public void sendSimpleMail(SimpleMailMessage simpleMailMessage) throws MailException {
        mailSender.send(simpleMailMessage);
    }


    @Override
    public void sendInlineMail(AssemblyEmailBo assemblyEmailBo, File file) throws Exception {
        MimeMessage mimeMessage = getMimeMessage();
        MimeMessageHelper helper = getMimeMessageHelper(assemblyEmailBo, mimeMessage, true, true);
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        String[] fileName = fileSystemResource.getFilename().split("\\."); //"<html><body><img src=\"cid:weixin\" ></body></html>"
        helper.addInline(fileName[0], fileSystemResource);//注意addInline函数中资源名称weixin需要与正文中cid:weixin对应起来,建议cid名称和图片的名称相同
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendAttachmentsMail(AssemblyEmailBo assemblyEmailBo, File[] files) throws Exception {
        MimeMessage mimeMessage = getMimeMessage();
        MimeMessageHelper helper = getMimeMessageHelper(assemblyEmailBo, mimeMessage, true, false);
        List<FileSystemResource> fileSystemResourceList = new ArrayList<>();
        //附件
        for (int i = 0; i < files.length; i++) {
            fileSystemResourceList.add(new FileSystemResource(files[i]));
        }
        for (int i = 0; i < fileSystemResourceList.size(); i++) {
            helper.addAttachment(fileSystemResourceList.get(i).getFilename(), fileSystemResourceList.get(i));
        }
        mailSender.send(mimeMessage);
    }

}
