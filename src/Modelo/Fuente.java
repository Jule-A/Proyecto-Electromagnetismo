package Modelo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author julia
 */
public class Fuente {
    private float atrFuenteVoltaje;
    private float atrFuenteCorriente;
    
    public Fuente(){
        atrFuenteVoltaje = 5;
        atrFuenteCorriente = 0.5f;
    }
    
    public void setVoltaje(float voltaje){
        atrFuenteVoltaje = voltaje;        
    }
    
    public void Draw(Graphics g, int x, int y){
        g.setColor(Color.RED);
        g.drawString("+", x-20, y);
        g.drawString("_", x-20, y+10);
        g.setColor(Color.BLACK);
        g.clearRect(x, y, 10, 10);
        g.drawLine(x-10, y, x+10, y);
        g.drawLine(x-5, y+10, x+5, y+10);
    }
}
