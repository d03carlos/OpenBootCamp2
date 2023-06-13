package MissW2023f;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Image backgroundImage;
    private Image silhouetteImage;
    private Rectangle silhouetteRect;
    private int revealedArea;
    private int lives;
    private boolean isGameOver;

    public Game() {
        super("Arcade Game");

        // Configurar la ventana del juego
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Cargar las imágenes de fondo y silueta
        backgroundImage = new ImageIcon("background.jpg").getImage();
        silhouetteImage = new ImageIcon("silhouette.png").getImage();

        // Inicializar variables
        silhouetteRect = new Rectangle(0, 0, 0, 0);
        revealedArea = 0;
        lives = 3;
        isGameOver = false;

        // Agregar listener de ratón para trazar la línea
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                silhouetteRect.x = e.getX();
                silhouetteRect.y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int width = e.getX() - silhouetteRect.x;
                int height = e.getY() - silhouetteRect.y;
                silhouetteRect.width = width;
                silhouetteRect.height = height;
                revealArea();
                checkGameOver();
                repaint();
            }
        });
    }

    public void revealArea() {
        // Verificar si la línea trazada intersecta con el área de revelado
        Rectangle intersection = silhouetteRect.intersection(new Rectangle(0, 0, WIDTH, HEIGHT));
        if (!intersection.isEmpty()) {
            revealedArea += intersection.width * intersection.height;
        }
    }

    public void checkGameOver() {
        // Verificar si se ha revelado el 80% del área de fondo
        int totalArea = WIDTH * HEIGHT;
        double percentRevealed = (double) revealedArea / totalArea;
        if (percentRevealed >= 0.8) {
            isGameOver = true;
        }

        // Verificar si se ha tocado un enemigo (en este caso, solo restamos una vida)
        if (silhouetteRect.intersects(enemyRect)) {
            lives--;
        }

        // Verificar si se han perdido todas las vidas
        if (lives <= 0) {
            isGameOver = true;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, this);

        // Dibujar la imagen de silueta
        g.drawImage(silhouetteImage, silhouetteRect.x, silhouetteRect.y, silhouetteRect.width, silhouetteRect.height, this);

        // Dibujar los enemigos (puedes personalizar esto según tus necesidades)
        g.setColor(Color.RED);
        g.fillRect(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height);

        // Dibujar información adicional (vidas, porcentaje revelado, etc.)
        g.setColor(Color.WHITE);
        g.drawString("Lives: " + lives, 10, 20);
        g.drawString("Revealed: " + Math.round((double) revealedArea / (WIDTH * HEIGHT) * 100) + "%
        // Definir las propiedades de los enemigos (puedes personalizar esto según tus necesidades)
    private static final int ENEMY_WIDTH = 20;
    private static final int ENEMY_HEIGHT = 20;
    private static final int ENEMY_SPEED = 2;
    private Rectangle enemyRect;

    public void moveEnemies() {
        // Mover los enemigos en dirección horizontal
        enemyRect.x += ENEMY_SPEED;

        // Verificar si los enemigos han alcanzado los bordes de la pantalla
        if (enemyRect.x <= 0 || enemyRect.x >= WIDTH - ENEMY_WIDTH) {
            ENEMY_SPEED *= -1; // Cambiar la dirección de movimiento
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, this);

        // Dibujar la imagen de silueta
        g.drawImage(silhouetteImage, silhouetteRect.x, silhouetteRect.y, silhouetteRect.width, silhouetteRect.height, this);

        // Dibujar los enemigos
        g.setColor(Color.RED);
        g.fillRect(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height);

        // Dibujar información adicional
        g.setColor(Color.WHITE);
        g.drawString("Lives: " + lives, 10, 20);
        g.drawString("Revealed: " + Math.round((double) revealedArea / (WIDTH * HEIGHT) * 100) + "%", 10, 40);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.enemyRect = new Rectangle(WIDTH / 2 - ENEMY_WIDTH / 2, HEIGHT / 2 - ENEMY_HEIGHT / 2, ENEMY_WIDTH, ENEMY_HEIGHT);

        // Crear el bucle del juego
        while (!game.isGameOver) {
            game.moveEnemies();
            game.repaint();

            try {
                Thread.sleep(10); // Controlar la velocidad de actualización del juego
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostrar el mensaje de victoria o derrota al finalizar el juego
        if (game.lives <= 0) {
            JOptionPane.showMessageDialog(null, "Game Over! You lost.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Congratulations! You won.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }

        // Cerrar la ventana del juego
        game.dispose();
    }
}