package com.example.pg_db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller


public class Control {

  @Autowired
  private ProjRepo prepo;
  private ContRepo crepo;
  private static final Logger log = LoggerFactory.getLogger(Control.class);
//@Resource 



@GetMapping(path = "/projectList")

public @ResponseBody Iterable<Project> getProjects() {

    //prepo.findAll();
    //log.info(prepo.count()+"");
    /*for (Project project : prepo.findAll()) {
    log.info(project.getName()+" "+project.getStatus()+" "+project.getContacts().toString());
    }*/
    log.info(prepo.all().toString());
return null;//

}

@GetMapping(path = "/contactList")

public @ResponseBody Iterable<Contact> getContacts() {

    crepo.findAll();
    log.info(crepo.count()+"");
return null;

}
/**
 *
 * @author geek
 */

}