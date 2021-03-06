package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Admin;
import com.app.model.Agent;
import com.app.model.Company;
import com.app.model.Customer;
import com.app.model.OrderType;
import com.app.model.PurchaseShares;
import com.app.model.Share;
import com.app.model.SharesAvailable;
import com.app.model.TermValidity;

@Configuration
@ComponentScan(basePackages="com.app")
@EnableWebMvc
//@EnableWebSecurity
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
//@Import(SecurityConfig.class)
public class AppConfig {
	@Autowired
	private Environment env;
	
	//1. DataSource Bean
			@Bean  //=> @Bean creating Object
			public BasicDataSource dsObj() {
				BasicDataSource ds=new BasicDataSource();
				ds.setDriverClassName(env.getProperty("driver"));
				ds.setUrl(env.getProperty("url"));
				ds.setUsername("root");
				ds.setPassword("uday");
				ds.setInitialSize(5);
				ds.setMaxIdle(5);
				ds.setMinIdle(3);
				ds.setMaxTotal(5);
				return ds;
			}
			
			//2. SessionFactory Bean
			@Bean  //=> creating Object
			public LocalSessionFactoryBean sfObj() {
				LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
				sf.setDataSource(dsObj());
				sf.setAnnotatedClasses(Admin.class,Agent.class,Company.class,Share.class,Customer.class,TermValidity.class,OrderType.class,PurchaseShares.class,SharesAvailable.class);
				sf.setHibernateProperties(props());
				return sf;
			}
			/*Hibernate Properties*/
			@Bean
			public Properties props() {
				Properties p=new Properties();
				p.put("hibernate.dialect",env.getProperty("dialect"));
				p.put("hibernate.show_sql","true");
				p.put("hibernate.format_sql","true");
				p.put("hibernate.hbm2ddl.auto",env.getProperty("ddl"));
				return p;
			}
			
			//3. HibernateTemplate Bean
			@Bean
			public HibernateTemplate htObj() {
				HibernateTemplate ht=new HibernateTemplate();
				ht.setSessionFactory(sfObj().getObject());
				return ht;
			}
			
			//4. HibernateTxManager Bean
			@Bean
			public HibernateTransactionManager htxm() {
				HibernateTransactionManager htm=new HibernateTransactionManager();
				htm.setSessionFactory(sfObj().getObject());
				return htm;
			}
			
			
			//5. ViewResolver Bean
			@Bean
			public InternalResourceViewResolver ivr() {
				InternalResourceViewResolver vr=new InternalResourceViewResolver();
				vr.setPrefix(env.getProperty("mvc.prefix"));
				vr.setSuffix(env.getProperty("mvc.suffix"));
				return vr;
			}
			
			//6. multipart Resolver
			@Bean
			public CommonsMultipartResolver multipartResolver() {
				return new CommonsMultipartResolver();
			}
}
