package blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 主配置类，项目启动入口
 */
@ServletComponentScan("blog.servlet")
@SpringBootApplication
public class BlogDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogDevApplication.class, args);
    }

}
