package com.acc.prototype;

import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;



@SpringBootApplication
@ImportResource(locations = "jaxwsconfig.xml")
public class PrototypeApplication   {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PrototypeApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new WSSpringServlet(),
				"/getAll","/getValueByKey");
	}

}