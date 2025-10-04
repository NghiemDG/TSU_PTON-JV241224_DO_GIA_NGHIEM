package ra.project.configs;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // khai báo các cấu hình gôc
        return new Class[]{HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // các cấu hình liên quan tới web - MVC
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // Câ hình đường dẫn ánh xa
        return new String[]{"/"}; // khớp với localhost 8080
    }
    // cấu hình character encoding

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return new Filter[]{filter};
    }
}