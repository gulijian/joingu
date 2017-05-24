import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 平台后台启动配置类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.gulj.app.admin.**.config","com.gulj.assembly.config"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
@EnableAsync
@EnableTransactionManagement
public class AdminApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF)
				.sources(AdminApplication.class).run(args);

//		SpringApplication.run(AdminApplication.class, args);
	}
}
