package com.scg;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.scg.persistence")
public class DatabaseConfiguration {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(net.sf.log4jdbc.DriverSpy.class);
		dataSource.setUrl("jdbc:log4jdbc:mysql://14.63.220.208:16413/mom?autoReconnect=true&useSSL=false");
		dataSource.setUsername("app");
		dataSource.setPassword("mysql@pp");
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment        environment        = new Environment("scg", transactionFactory, dataSource());
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
		configuration.setMapUnderscoreToCamelCase(true);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return sqlSessionFactory;
	}
}