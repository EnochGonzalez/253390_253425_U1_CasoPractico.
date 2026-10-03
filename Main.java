import java.util.Scanner;

public class Main {

    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE FLOTILLA ===");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Consultar vehículos");
        System.out.println("3. Filtrar vehículos disponibles");
        System.out.println("4. Asignar chofer a vehículo");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    public void iniciarPrograma() {
        Flotilla flotilla = new Flotilla();
        Scanner lector = new Scanner(System.in);
        int opcionMenu = 0;

        while (opcionMenu != 5) {
            mostrarMenu();
            try {
                opcionMenu = Integer.parseInt(lector.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Escribe un número del 1 al 5.");
                continue;
            }

            switch (opcionMenu) {
                case 1:
                    System.out.print("Placa: ");
                    String placaVehiculo = lector.nextLine().trim();
                    System.out.print("Kilometraje: ");
                    double kilometrajeVehiculo;
                    try {
                        kilometrajeVehiculo = Double.parseDouble(lector.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Kilometraje no válido.");
                        break;
                    }
                    if (placaVehiculo.isEmpty() || kilometrajeVehiculo < 0) {
                        System.out.println("Datos no válidos.");
                        break;
                    }
                    if (flotilla.registrarVehiculo(new Vehiculo(placaVehiculo, kilometrajeVehiculo))) {
                        System.out.println("Vehículo registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar: flotilla llena o placa repetida.");
                    }
                    break;

                case 2:
                    flotilla.consultarVehiculos();
                    break;

                case 3:
                    Vehiculo[] vehiculosDisponibles = flotilla.filtrarVehiculosDisponibles();
                    if (vehiculosDisponibles.length == 0) {
                        System.out.println("No hay vehículos disponibles.");
                    } else {
                        System.out.println("Vehículos disponibles:");
                        for (int i = 0; i < vehiculosDisponibles.length; i++) {
                            System.out.println("Placa: " + vehiculosDisponibles[i].obtenerPlacaVehiculo()
                                    + " | Km: " + vehiculosDisponibles[i].obtenerKilometrajeVehiculo());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Placa del vehículo: ");
                    String placaAsignar = lector.nextLine().trim();
                    System.out.print("Nombre completo del chofer: ");
                    String nombreCompletoChofer = lector.nextLine().trim();
                    System.out.print("Número de licencia: ");
                    String numeroLicenciaChofer = lector.nextLine().trim();
                    if (placaAsignar.isEmpty() || nombreCompletoChofer.isEmpty() || numeroLicenciaChofer.isEmpty()) {
                        System.out.println("Todos los campos son obligatorios.");
                        break;
                    }
                    Chofer choferNuevo = new Chofer(nombreCompletoChofer, numeroLicenciaChofer);
                    if (flotilla.asignarChoferAVehiculo(placaAsignar, choferNuevo)) {
                        System.out.println("Chofer asignado. El vehículo ahora está ocupado.");
                    } else {
                        System.out.println("No se pudo asignar: la placa no existe o el vehículo ya está ocupado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Escribe un número del 1 al 5.");
            }
        }
        lector.close();
    }

    public static void main(String[] args) {
        Main programa = new Main();
        programa.iniciarPrograma();
    }
}