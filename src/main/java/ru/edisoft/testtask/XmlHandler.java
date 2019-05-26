

package ru.edisoft.testtask;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

import ru.edisoft.testtask.entity.Document;
import ru.edisoft.testtask.service.XmlService;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
public class XmlHandler implements Processor
{
  private static final String XSLT_TEMPLATE = "src/data/template/idoc2order.xsl";

  @Autowired
  private XmlService xmlService;

  @Override
  public void process(Exchange exchange) throws Exception
  {
    File originalFile = exchange.getIn().getBody(File.class);
    BufferedReader buffer = new BufferedReader(new FileReader(originalFile));

    TransformerFactory factory = TransformerFactory.newInstance();

    Source xslt = new StreamSource(new File(XSLT_TEMPLATE));
    Transformer transformer = factory.newTransformer(xslt);
    Source xml = new StreamSource(buffer);
    StringWriter writer = new StringWriter();
    transformer.transform(xml, new StreamResult(writer));

    Document document = new Document();
    document.setOriginalFileName(originalFile.getName());
    document.setDateReceive(new Date());
    document.setOriginalFileContent(getOriginalFileContent(originalFile.getAbsolutePath()));
    document.setTransformFileContent(writer.toString());

    xmlService.saveDocument(document);
  }

  private String getOriginalFileContent(String absolutePath)
  {
    StringBuilder contentBuilder = new StringBuilder();
    try (Stream<String> stream = Files.lines(Paths.get(absolutePath), StandardCharsets.UTF_8))
    {
      stream.forEach(s -> contentBuilder.append(s).append("\n"));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return contentBuilder.toString();
  }
}
