package com.example.pg_db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Iterator;
import java.util.Properties;

@SpringBootApplication
public class PgDbApplication {
    private static SessionFactory factory;
    private static Configuration c = new Configuration();
       
    private static final Logger log = LoggerFactory.getLogger(PgDbApplication.class);


	public static void main(String[] args) {
            
            try {
                
                Properties props = new Properties();
                
                props.setProperty("spring.jpa.hibernate.ddl-auto", "none");
                props.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                props.setProperty("spring.datasource.url", "jdbc:postgresql://localhost:5432/DB");
                props.setProperty("spring.datasource.username", "postgres");
                props.setProperty("spring.datasource.password", "pg_gfhjkm");
                props.setProperty("spring.jpa.show-sql", "true");
                c.addProperties(props);
                //c.configure(configFile)
            /*factory = new Configuration().addAnnotatedClass(Project.class).buildSessionFactory();*/
                } catch (Throwable ex) { 
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex); 
                }
            
        PgDbApplication app = new PgDbApplication();
            String[] s;
            String s1="";
            //Configuration c = new Configuration();
            //s=c.getProperty("java.class.path").split(":");
            c.getProperties().forEach((a,b) -> log.info(a+"  ---  "+b+"\n"));
            //List l = c.getProperties().entrySet();
           // Properties p = new Configuration().getProperties();
            //for (String s2 : s) {log.info(" "+s2+"\n");};
            
       //log.info("Dialect - "+c.getProperty("hibernate.connection.datasource"));
        
        //app.listP();
            
        
            
		//SpringApplication.run(PgDbApplication.class, args);
	};

//@Bean
/* public CommandLineRunner demo(ProjRepo rep1, ContRepo rep2) {
    return (args) -> {
        for (Project project : rep1.findAll()) {
            String conts = "";
            List<Integer> temp = project.getContacts();
            //log.info(project.toString());
            //log.info(String.valueOf(temp));
            //for (Integer c : temp) conts+=c.toString();
        //log.info(rep1.all().toString());
            
        //log.info(project.getId().toString()+project.getName()+project.getStatus()+conts);
      //};
        for (Contact contact : rep2.findAll()) {
        log.info(contact.toString());
        log.info(contact.getId().toString()+contact.getName()+contact.getEmail()+contact.getPhone()+"\n");
      }
        //log.info("");
    };
}
*/
            public void listP() {
       
                
        Session session = factory.openSession();
        Transaction tx = null;
      
        try {
         tx = session.beginTransaction();
         List projects = session.createQuery("FROM projects").list(); 
         for (Iterator iterator = projects.iterator(); iterator.hasNext();){
            Project project = (Project) iterator.next(); 
            System.out.print("Title: " + project.getName()); 
            System.out.print("  Status: " + project.getStatus()); 
            System.out.println("  Contacts: " + project.getContacts().toString()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
                
            };
            
}
