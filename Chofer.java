public class Chofer {
    private String nombreCompletoChofer;
    private String numeroLicenciaChofer;

    public Chofer(String nombreCompletoChofer, String numeroLicenciaChofer) {
        this.nombreCompletoChofer = nombreCompletoChofer;
        this.numeroLicenciaChofer = numeroLicenciaChofer;
    }

    public String obtenerNombreCompletoChofer() {
        return nombreCompletoChofer;
    }

    public String obtenerNumeroLicenciaChofer() {
        return numeroLicenciaChofer;
    }
}