package Control;

import Modelo.Fuente;
import Modelo.Led;
import Modelo.Potenciometro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Circuito {

    private Fuente atrBateria;

    private float atrCorrienteEnCircuito;

    private Led atrLed;

    private Potenciometro atrPot;

    public void EstadoNuevo(float voltaje, int resistencia) {
        this.atrBateria.EstadoNuevo(voltaje);
        this.atrPot.EstadoNuevo(resistencia);
        this.atrLed.EstadoNuevo(this.atrBateria.getAtrVoltajeActual(), this.atrPot.getAtrResistenciaActual());
        if (this.atrPot.getAtrResistenciaActual() > 0.0F) {
            this.atrCorrienteEnCircuito = voltaje / this.atrPot.getAtrResistenciaActual();
        } else {
            this.atrCorrienteEnCircuito = this.atrLed.getAtrCorriente();
        }
    }

    public Circuito() {
        this.atrBateria = new Fuente();
        this.atrLed = new Led();
        this.atrPot = new Potenciometro();
    }

    public void DibujarEstado(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.clearRect(x, y - 10, 150, 125);
        g.drawString("Voltaje de la Fuente", x, y);
        g.drawString("" + this.atrBateria.getAtrVoltajeActual(), x, y + 10);
        g.drawString("Resistencia del Potenciometro", x, y + 30);
        g.drawString("" + this.atrPot.getAtrResistenciaActual(), x, y + 40);
        g.drawString("Corriente en el Circuito", x, y + 60);
        g.drawString("" + this.atrCorrienteEnCircuito, x, y + 70);
        g.drawString("Resistencia del Necesaria", x, y + 90);
        g.drawString("para encender el Led", x, y + 100);
        g.drawString("" + this.atrLed.ResistenciaNecesaria(this.atrBateria.getAtrVoltajeActual()), x, y + 110);
    }

    public void DibujarCircuito(Graphics g, int x, int y) {
        try {
            File dirFichero = new File(".");
            String dirBase = dirFichero.getCanonicalPath();
            BufferedImage image = ImageIO.read(new File(dirBase + "\\Circuit_off.png"));
            g.drawImage(image, x, y, null);
            if (this.atrBateria.getAtrVoltajeActual() > 0.0F) {
                image = ImageIO.read(new File(dirBase + "\\Circuit_on.png"));
                g.drawImage(image, x, y, null);
            }
        } catch (IOException ex) {
            Logger.getLogger(Circuito.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        this.atrLed.Draw(g, 352 + x, 110 + y);
        this.atrPot.Draw(g, 220 + x, y);
    }

    public void DibujarInformacion(Graphics g, int x, int y) {
        try {
            File dirFichero = new File(".");
            String dirBase = dirFichero.getCanonicalPath();
            BufferedImage image = ImageIO.read(new File(dirBase + "\\Circuit_info.png"));
            g.drawImage(image, x, y, null);
        } catch (IOException ex) {
            Logger.getLogger(Circuito.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }
}
