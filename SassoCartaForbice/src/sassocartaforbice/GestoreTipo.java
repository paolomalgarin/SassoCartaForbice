package sassocartaforbice;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sassocartaforbice.objectTHR.Tipo;

public class GestoreTipo extends Thread {

    private ArrayList<objectTHR> thrs;
    private GUI frame;

    public GestoreTipo(GUI frame) {
        thrs = new ArrayList();
        this.frame = frame;
    }

    public void add(objectTHR o) {
        this.thrs.add(o);
    }

    public boolean isAllSameType() {
        if (thrs.get(0) != null) {
            objectTHR.Tipo tipo = thrs.get(0).getType();

            for (objectTHR thr : thrs) {
                if (!thr.getType().equals(tipo)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void resetAll() {
        switch (thrs.get(0).getType()) {
            case SASSO:
                JOptionPane.showMessageDialog(null, "HA VINTO SASSO!", "FINE!", JOptionPane.PLAIN_MESSAGE);
                break;
            case CARTA:
                JOptionPane.showMessageDialog(null, "HA VINTO CARTA!", "FINE!", JOptionPane.PLAIN_MESSAGE);
                break;
            case FORBICE:
                JOptionPane.showMessageDialog(null, "HA VINTO FORBICE!", "FINE!", JOptionPane.PLAIN_MESSAGE);
                break;
        }

        int i = 0;
        int size = thrs.size();
        Tipo t = Tipo.CARTA;

        for (objectTHR thr : thrs) {
            thr.setType(t);

            i++;

            if (i < size / 3) {
                t = Tipo.CARTA;
            } else if (i < size / 3 * 2) {
                t = Tipo.FORBICE;
            } else {
                t = Tipo.SASSO;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            if (isAllSameType()) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(GestoreTipo.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                resetAll();
            } else {
                for (objectTHR thr1 : thrs) {
                    for (objectTHR thr2 : thrs) {
                        if ((thr1.getLocation().x < thr2.getLocation().x + thr2.getWidth() && thr1.getLocation().x + thr1.getWidth() > thr2.getLocation().x) && (thr1.getLocation().y + thr1.getHeight() < thr2.getLocation().y + thr2.getHeight() && thr1.getLocation().y + thr1.getHeight() > thr2.getLocation().y)) {
                            thr1.match(thr2);
                        }
                    }
                }
            }
        }
    }

}
