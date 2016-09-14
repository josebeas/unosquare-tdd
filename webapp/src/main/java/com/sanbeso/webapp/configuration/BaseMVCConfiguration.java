package com.sanbeso.webapp.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by jose.beas on 9/14/2016.
 */
@Configuration
@ComponentScan(basePackages = "com.sanbeso.webapp")
@EnableWebMvc
public class BaseMVCConfiguration extends WebMvcConfigurerAdapter {

    /**
     * Get the spring view resolver for the spring MVC
     *
     * @return Spring MVC view resolver
     */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * Get the messages sources bundle for i18n
     *
     * @return messages resource bundle
     */
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messages = new ReloadableResourceBundleMessageSource();
        messages.setBasename("classpath:messages");

        return messages;
    }

    /**
     * Get the locale resolver
     *
     * @return locale resolver
     */
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        return new FixedLocaleResolver();
    }

    /**
     * Add the resource handlers for the spring MVC
     *
     * @param registry Resource handler registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    /**
     * Define the request mapping handler for spring MVC
     *
     * @return Request mapping handler adapter
     */
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        final RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        final MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        final String[] supportedHttpMethods = {"POST", "GET", "HEAD"};

        requestMappingHandlerAdapter.getMessageConverters().add(0, mappingJacksonHttpMessageConverter);
        requestMappingHandlerAdapter.setSupportedMethods(supportedHttpMethods);

        return requestMappingHandlerAdapter;
    }

}
