package io.sstrategy.demo.dls.consumer;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * Observa que esta aplicación está definiendo @EnableJpaRepositories y @EntityScan. Esto es necesario porque
 * usa clases anotadas como @Repository y @Entity que no se encuentran en un paquete que descienda del
 * paquete de esta clase Application (porque pertenecen al proyecto librería).
 */

@ComponentScan(basePackages = "io.sstrategy")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.sstrategy.demo.dls")
@EntityScan(basePackages = "io.sstrategy.demo.dls")
public class DlsConsumerApplication {

	@Value("${connection.driver}")
	private String connectionDriver;
	
	@Value("${connection.url}")
	private String connectionUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(DlsConsumerApplication.class, args);
	}
	
    @Bean
    public DataSource dataSource() {
    	
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(connectionDriver);
        dataSource.setUrl(connectionUrl);
        
        return dataSource;
    }
	
}
