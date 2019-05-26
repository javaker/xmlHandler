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

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
public class FileDownloader {
  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();
    context.addRoutes(new RouteBuilder() {
      public void configure() {
        from("file:data/inbox?noop=true").to("file:data/outbox");
      }
    });
    context.start();
    Thread.sleep(10000);
    context.stop();
  }
}

