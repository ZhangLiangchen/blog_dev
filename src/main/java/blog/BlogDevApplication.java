package blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主配置类，项目启动入口
 */
//@MapperScan("blog.mapper")
@SpringBootApplication
public class BlogDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogDevApplication.class, args);
    }

}
