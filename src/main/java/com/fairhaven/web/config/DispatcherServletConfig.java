/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.config;

// Import log4j class
import com.fairhaven.web.converters.ServiceToStringConverter;
import com.fairhaven.web.converters.StringToServiceConverter;
import com.fairhaven.web.interceptors.LoggingInterceptor;
import com.fairhaven.web.interceptors.SessionVariablesInterceptor;
import java.util.Locale;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.hibernate4.support.OpenSessionInViewInterceptor;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 *
 * @author Sam
 */
@EnableWebMvc
@ComponentScan(basePackages = {"com.fairhaven.web"})
@Configuration
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = Logger.getLogger(DispatcherServletConfig.class.getName());

    @Resource
    private LoggingInterceptor loggingInterceptor;
    @Resource
    private OpenSessionInViewInterceptor osvInterceptor;
    @Resource
    private SessionVariablesInterceptor sessionVariablesInterceptor;
    @Resource
    private StringToServiceConverter serviceConverter;
    @Resource
    private ServiceToStringConverter serviceToStringConverter;

    @Resource
    private Environment env;

    /*@Override
     public void configureViewResolvers(ViewResolverRegistry registry){
     registry.tiles();
     }*/
    /**
     *
     * @return
     */
    @Bean
    public UrlBasedViewResolver getUrlBasedViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    /**
     *
     * @return
     */
    @Bean
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[]{"/WEB-INF/tiles-defs.xml"});
        return configurer;
    }

    /**
     *
     * @return
     */
    @Bean
    public CookieLocaleResolver getLocalResolver() {
        CookieLocaleResolver cookieResolver = new CookieLocaleResolver();
        cookieResolver.setDefaultLocale(Locale.ENGLISH);
        return cookieResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addWebRequestInterceptor(loggingInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**");;
        registry.addWebRequestInterceptor(osvInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**");
        registry.addInterceptor(sessionVariablesInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**");
        registry.addInterceptor(this.localeChangeInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**", "/members/resources/**")
                .addResourceLocations("/Resources/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/Resources/CSS/");
        registry.addResourceHandler("/scripts/**")
                .addResourceLocations("/Resources/Scripts/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/Resources/Images/");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        return validator;
    }

    /**
     *
     * @param sessionFactory
     * @return
     */
    @Autowired
    @Bean(name = "openSessionInViewInterceptor")
    public OpenSessionInViewInterceptor getOsvInterceptor(SessionFactory sessionFactory) {
        OpenSessionInViewInterceptor osvInterceptorBean = new OpenSessionInViewInterceptor();
        osvInterceptorBean.setSessionFactory(sessionFactory);
        return osvInterceptorBean;
    }

    /**
     *
     * @return
     */
    @Bean(name = "localeChangeInterceptor")
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    /**
     *
     * @return
     */
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        return new SessionLocaleResolver();
    }

    /**
     *
     * @return
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.setMaxUploadSize(env.getProperty("upload.max_upload_size", Long.class));
        return commonsMultipartResolver;
    }

    /**
     *
     * @return
     */
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages/messages", "classpath:messages/exceptions", "classpath:messages/forms");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

    /**
     *
     * @return
     */
    @Bean(name = "validatorSource")
    public ReloadableResourceBundleMessageSource getValidatorMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages/validation/validation_messages");
        return messageSource;
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(serviceConverter);
        formatterRegistry.addConverter(serviceToStringConverter);
    }

}
