
package ru.edisoft.testtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.edisoft.testtask.init.CamelRoutes;
import ru.edisoft.testtask.init.CamelUp;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/26/19
 */
@Configuration
public class ApacheCamelConfiguration
{
  @Bean(name = "camelRoutes")
  public CamelRoutes getRoutes()
  {
    return new CamelRoutes();
  }

  @Bean(initMethod = "init")
  public CamelUp startCamel()
  {
    return new CamelUp();
  }
}
