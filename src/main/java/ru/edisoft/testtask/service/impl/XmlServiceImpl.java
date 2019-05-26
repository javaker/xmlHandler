

package ru.edisoft.testtask.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ru.edisoft.testtask.entity.Document;
import ru.edisoft.testtask.repositories.XmlRepository;
import ru.edisoft.testtask.service.XmlService;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
public class XmlServiceImpl implements XmlService
{

  @Autowired
  XmlRepository xmlRepository;

  @Override
  public List<Document> findAll()
  {
    return xmlRepository.findAll();
  }

  @Override
  public Document saveDocument(Document document)
  {
    return xmlRepository.saveAndFlush(document);
  }

  @Override
  public String getAllDocs(){
    final List<Document> all = findAll();
    StringBuffer str = new StringBuffer();

    for (Document document : all)
    {
      str.append(document.getId() + " :" + document.getOriginalFileName() + "<br>");
    }

    return str.toString();
  }

  @Override
  public String getDocumentContentById(int id)
  {
    Document doc = xmlRepository.findById(id);
    return doc != null ? doc.getOriginalFileContent() : "Document with " + id + "not found";
  }
}
