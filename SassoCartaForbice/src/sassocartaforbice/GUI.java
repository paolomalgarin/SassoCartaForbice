package sassocartaforbice;

import java.awt.Point;

public class GUI extends javax.swing.JFrame {

    // Variables declaration - do not modify
    GestoreTipo g;
    private int objects4each = 2000;
    private Point p;
    // End of variables declaration  

    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(35, 45, 79, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/sassocartaforbice/icon.png")).getImage());
        setTitle("SASSO CARTA FORBICE");
        getContentPane().setLayout(null);
        setBounds(500, 500, 500, 500);
        this.setLocationRelativeTo(null);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                p.x = ((GUI) (evt.getSource())).getWidth();
                p.y = ((GUI) (evt.getSource())).getHeight();
//                System.out.println("RESIZE " + p);
            }
        });

        g = new GestoreTipo(this);
        p = new Point(this.getWidth(), this.getHeight());

        for (int i = 0; i < objects4each; i++) {
            objectTHR t = new objectTHR(objectTHR.Tipo.SASSO, p);
            getContentPane().add(t);
            g.add(t);
            t.setVisible(true);
            new Thread(t).start();
        }
        for (int i = 0; i < objects4each; i++) {
            objectTHR t = new objectTHR(objectTHR.Tipo.CARTA, p);
            getContentPane().add(t);
            g.add(t);
            t.setVisible(true);
            new Thread(t).start();
        }
        for (int i = 0; i < objects4each; i++) {
            objectTHR t = new objectTHR(objectTHR.Tipo.FORBICE, p);
            getContentPane().add(t);
            g.add(t);
            t.setVisible(true);
            new Thread(t).start();
        }
        g.start();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
