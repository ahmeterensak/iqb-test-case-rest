package com.aes.iqbtestcaserest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.aes.iqbtestcaserest.model.Course;
import com.aes.iqbtestcaserest.model.ExamResult;
import com.aes.iqbtestcaserest.model.Student;

@Configuration
public class WebConfig implements RepositoryRestConfigurer {

        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
                HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE,
                                HttpMethod.PATCH };

                disableHttpMethods(Course.class, config, theUnsupportedActions);
                disableHttpMethods(ExamResult.class, config, theUnsupportedActions);
                disableHttpMethods(Student.class, config, theUnsupportedActions);

        }

        private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
                        HttpMethod[] theUnsupportedActions) {
                config.getExposureConfiguration()
                                .forDomainType(theClass)
                                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                                .withCollectionExposure(
                                                (metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        }
}
