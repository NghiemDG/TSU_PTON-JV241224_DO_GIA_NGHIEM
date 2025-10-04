package ra.project.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // chú thích đây là 1 lớp cấu hình, định nghĩa các bean(các đối tượng đc spring kởi tạo và quản lí)
@EnableWebMvc // sử dụng các cấu hình mặc định cấu web mvc
@ComponentScan(basePackages = {"ra.project"} )
// quét cac thành phần của ứng dụng và tự động tao bean cho các thành phần đó:(@Component,@Controller, @Service, @Repository)
public class WebConfig implements WebMvcConfigurer {
    // tạo bean view resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // chi định thư mục chứa giao diện
        resolver.setSuffix(".jsp"); // đuôi của giao diên
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**") // khi chỉ định 1 đường dẫn /css/abc.css
                .addResourceLocations("/css/"); // khơp với resouces/css/abc.css
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(1024 * 1024 * 10); // giới hạn kích thước tệp tải lên là 10MB
        resolver.setMaxUploadSizePerFile(1024 * 1024 * 5); // giới hạn kích thước mỗi tệp tải lên là 5MB
        return resolver;
    }
}