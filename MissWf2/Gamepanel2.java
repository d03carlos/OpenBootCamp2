package MissWf2;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int RECTANGLE_SIZE = 100;
    private static final int PERCENTAGE_TO_WIN = 80;

    private Image backgroundImage;
    private Image silhouetteImage;
    private Rectangle rectangle;
    private int revealedPixels;
    private int lives;
    private boolean gameOver;

    private Clip hitSound;
    private Clip gameOverSound;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        loadImageBackground();
        loadImageSilhouette();

        rectangle = new Rectangle(WIDTH / 2 - RECTANGLE_SIZE / 2, HEIGHT / 2 - RECTANGLE_SIZE / 2, RECTANGLE_SIZE, RECTANGLE_SIZE);
        revealedPixels = 0;
        lives = 3;
        gameOver = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!gameOver && !rectangle.contains(e.getPoint())) {
                    lives--;
                    if (lives <= 0) {
                        gameOver = true;
                        playGameOverSound();
                    }
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!gameOver && rectangle.contains(e.getPoint())) {
                    revealPixels(e.getX(), e.getY());
                }
            }
        });

        loadSounds();
    }

    private void loadSounds() {
        try {
            AudioInputStream hitSoundStream = AudioSystem.getAudioInputStream(new File("hit_sound.wav"));
            AudioInputStream gameOverSoundStream = AudioSystem.getAudioInputStream(new File("game_over_sound.wav"));

            hitSound = AudioSystem.getClip();
            hitSound.open(hitSoundStream);

            gameOverSound = AudioSystem.getClip();
            gameOverSound.open(gameOverSoundStream);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void playHitSound() {
        if (hitSound.isRunning()) {
            hitSound.stop();
        }
        hitSound.setFramePosition(0);
        hitSound.start();
    }

    private void playGameOverSound() {
        if (gameOverSound.isRunning()) {
            gameOverSound.stop();
        }
        gameOverSound.setFramePosition(0);
        gameOverSound.start();
    }

    private void loadImageBackground() {
        // Carga la imagen de fondo desde un archivo o utiliza alguna otra fuente
        // backgroundImage = loadImageFromFile("background.png");
        // Si lo deseas, puedes usar un fondo sólido en lugar de una imagen
        backgroundImage = createSolidColorImage(WIDTH, HEIGHT, Color.BLACK);
    }

    private void loadImageSilhouette() {
        // Carga la imagen de la silueta desde un archivo o utiliza alguna otra fuente
        // silhouetteImage = loadImageFromFile("silhouette.png");
        // Si lo deseas, puedes usar una silueta sólida en lugar de una imagen
        silhouetteImage = createSolidColorImage(RECTANGLE_SIZE, RECTANGLE_SIZE, Color.WHITE);
    }

    private void revealPixels(int x, int y) {
        
        // Obtener la posición relativa dentro del rectángulo
        int relativeX = x - (rectangle.x - rectangle.width / 2);
        int relativeY = y - (rectangle.y - rectangle.height / 2);

        // Si el punto está dentro del rectángulo, contar los píxeles revelados
        if (relativeX >= 0 && relativeX < rectangle.width && relativeY >= 0 && relativeY < rectangle.height) {
            int pixelColor = ((DataBufferInt) backgroundImage.getRaster().getDataBuffer()).getElem(relativeY * rectangle.width + relativeX);

            // Si el píxel no ha sido revelado previamente, contar como revelado
            if (pixelColor != Color.BLACK.getRGB()) {
                ((DataBufferInt) backgroundImage.getRaster().getDataBuffer()).setElem(relativeY * rectangle.width + relativeX, Color.BLACK.getRGB());
                revealedPixels++;

                // Verificar si se ha ganado el juego
                if (calculateRevealedPercentage() >= PERCENTAGE_TO_WIN) {
                    gameOver = true;
                    playGameOverSound();
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar el fondo
        g2d.drawImage(backgroundImage, 0, 0, null);

        // Dibujar la silueta
        int silhouetteX = rectangle.x - rectangle.width / 2;
        int silhouetteY = rectangle.y - rectangle.height / 2;
        g2d.drawImage(silhouetteImage, silhouetteX, silhouetteY, null);

        // Dibujar información de juego
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Revealed: " + calculateRevealedPercentage() + "%", 10, 20);
        g2d.drawString("Lives: " + lives, 10, 40);

        // Dibujar mensaje de fin de juego si es necesario
        if (gameOver) {
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial", Font.BOLD, 32));
            String message = (calculateRevealedPercentage() >= PERCENTAGE_TO_WIN) ? "You Win!" : "Game Over";
            int messageWidth = g2d.getFontMetrics().stringWidth(message);
            g2d.drawString(message, WIDTH / 2 - messageWidth / 2, HEIGHT / 2);
        }
    }

    private double calculateRevealedPercentage() {
        int totalPixels = rectangle.width * rectangle.height;
        return (double) revealedPixels / totalPixels * 100;
    }

    private static Image createSolidColorImage(int width, int height, Color color) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();
        return image;
    }
}
