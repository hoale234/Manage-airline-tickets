package fa.training.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Configuration class for Spring MVC and Hibernate.
 * 
 * This class configures various aspects of Spring MVC and Hibernate, including view resolution, resource handling,
 * database connection, transaction management, and more.
 * 
 * @Author HoaLD6
 * Date of Birth: 03/04/2000
 * @since Aug 28, 2023
 */
@Configuration
@ComponentScan(basePackages = { "fa.training" })
@EnableWebMvc
@PropertySource({ "classpath:database.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "fa.training.respostory" })
public class MVCconfig implements WebMvcConfigurer {
    /**
     * Configures the internal resource view resolver.
     * 
     * @return An InternalResourceViewResolver object.
     * @Author HoaLD6
     * Date of Birth: 03/04/2000
     * @since Aug 28, 2023
     */
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resourceView = new InternalResourceViewResolver();
        resourceView.setViewClass(JstlView.class);
        resourceView.setPrefix("/WEB-INF/views/");
        resourceView.setSuffix(".jsp");
        return resourceView;
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("WebMvcConfig - addResourceHandlers");
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("configureDefaultServletHandling");
        configurer.enable();
    }

    @Autowired
    private Environment environment;

    @Bean("sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "fa.training.entities" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean("dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    /**
     * Creates the EntityManagerFactory bean for JPA.
     * 
     * @param dataSource The DataSource object.
     * @return A LocalContainerEntityManagerFactoryBean object.
     * @Author HoaLD6
     * Date of Birth: 03/04/2000
     * @since Aug 28, 2023
     */
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean obj = new LocalContainerEntityManagerFactoryBean();
        obj.setDataSource(dataSource);
        obj.setPackagesToScan("fa.training.entities");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true); // setting đè giá trị dòng show_sql ở dưới
        obj.setJpaVendorAdapter(adapter);

        Properties properties = new Properties();
        // Environment.SHOW_SQL;
        properties.setProperty("hibernate.show_sql", "true");
        obj.setJpaProperties(properties);

        return obj;
    }
    /**
     * Creates the JpaTransactionManager bean for handling JPA transactions.
     * 
     * @param entityManagerFactory The EntityManagerFactory object.
     * @return A JpaTransactionManager object.
     * @Author HoaLD6
     * Date of Birth: 03/04/2000
     * @since Aug 28, 2023
     */
    @Bean("transactionManager")
    public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager obj = new JpaTransactionManager();
        obj.setEntityManagerFactory(entityManagerFactory);
        return obj;
    }
}
