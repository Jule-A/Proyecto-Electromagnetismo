package Control;

import Modelo.Fuente;
import Modelo.Led;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author julia
 */
public class Circuito {    
    private Fuente atrBateria;
    private boolean atrEstado;
    private float atrCaidaVoltaje;
    private float atrCaidaCorriente;
    private Led atrLed;
    private float atrResistencia;
    
    public void EstadoNuevo(float voltaje, float corriente, float resistencia){
        atrBateria.setVoltaje(voltaje);
        atrLed.EstadoNuevo(voltaje, corriente, atrResistencia + resistencia);
    }
    
    public Circuito(){
        atrBateria = new Fuente();
        atrEstado = false;
        atrLed = new Led();
        atrResistencia = 300;
    }
    
    public void Draw(Graphics g, int x, int y){
        g.clearRect(x, y, 400, 300);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 300, 200);
        atrBateria.Draw(g, x, (200/2)-10+y);
        atrLed.Draw(g, x+300, (200/2)-10+y);
    }
}
