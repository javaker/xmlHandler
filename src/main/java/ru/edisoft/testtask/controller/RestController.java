

package ru.edisoft.testtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.edisoft.testtask.service.XmlService;

/**
 * @author viacheslav.iakovitskii@novardis.com
 * Created on 5/26/19
 */
@Controller
public class RestController
{
  @Autowired
  XmlService xmlService;

  @RequestMapping(value = "docs", method = RequestMethod.GET)
  @ResponseBody
  public String showIndex() {
    return xmlService.getAllDocs();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
  @ResponseBody
  public String getDocById(@PathVariable int id)
  {
    return xmlService.getDocumentContentById(id);
  }
}
