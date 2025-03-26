package sassocartaforbice;

import java.awt.Image;
import java.awt.Point;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class objectTHR extends JLabel implements Runnable {

    public enum Tipo {
        SASSO,
        CARTA,
        FORBICE,
    }

    private Tipo type;
    private Point bounds = null;
    private Point newDestination;
    private Point destination;

    public objectTHR(Tipo type, Point bounds) {
        super();
        this.type = type;
        this.setSize(25, 25);
        this.bounds = bounds;
        setType(type);
        this.setLocation(new Random().nextInt(bounds.x - this.getWidth()), new Random().nextInt(bounds.y - this.getHeight()));
        newDestination = null;
    }

    public Tipo getType() {
        return this.type;
    }

    public Point getFormBounds() {
        return bounds;
    }

    public void setBounds(Point p) {
        bounds = p;
    }

    public void setType(Tipo type) {
        this.type = type;

        ImageIcon icon = null;
        switch (type) {
            case SASSO:
                icon = new javax.swing.ImageIcon(getClass().getResource("/sassocartaforbice/rock.png"));
                break;
            case CARTA:
                icon = new javax.swing.ImageIcon(getClass().getResource("/sassocartaforbice/paper.png"));
                break;
            case FORBICE:
                icon = new javax.swing.ImageIcon(getClass().getResource("/sassocartaforbice/scissor.png"));
                break;
        }

        if (icon != null) {
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            this.setIcon(icon);
        } else {
            System.err.println("Couldn't find image for type: " + type);
        }
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public boolean match(objectTHR o) {
        if (!o.getType().equals(this.type)) {
            switch (o.getType()) {
                case SASSO:
                    if (this.type.equals(Tipo.CARTA)) {
                        o.setType(Tipo.CARTA);
                    }
                    break;
                case CARTA:
                    if (this.type.equals(Tipo.FORBICE)) {
                        o.setType(Tipo.FORBICE);
                    }
                    break;
                case FORBICE:
                    if (this.type.equals(Tipo.SASSO)) {
                        o.setType(Tipo.SASSO);
                    }
                    break;
            }
//            Point p = this.getDestination();
//            this.newDestination(o.getDestination());
//            o.newDestination(p);
            return true;
        }
        return false;
    }

    public void newDestination(Point p) {
        this.newDestination = p;
    }

    public void newDestination() {
        this.newDestination = new Point(new Random().nextInt(bounds.x - this.getWidth()), new Random().nextInt(bounds.y - this.getHeight() * 2));
    }

    public Point getDestination() {
        return this.destination;
    }

    public void run() {
        while (true) {
            if(this.getLocation().x > bounds.x) {
                this.setLocation(bounds.x, getLocation().y);
            }
            if(this.getLocation().y > bounds.y) {
                this.setLocation(getLocation().x, bounds.y);
            }
            
            destination = new Point(new Random().nextInt(bounds.x - this.getWidth()), new Random().nextInt(bounds.y - this.getHeight() * 2));
            while (!this.getLocation().equals(destination)) {
                int offsetX = destination.x - this.getLocation().x;
                int offsetY = destination.y - this.getLocation().y;

                if (offsetX != 0) {
                    this.setLocation(this.getLocation().x + Integer.signum(offsetX), this.getLocation().y);
                }

                if (offsetY != 0) {
                    this.setLocation(this.getLocation().x, this.getLocation().y + Integer.signum(offsetY));
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(objectTHR.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
