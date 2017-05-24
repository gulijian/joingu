import com.gulj.assembly.EmailApplication;
import com.gulj.assembly.email.AssemblyEmailBo;
import com.gulj.assembly.email.EmailAssembly;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author gulj
 * @create 2017-05-24 下午4:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmailApplication.class)
public class EmailApplicationTest {


    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    private EmailAssembly emailAssembly;

    /**
     * 普通文本邮件
     *
     * @throws Exception
     */
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("join@newchama.com");
        message.setTo("1175327069@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }


    /**
     * 静态资源邮件
     *
     * @throws Exception
     */
    @Test
    public void sendInlineMail() throws Exception {
        AssemblyEmailBo assemblyEmailBo = new AssemblyEmailBo();
        assemblyEmailBo.setFrom("join@newchama.com");
        assemblyEmailBo.setTo("1175327069@qq.com");
        assemblyEmailBo.setSubject("主题：嵌入静态资源");
        assemblyEmailBo.setText("<html><body><img src=\"cid:user\" ></body></html>");
        emailAssembly.sendInlineMail(assemblyEmailBo, new File("/Users/newchama/Documents/E/workspace-ide/joingu/gulj-assembly-email/src/main/resources/static/images/user.jpg"));
    }


    /**
     * 发送附件
     *
     * @throws Exception
     */
    @Test
    public void sendAttachmentsMail() throws Exception {
        AssemblyEmailBo assemblyEmailBo = new AssemblyEmailBo();
        assemblyEmailBo.setFrom("join@newchama.com");
        assemblyEmailBo.setTo("1175327069@qq.com");
        assemblyEmailBo.setSubject("主题：嵌入静态资源");
        assemblyEmailBo.setText("附件内容测试2");
        File file = new File("/Users/newchama/Documents/E/workspace-ide/joingu/gulj-assembly-email/src/main/resources/static/images/user.jpg");
        File file1 = new File("/Users/newchama/Documents/E/workspace-ide/joingu/gulj-assembly-email/src/main/resources/static/images/locked.png");
        File[] files = new File[]{file, file1};
        emailAssembly.sendAttachmentsMail(assemblyEmailBo, files);
    }

}
