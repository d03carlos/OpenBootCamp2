package LadyKF;

import javax.swing.JFrame;

public class Game extends JFrame {
    public Game() {
        setTitle("Lady Killer Arcade");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configurar y agregar el GamePanel (clase que extiende JPanel) al JFrame
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Game();
    }
}
