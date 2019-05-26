/*********************************************************************
 * The Initial Developer of the content of this file is NOVARDIS.
 * All portions of the code written by NOVARDIS are property of
 * NOVARDIS. All Rights Reserved.
 *
 * NOVARDIS
 * Detskaya st. 5A, 199106 
 * Saint Petersburg, Russian Federation 
 * Tel: +7 (812) 331 01 71
 * Fax: +7 (812) 331 01 70
 * www.novardis.com
 *
 * (c) 2019 by NOVARDIS
 *********************************************************************/

package trash;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
@Configuration
public class RouteConfig extends SingleRouteCamelConfiguration {

  @Override
  public RouteBuilder route() {
    return new RouteBuilder() {
      public void configure() {
        from("file:data?noop=true").to("bean:xmlHandler");
      }
    };
  }

}

//<camelContext xmlns="http://camel.apache.org/schema/spring">
//<route>
//<from uri="activemq:queue:test.queue" />
//<to uri="bean:myBean?method=appendCamel"/>
//<to uri="stream:out" />
//</route>
//</camelContext>