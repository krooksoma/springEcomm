package com.example.demo.config;

import com.example.demo.entities.Product;
import com.example.demo.entities.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


//allow this to be scanned as a configuration parameter for the Spring project
@Configuration
public class MyRestConfig implements RepositoryRestConfigurer {

//    Select Implement method configureRepositoryRestConfiguration
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

//        Creates a list with HttpMethods to be Hidden
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};


//        Disable HTTP methods for Product: PUT, POST, DELETE -> leaves GET only
        config.getExposureConfiguration()
                .forDomainType(Product.class)//apply to repo Product
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) // Java Lambda Syntax - Single Item exposure
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); // Collection exposure


        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)//apply to repo Product
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) // Java Lambda Syntax - Single Item exposure
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); // Collection exposure

        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
    }
}
