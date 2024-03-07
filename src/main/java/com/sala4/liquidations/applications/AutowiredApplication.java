package com.sala4.liquidations.applications;

import com.sala4.liquidations.example.BaseData;
import com.sala4.liquidations.models.Product;
import com.sala4.liquidations.models.ProductWarranty;
import com.sala4.liquidations.services.ILiquidationCalcService;
import com.sala4.liquidations.services.IRegisterRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sala4.liquidations.models.Warranty;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class AutowiredApplication {

    @Autowired
    private ILiquidationCalcService liquidationCalcService;
    @Autowired
    private IRegisterRiskService registerRiskService;


    public void run(){
        Scanner scanner = new Scanner(System.in);
        BaseData dataBase = new BaseData();

        while (true) {
            System.out.println("------ Menú de Opciones ------");
            System.out.println("1. Ingresar datos del siniestro");
            System.out.println("2. Calcular liquidación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    performSiniestroAlta(scanner,dataBase);
                    break;
                case 2:
                    Product product = getProductForLiquidation(scanner, dataBase);
                    calculateLiquidation(product);
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

    private  void calculateLiquidation(Product product) {
        if (product !=null) {
            double liquidationTotal= liquidationCalcService.liquidationCalculation(product);
            System.out.println("El importe total de liquidación es: " + liquidationTotal);
        } else {
            System.out.println("Primero ingrese los datos del siniestro.");
        }
    }

    private  Product getProductForLiquidation(Scanner scanner, BaseData dataBase) {
        System.out.println("Ingrese el código de producto:");
        String codigoProducto = scanner.next();
        return dataBase.getProducts().get(codigoProducto);
    }

    private Warranty getWarrantyForLiquidation(Scanner scanner, BaseData dataBase) {
        System.out.println("Ingrese el código de la garantía asociada al bien: ");
        String warrantyCode = scanner.nextLine();
        return dataBase.getWarranties().get(warrantyCode);
    }

    private Product performSiniestroAlta(Scanner scanner, BaseData dataBase) {
        // Ingresar datos básicos del siniestro y cliente
        System.out.println("Ingrese la fecha de ocurrencia del siniestro (YYYY-MM-DD): ");
        String fechaOcurrencia = scanner.next();
        System.out.println("Ingrese el nombre de la persona de contacto: ");
        String nombreContacto = scanner.next();
        System.out.println("Ingrese la dirección del siniestro: ");
        String direccionSiniestro = scanner.next();

        // Ingresar datos de la póliza afectada
        System.out.println("Ingrese el número de la póliza afectada: ");
        String numeroPoliza = scanner.next();

        // Ingresar listado de bienes afectados
        List<ProductWarranty> bienesAfectados = new ArrayList<>();
        while (true) {
            System.out.println("Ingrese el nombre del bien afectado (o 'fin' para terminar): ");
            String nombreBien = scanner.next();
            if (nombreBien.equalsIgnoreCase("fin")) {
                break;
            }
            Warranty newWarranty = getWarrantyForLiquidation(scanner, dataBase);
            System.out.println("Ingrese el valor a nuevo del bien: ");
            double valorNuevo = scanner.nextDouble();
            System.out.println("Ingrese el valor de compra inicial o valor de construcción inicial del bien: ");
            double valorInicial = scanner.nextDouble();
            System.out.println("Ingrese la antigüedad en años del bien: ");
            int antiguedad = scanner.nextInt();

            // Crear un objeto ProductWarranty con los datos ingresados
            ProductWarranty bienAfectado = new ProductWarranty(nombreBien, newWarranty, valorNuevo, valorInicial, antiguedad);
            bienesAfectados.add(bienAfectado);
        }

        // Ingresar valores de preexistencia
        System.out.println("Ingrese el valor de preexistencia de contenido: ");
        double preexistenciaContenido = scanner.nextDouble();
        System.out.println("Ingrese el valor de preexistencia de continente: ");
        double preexistenciaContinente = scanner.nextDouble();

        // Crear y retornar un objeto Product con los datos ingresados
        Product product = new Product(numeroPoliza, bienesAfectados, preexistenciaContenido, preexistenciaContinente);
        System.out.println("¡Alta de siniestro realizada con éxito!");
        return product;
    }
}
