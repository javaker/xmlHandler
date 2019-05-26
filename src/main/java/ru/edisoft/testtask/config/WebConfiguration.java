

package ru.edisoft.testtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/26/19
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.edisoft.testtask.controller")
public class WebConfiguration extends WebMvcConfigurerAdapter
{
  @Bean
  public UrlBasedViewResolver getViewResovler() {
    UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
    urlBasedViewResolver.setViewClass(JstlView.class);
    urlBasedViewResolver.setPrefix("pages/");
    urlBasedViewResolver.setSuffix(".jsp");
    return urlBasedViewResolver;
  }
}
