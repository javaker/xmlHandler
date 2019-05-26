

package ru.edisoft.testtask.service;

import java.util.List;

import ru.edisoft.testtask.entity.Document;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
public interface XmlService {

  List<Document> findAll();

  Document saveDocument(Document document);

  String getAllDocs();

  String getDocumentContentById(int id);
}
