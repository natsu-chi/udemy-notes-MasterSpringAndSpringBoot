package com.chi.learnspringframework5;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component (Spring ver.)
@Named // Jakarta ver.
class BusinessService {
    private DataService dataService;

    BusinessService() {
        this.dataService = new DataService();
    }

    public DataService getBusinessService() {
        return this.dataService;
    }

    // @Autowired (Spring ver.)
    @Inject // Jakarta ver.
    public void setBusinessService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

}

@Component
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
            context.getBean(BusinessService.class);
        }
    }

}
