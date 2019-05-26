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

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.edisoft.testtask.config.AppContextConfiguration;
import ru.edisoft.testtask.config.DataBaseConfiguration;
import ru.edisoft.testtask.service.XmlService;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
public class App
{
  public static void main(String[] args) throws Exception
  {
    AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
    appContext.register(AppContextConfiguration.class);
    appContext.register(DataBaseConfiguration.class);
    appContext.refresh();

    XmlService xmlService = (XmlService) appContext.getBean("xmlService");
    final String documentContentById = xmlService.getDocumentContentById(5);

    //    CamelContext camelContext = CamelContextResolverHelper.getCamelContextWithId(appContext, "camelContext");
//
//    Server server = new Server(8080);
//    WebAppContext handler = new WebAppContext();
//    handler.setResourceBase("/");
//    handler.setContextPath("/");
//    handler.addServlet(new ServletHolder(new DispatcherServlet()), "/*");
//    server.setHandler(handler);
//    server.start();

    //    try {
    //      camelContext.start();
    //      Thread.sleep(2000);
    //    } finally {
    //      camelContext.stop();
    //    }
  }
}
