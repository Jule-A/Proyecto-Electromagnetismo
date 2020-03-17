package Modelo;

import Control.Circuito;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Led {

    private float atrVoltaje = 4.0F;

    private float atrCorriente = 0.02F;

    private Color atrColor = new Color(200, 0, 0, 0);

    public float ResistenciaNecesaria(float voltaje) {
        return (voltaje - this.atrVoltaje) / this.atrCorriente;
    }

    public void EstadoNuevo(float voltaje, float resistencia) {
        float varResistenciaNecesaria = ResistenciaNecesaria(voltaje);
        if (voltaje >= this.atrVoltaje) {
            if (varResistenciaNecesaria == 0.0F) {
                int varAlpha = Math.round(250.0F / (resistencia + 1.0F));
                this.atrColor = new Color(200, 0, 0, varAlpha);
            } else if (resistencia < varResistenciaNecesaria) {
                this.atrColor = Color.BLACK;
            } else {
                int varAlpha = Math.round(varResistenciaNecesaria * 250.0F / resistencia);
                this.atrColor = new Color(200, 0, 0, varAlpha);
            }
        } else if (voltaje < this.atrVoltaje) {
            int varAlpha = Math.round(voltaje * 250.0F / this.atrVoltaje);
            this.atrColor = new Color(200, 0, 0, varAlpha);
        }
    }

    public void Draw(Graphics g, int x, int y) {
        try {
            File dirFichero = new File(".");
            String dirBase = dirFichero.getCanonicalPath();
            dirBase = dirBase + "\\Led_off.png";
            BufferedImage image = ImageIO.read(new File(dirBase));
            g.drawImage(image, x, y, null);
        } catch (IOException ex) {
            Logger.getLogger(Circuito.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        int[] varPuntosX = new int[3];
        varPuntosX[0] = x + 8;
        varPuntosX[1] = x + 42;
        varPuntosX[2] = x + 25;
        int[] varPuntosY = new int[3];
        varPuntosY[0] = y + 23;
        varPuntosY[1] = y + 23;
        varPuntosY[2] = y + 47;
        Polygon varPoly = new Polygon(varPuntosX, varPuntosY, 3);
        g.setColor(this.atrColor);
        g.fillPolygon(varPoly);
    }

    public float getAtrCorriente() {
        return this.atrCorriente;
    }
}
