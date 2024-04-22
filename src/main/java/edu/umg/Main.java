package edu.umg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Establecer la conexión con MongoDB
        String connectionString = "mongodb://localhost:27017";
        String databaseName = "TelefonosCrud";
        String collectionName = "TeleCrud";
        TelefonoDAO telefonoDAO = new TelefonoDAO(connectionString, databaseName, collectionName);

        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Menú de opciones
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar Teléfono");
            System.out.println("2. Actualizar Teléfono");
            System.out.println("3. Eliminar Teléfono");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar Teléfono
                    Telefono nuevoTelefono = ingresarTelefonoDesdeConsola(scanner);
                    telefonoDAO.insertTelefono(nuevoTelefono);
                    System.out.println("Teléfono agregado correctamente.");
                    break;
                case 2:
                    // Actualizar Teléfono
                    System.out.print("Ingrese el IMEI del teléfono a actualizar: ");
                    String imeiActualizar = scanner.nextLine();
                    Telefono telefonoActualizar = ingresarTelefonoDesdeConsola(scanner);
                    telefonoDAO.updateTelefono(imeiActualizar, telefonoActualizar);
                    System.out.println("Teléfono actualizado correctamente.");
                    break;
                case 3:
                    // Eliminar Teléfono
                    System.out.print("Ingrese el IMEI del teléfono a eliminar: ");
                    String imeiEliminar = scanner.nextLine();
                    telefonoDAO.deleteTelefono(imeiEliminar);
                    System.out.println("Teléfono eliminado correctamente.");
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);

        // Cerrar el Scanner
        scanner.close();
    }

    // Método para ingresar un teléfono desde la consola
    private static Telefono ingresarTelefonoDesdeConsola(Scanner scanner) {
        System.out.print("Ingrese la marca del teléfono: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del teléfono: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el sistema operativo del teléfono: ");
        String sistemaOperativo = scanner.nextLine();
        System.out.print("Ingrese el tamaño de pantalla del teléfono: ");
        double tamanoPantalla = scanner.nextDouble();
        System.out.print("Ingrese la memoria RAM del teléfono: ");
        int memoriaRAM = scanner.nextInt();
        System.out.print("Ingrese el almacenamiento interno del teléfono: ");
        int almacenamientoInterno = scanner.nextInt();
        System.out.print("El teléfono tiene cámara (true/false): ");
        boolean tieneCamara = scanner.nextBoolean();
        System.out.print("Ingrese la resolución de la cámara del teléfono: ");
        double resolucionCamara = scanner.nextDouble();
        System.out.print("El teléfono es un smartphone (true/false): ");
        boolean esSmartphone = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el IMEI del teléfono: ");
        String imei = scanner.nextLine();

        // Crear y devolver un objeto Telefono con los datos ingresados
        return new Telefono(marca, modelo, sistemaOperativo, tamanoPantalla, memoriaRAM,
                almacenamientoInterno, tieneCamara, resolucionCamara,
                esSmartphone, imei);
    }
}
