package example.config.util;

import example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.criterion.Property;

import java.util.Properties;

public class DBConfig {
    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "Luxal.99");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        configuration.setProperties(settings);

        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Bank.class);
        configuration.addAnnotatedClass(Transaction.class);
        configuration.addAnnotatedClass(TypeOfTransaction.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserType.class);
        sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
