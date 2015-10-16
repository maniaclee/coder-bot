package psyco.coderbot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        addResource(registry, "css");
        addResource(registry, "js");
        addResource(registry, "img");
        addResource(registry, "lib");


        addResource(registry, "worthy");
    }

    void addResource(ResourceHandlerRegistry registry, String prefix) {
        registry.addResourceHandler("/static/@/**".replace("@", prefix)).addResourceLocations("classpath:static/@/".replace("@", prefix)).setCachePeriod(31556926);
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver re = new CommonsMultipartResolver();
        re.setMaxUploadSize(100000000);
        return re;
    }

//    @Bean
//    public TemplateResolver servletContextTemplateResolver() {
//        ServletContextTemplateResolver re = new ServletContextTemplateResolver();
////        re.setPrefix("/template");
//        re.setSuffix(".html");
//        re.setTemplateMode("HTML5");
//        re.setCacheable(false);
//        re.setCharacterEncoding("UTF-8");
//        return re;
//    }
//
//    @Bean
//    public  SpringTemplateEngine  sdfsd(TemplateResolver templateResolver){
//        SpringTemplateEngine re = new SpringTemplateEngine();
//        re.setTemplateResolver(templateResolver);
//        ThymeleafViewResolver  vr = new ThymeleafViewResolver();
//        vr.setTemplateEngine(re);
//        vr.setCharacterEncoding("UTF-8");
//        vr.setOrder(0);
//        return re;
//    }
//
//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/");
//        resolver.setSuffix(".html");
//        return resolver;
//    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
    }
    //	@Bean
//	public ServletContextInitializer initializer() {
//		return new PsycoServletContextInitializer();
//	}

}
