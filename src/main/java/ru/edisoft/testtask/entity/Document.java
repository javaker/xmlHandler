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

package ru.edisoft.testtask.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/25/19
 */
@Getter
@Setter
@Entity
@Table(name = "testDB.documents")
public class Document
{
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name= "increment", strategy= "increment")
  @Column(name = "id", length = 6, nullable = false)
  int id;

  @Column(name = "original_file_name")
  String originalFileName;

  @Column(name = "date_receive")
  Date dateReceive;

  @Column(name = "original_file_content")
  String originalFileContent;

  @Column(name = "transform_file_content")
  String transformFileContent;
}
