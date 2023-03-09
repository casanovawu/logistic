package com.suzz.platform.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enabled:true}")
public class Swagger2Config {
	
	@Autowired
	private Environment env;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
    	Contact contact = new Contact("suso","http://www.sualpha.com","www.suso@qq.com");
    	String path = env.getProperty("server.servlet.context-path");
        return new ApiInfoBuilder()
                .title("RESTful APIs for "+" App")
                .description("api根地址：http://www.sualpha.com"+path)
                .termsOfServiceUrl("https://www.sualpha.com/")
                .contact(contact)
                .version("2.0")
                .build();
    }
}
