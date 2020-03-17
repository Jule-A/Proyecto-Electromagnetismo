package Modelo;

public class Fuente {

    private final float atrVoltajeMaximo = 10.0F;

    private final float atrCorrienteMaxima = 0.5F;

    private float atrVoltajeActual = 0.0F;

    public void EstadoNuevo(float voltaje) {
        if (voltaje <= this.atrVoltajeMaximo) {
            this.atrVoltajeActual = voltaje;
        }
    }

    public float getAtrVoltajeActual() {
        return this.atrVoltajeActual;
    }
}
