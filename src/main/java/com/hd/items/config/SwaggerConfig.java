package com.hd.items.config;

import com.hd.items.constants.CommonConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Configuration
@EnableSwagger2
@Profile("!junit")
public class SwaggerConfig implements CommonConstants {

	@Resource
	public Environment ENV;

	@Bean
	public Docket api() {

		Boolean swaggerEnabled = false;
		// setting default if LCP is not set in env
		if (SWAGGER_ENABLED_ENV.contains(ENV.getProperty(LCP) != null ? ENV.getProperty(LCP).toUpperCase() : STAGING)) {
			swaggerEnabled = true;
		}

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.homedepot.dsdat.controller")).paths(PathSelectors.any())
				.build().directModelSubstitute(Timestamp.class, String.class).enable(swaggerEnabled);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("DSDAT").description("DSDAT Services").license("The Home Depot 2018")
				.version("1.0.0").build();
	}
}