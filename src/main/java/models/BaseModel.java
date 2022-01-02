package models;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BaseModel {
    public SessionFactory sessionFactoryForHibernateConnections = null;
    public String configurationFilePath = "/Users/estefaniarv/NetBeansProjects/sodas/src/main/resources/hibernate.cfg.xml";
    
    private Class calledClass = null;
    
    public BaseModel(){
        this.prepareSessionFactory();
    }
    
    public BaseModel(Class calledClass){
        this.prepareSessionFactory();
        this.calledClass = calledClass;
    }
    
    public void prepareSessionFactory(){
        File configFile = new File(this.configurationFilePath);
        
        StandardServiceRegistry registryForHibernate = 
                new StandardServiceRegistryBuilder()
                    .configure(configFile)
                    .build();
        
        this.sessionFactoryForHibernateConnections = 
                new MetadataSources(registryForHibernate)
                    .buildMetadata()
                    .buildSessionFactory();
    }
    
    public Session createSession(){
        return this.sessionFactoryForHibernateConnections.openSession();
    }

    public Object show(int id){
        Object instance;
        try (Session session = this.createSession()) {
            session.beginTransaction();
            instance = session.find(this.getCalledClass(),  id);
            session.getTransaction().commit();
        }
        return instance;
    }

    public static BaseModel withClass(Class c){
        return new BaseModel(c);
    }
    
    public Class getCalledClass() {
        return calledClass;
    }

    public void setCalledClass(Class calledClass) {
        this.calledClass = calledClass;
    }
    
    
}
