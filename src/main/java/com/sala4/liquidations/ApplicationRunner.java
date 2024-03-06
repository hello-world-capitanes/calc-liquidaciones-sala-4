package com.sala4.liquidations;

import com.sala4.liquidations.applications.AutowiredApplication;
import com.sala4.liquidations.applications.ConstructorApplication;
import com.sala4.liquidations.applications.NewApplication;
import com.sala4.liquidations.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AutowiredApplication autowiredApplication = context.getBean(AutowiredApplication.class);
        AutowiredApplication.run();
    }
}
