package com.github.yangm.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.swagger.config 
 * @author: yangm
 * @date: 2018年8月9日
 * @email：1169290944@qq.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//生产环境闭关Swagger2
	@Value("${swagger2.enable}")
	private boolean swagger2Enable;
	
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.enable(swagger2Enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.yangm.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api文档")
                .description("api文档")
                .version("1.0")
                .build();
    }
}
