

package ru.edisoft.testtask.init;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/26/19
 */
public class CamelUp
{
  @Autowired
  CamelRoutes camelRoutes;

  private void init()
  {
    CamelContext context = new DefaultCamelContext();
    try
    {
      context.addRoutes(camelRoutes);
      context.start();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
