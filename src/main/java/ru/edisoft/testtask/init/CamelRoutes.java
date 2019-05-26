

package ru.edisoft.testtask.init;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import ru.edisoft.testtask.XmlHandler;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
public class CamelRoutes extends RouteBuilder {

  @Autowired
  XmlHandler xmlHandler;

  @Override
  public void configure() {
    from("file:src/data/inbox").process(xmlHandler);
  }
}
