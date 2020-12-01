package com.hds.util;

import java.util.Properties;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;




public class HibernateUtil {


    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

                // README - update password before running to match user's authentication
                // Add database
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hds");
                // add user
                settings.put(Environment.USER, "root");
                // add password
                settings.put(Environment.PASS, "luke#1030");

                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                config.setProperties(settings);

                // CustomerPojo "test" change if necessary
                config.addAnnotatedClass(CustomerPojo.class);
                config.addAnnotatedClass(AddressPojo.class);

                ServiceRegistry sr = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties()).build();
                System.out.println("Service Registry created!!!!");
                sessionFactory = config.buildSessionFactory(sr);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}