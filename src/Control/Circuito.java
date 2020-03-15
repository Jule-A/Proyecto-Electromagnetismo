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
    private double atrCaidaVoltaje;
    private double atrCaidaCorriente;
    private Led atrLed;
    
    public void EstadoNuevo(float voltaje, double corriente){
        atrBateria.setVoltaje(voltaje);
        atrLed.EstadoNuevo(voltaje, corriente);
    }
    
    public Circuito(){
        atrBateria = new Fuente();
        atrEstado = false;
        atrLed = new Led();
    }
    
    public void Draw(Graphics g, int x, int y){
        g.clearRect(x, y, 400, 300);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 300, 200);
        atrBateria.Draw(g, x, (200/2)-10+y);
        atrLed.Draw(g, x+300, (200/2)-10+y);
    }
}
