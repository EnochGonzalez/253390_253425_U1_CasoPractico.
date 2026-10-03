public class Flotilla {
    private final int capacidadMaximaFlotilla = 5;
    private Vehiculo[] unidadesRegistradas = new Vehiculo[capacidadMaximaFlotilla];
    private int totalUnidadesRegistradas = 0;

    public boolean registrarVehiculo(Vehiculo vehiculo) {
        if (totalUnidadesRegistradas >= capacidadMaximaFlotilla) {
            return false; // flotilla llena
        }
        if (buscarVehiculoPorPlaca(vehiculo.obtenerPlacaVehiculo()) != null) {
            return false; // placa repetida
        }
        unidadesRegistradas[totalUnidadesRegistradas] = vehiculo;
        totalUnidadesRegistradas++;
        return true;
    }

    public Vehiculo buscarVehiculoPorPlaca(String placaVehiculo) {
        for (int i = 0; i < totalUnidadesRegistradas; i++) {
            if (unidadesRegistradas[i].obtenerPlacaVehiculo().equalsIgnoreCase(placaVehiculo)) {
                return unidadesRegistradas[i];
            }
        }
        return null; // no encontrado
    }

    public void consultarVehiculos() {
        if (totalUnidadesRegistradas == 0) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (int i = 0; i < totalUnidadesRegistradas; i++) {
            Vehiculo v = unidadesRegistradas[i];
            System.out.println("Placa: " + v.obtenerPlacaVehiculo()
                    + " | Km: " + v.obtenerKilometrajeVehiculo()
                    + " | Estatus: " + v.obtenerEstatusVehiculo());
            if (v.obtenerChoferVehiculo() != null) {
                System.out.println("   Chofer: " + v.obtenerChoferVehiculo().obtenerNombreCompletoChofer()
                        + " | Licencia: " + v.obtenerChoferVehiculo().obtenerNumeroLicenciaChofer());
            }
        }
    }

    public Vehiculo[] filtrarVehiculosDisponibles() {
        int totalDisponibles = 0;
        for (int i = 0; i < totalUnidadesRegistradas; i++) {
            if (unidadesRegistradas[i].verificarDisponibilidadVehiculo()) {
                totalDisponibles++;
            }
        }
        Vehiculo[] vehiculosDisponibles = new Vehiculo[totalDisponibles];
        int posicion = 0;
        for (int i = 0; i < totalUnidadesRegistradas; i++) {
            if (unidadesRegistradas[i].verificarDisponibilidadVehiculo()) {
                vehiculosDisponibles[posicion] = unidadesRegistradas[i];
                posicion++;
            }
        }
        return vehiculosDisponibles;
    }

    public boolean asignarChoferAVehiculo(String placaVehiculo, Chofer choferVehiculo) {
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placaVehiculo);
        if (vehiculo == null) {
            return false; // placa no existe
        }
        if (!vehiculo.verificarDisponibilidadVehiculo()) {
            return false; // ya está ocupado
        }
        vehiculo.asignarChoferVehiculo(choferVehiculo);
        return true;
    }
}