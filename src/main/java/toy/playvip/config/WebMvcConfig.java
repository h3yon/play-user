package toy.playvip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private JwtCheckInterceptor jwtCheckInterceptor;
//
//    private String[] INTERCEPTOR_WHITE_LIST = {
//            //누구나 접근 가능한 uri
//    };
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtCheckInterceptor)
//                .addPathPatterns("/*")
//                .excludePathPatterns(INTERCEPTOR_WHITE_LIST);
//
//    }

}
