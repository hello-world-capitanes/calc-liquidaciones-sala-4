package com.sala4.liquidations.applications;

import com.sala4.liquidations.services.ILiquidationCalcService;
import com.sala4.liquidations.services.IRegisterRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AutowiredApplication {

    @Autowired
    private ILiquidationCalcService liquidationCalcService;
    @Autowired
    private IRegisterRiskService registerRiskService;

    public static void run(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------ Menú de Opciones ------");
            System.out.println("1. Ingresar datos del siniestro");
            System.out.println("2. Calcular liquidación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    break;
                case 2:
                    if (true) {

                        System.out.println("El importe total de liquidación es: " );
                    } else {
                        System.out.println("Primero ingrese los datos del siniestro.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida, por favor seleccione nuevamente.");
                    break;
            }
        }
    }
}
