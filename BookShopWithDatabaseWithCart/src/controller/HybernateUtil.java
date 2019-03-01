package controller;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HybernateUtil {
	private static SessionFactory sessionfactory; //only 1 per web app.
	
	private HybernateUtil() {}
	
	static {
		Configuration config=new Configuration().configure();
		
		config.addAnnotatedClass(model.Book.class);
		
		StandardServiceRegistryBuilder builder= 
				new StandardServiceRegistryBuilder().applySettings(config.getProperties());
	
		sessionfactory=config.buildSessionFactory(builder.build());
	}	
	
	protected static SessionFactory getSessionFactory() {
		return sessionfactory;
	}
}
