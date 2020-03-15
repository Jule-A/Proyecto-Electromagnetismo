package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author julia
 */
public class Led {
    private float atrVoltaje;
    private float atrCorriente;
    private Color atrColor;
    
    public Led(){
        atrVoltaje = 4;
        atrCorriente = 0.02f;
        atrColor = new Color(200, 0, 0, 0);
    }
    
    public void EstadoNuevo(float voltaje, float corriente, float resistencia){
        if (voltaje >= atrVoltaje) {
            float varResistenciaNecesaria = (voltaje - atrVoltaje) / atrCorriente;
            if (resistencia < varResistenciaNecesaria) {
                atrColor = Color.BLACK;
            } else {
                int varAlpha = Math.round((varResistenciaNecesaria * 250) / resistencia);
                atrColor = new Color(200, 0, 0, varAlpha);
            }
        }
    }
    
    public void Draw(Graphics g, int x, int y){
        g.clearRect(x, y, 20, 30);
        int[] varPuntosX = new int[3];
        varPuntosX[0] = x-20;
        varPuntosX[1] = x+20;
        varPuntosX[2] = x;
        int[] varPuntosY = new int[3];
        varPuntosY[0] = y;
        varPuntosY[1] = y;
        varPuntosY[2] = y+30;
        Polygon varPoly = new Polygon(varPuntosX,varPuntosY,3);
        g.setColor(atrColor);
        g.fillPolygon(varPoly);
        g.setColor(Color.BLACK);
        g.drawPolygon(varPoly);
        g.drawLine(x-20, y+30, x+20, y+30);
    }
}
