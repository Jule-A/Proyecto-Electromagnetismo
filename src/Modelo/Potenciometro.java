package Modelo;

import Control.Circuito;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Potenciometro {

    private final float atrResistenciaTotal = 1000.0F;

    private float atrResistenciaActual = 0.0F;

    private int atrPosVector = 0;

    public void EstadoNuevo(int posVector) {
        if (posVector >= 0 && posVector <= 100) {
            this.atrPosVector = posVector;
            this.atrResistenciaActual = this.atrPosVector * this.atrResistenciaTotal / 100.0F;
        }
    }

    public void Draw(Graphics g, int x, int y) {
        try {
            File dirFichero = new File(".");
            String dirBase = dirFichero.getCanonicalPath();
            BufferedImage image = ImageIO.read(new File(dirBase + "\\Pot_res.png"));
            g.drawImage(image, x, y, null);
            image = ImageIO.read(new File(dirBase + "\\Pot_f.png"));
            g.drawImage(image, x + this.atrPosVector, y + 50, null);
        } catch (IOException ex) {
            Logger.getLogger(Circuito.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }

    public float getAtrResistenciaActual() {
        return this.atrResistenciaActual;
    }
}
