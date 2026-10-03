public class Vehiculo {
    private String placaVehiculo;
    private double kilometrajeVehiculo;
    private String estatusVehiculo;
    private Chofer choferVehiculo;

    public Vehiculo(String placaVehiculo, double kilometrajeVehiculo) {
        this.placaVehiculo = placaVehiculo;
        this.kilometrajeVehiculo = kilometrajeVehiculo;
        this.estatusVehiculo = "disponible";
        this.choferVehiculo = null;
    }

    public String obtenerPlacaVehiculo() {
        return placaVehiculo;
    }

    public double obtenerKilometrajeVehiculo() {
        return kilometrajeVehiculo;
    }

    public String obtenerEstatusVehiculo() {
        return estatusVehiculo;
    }

    public Chofer obtenerChoferVehiculo() {
        return choferVehiculo;
    }

    public void asignarChoferVehiculo(Chofer choferVehiculo) {
        this.choferVehiculo = choferVehiculo;
        this.estatusVehiculo = "ocupado";
    }

    public boolean verificarDisponibilidadVehiculo() {
        return estatusVehiculo.equals("disponible");
    }
}
