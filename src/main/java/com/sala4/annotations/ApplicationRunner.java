package com.sala4.annotations;

import com.sala4.annotations.applications.AutowiredApplication;
import com.sala4.annotations.applications.ConstructorApplication;
import com.sala4.annotations.applications.NewApplication;
import com.sala4.annotations.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Ejecución con inyección de dependencias usando new");
        NewApplication application = new NewApplication();
        application.sendMail("sergio@devanddel.com","Recordatorio","Recuerda que tienes que hacer el ejercicio de hoy.");
        System.out.println("--------------------");

        System.out.println("Ejecución con inyección de dependencias usando constructor");
        ConstructorApplication constructorApplication = context.getBean(ConstructorApplication.class);
        constructorApplication.sendMail("sergio@devanddel.com","Recordatorio","Recuerda que tienes que hacer el ejercicio de hoy.");
        System.out.println("--------------------");

        System.out.println("Ejecución con inyección de dependencias usando @Autowired");
        AutowiredApplication autowiredApplication = context.getBean(AutowiredApplication.class);
        autowiredApplication.sendMail("sergio@devanddel.com","Recordatorio","Recuerda que tienes que hacer el ejercicio de hoy.");
        System.out.println("--------------------");
    }
}
