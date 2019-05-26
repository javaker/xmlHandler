

package ru.edisoft.testtask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.edisoft.testtask.entity.Document;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
public interface XmlRepository extends JpaRepository<Document, Integer> {

  Document findById(int id);
}
