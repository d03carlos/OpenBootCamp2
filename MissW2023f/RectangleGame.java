package MissW2023f;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectangleGame extends JPanel {
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

    public RectangleGame() {
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

        startGameLoop();
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
        Graphics2D g2d = (Graphics2D) getGraphics();
        int transparency = 0;
        for (int i = 0; i < silhouetteImage.getWidth(null); i++) {
            for (int j = 0; j < silhouetteImage.getHeight(null); j++) {
                int pixelX = x - rectangle.width / 2 + i;
                int pixelY = y - rectangle.height / 2 + j;

                if (rectangle.contains(pixelX, pixelY)) {
                    int rgb = silhouetteImage.getRGB(i, j);
                    transparency = (rgb >> 24) & 0xFF;
                    if (transparency > 0) {
                        silhouetteImage.setRGB(i, j, rgb & 0x00FFFFFF);
                        revealedPixels++;
                    }
                }
            }
        }
        if (transparency == 0 || calculateRevealedPercentage() >= PERCENTAGE_TO_WIN) {
            gameOver = true;
        }
        repaint();
    }

    private double calculateRevealedPercentage() {
        int totalPixels = rectangle.width * rectangle.height;
        return (double) revealedPixels / totalPixels * 100;
        }

        private void startGameLoop() {
            Thread gameLoop = new Thread(() -> {
                while (!gameOver) {
                    updateGame();
                    repaint();
        
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            gameLoop.start();
        }
        
        private void updateGame() {
            // Actualizar la lógica del juego aquí
            // Por ejemplo, mover los enemigos, comprobar colisiones, etc.
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
        
            // Dibujar enemigos, vidas y otros elementos visuales
            // Aquí puedes personalizar el aspecto del juego según tus necesidades
        
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
        
        private static Image createSolidColorImage(int width, int height, Color color) {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(color);
            g2d.fillRect(0, 0, width, height);
            g2d.dispose();
            return image;
        }
        
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Rectangle Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new RectangleGame());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }
        
    }
