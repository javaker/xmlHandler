

package ru.edisoft.testtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.edisoft.testtask.XmlHandler;
import ru.edisoft.testtask.service.XmlService;
import ru.edisoft.testtask.service.impl.XmlServiceImpl;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
@Configuration
public class AppContextConfiguration
{

  @Bean
  public XmlHandler getXmlHandler()
  {
    return new XmlHandler();
  }

  @Bean(name = "xmlService")
  public XmlService getXmlService() {
    return new XmlServiceImpl();
  }

}
