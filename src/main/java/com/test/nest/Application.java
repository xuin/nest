package com.test.nest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new BasicService(), "/test");// ServletName默认值为首字母小写，即myServlet
	}

	@Bean
	public HessianProxyFactoryBean hessianProxyFactoryBean() {
		HessianProxyFactoryBean h = new HessianProxyFactoryBean();
		h.setServiceUrl("http://localhost:8088/test");
		h.setServiceInterface(TestHessian.class);
		return h;
	}
}
