import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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

    private Clip backgroundMusic;
    private Clip hitSound;
    private Clip winSound;
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
        //codigo previos1
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

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!gameOver && rectangle.contains(e.getPoint())) {
                    revealPixels(e.getX(), e.getY());
                }
            }
        });
        enemies = new Enemy[3];
        enemies[0] = new Enemy(100, 100, 50, 50);
        enemies[1] = new Enemy(300, 200, 50, 50);
        enemies[2] = new Enemy(500, 400, 50, 50);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!gameOver && !rectangle.contains(e.getPoint())) {
                    boolean hitEnemy = false;
                    for (Enemy enemy : enemies) {
                        if (enemy.contains(e.getPoint())) {
                            hitEnemy = true;
                            break;
                        }
                    }
                    
                    if (hitEnemy) {
                        lives--;
                        if (lives <= 0) {
                            gameOver = true;
                        }
                    }
                }
            }
        });
        loadSounds();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!gameOver && !rectangle.contains(e.getPoint())) {
                    boolean hitEnemy = false;
                    for (Enemy enemy : enemies) {
                        if (enemy.contains(e.getPoint())) {
                            hitEnemy = true;
                            playHitSound();
                            break;
                        }
                    }

                    if (hitEnemy) {
                        lives--;
                        if (lives <= 0) {
                            gameOver = true;
                            playGameOverSound();
                        }
                    }
                }
            }
        });
    }
    
    private void loadSounds() {
        try {
            AudioInputStream backgroundMusicStream = AudioSystem.getAudioInputStream(new File("background_music.wav"));
            AudioInputStream hitSoundStream = AudioSystem.getAudioInputStream(new File("hit_sound.wav"));
            AudioInputStream winSoundStream = AudioSystem.getAudioInputStream(new File("win_sound.wav"));
            AudioInputStream gameOverSoundStream = AudioSystem.getAudioInputStream(new File("game_over_sound.wav"));

            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(backgroundMusicStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);

            hitSound = AudioSystem.getClip();
            hitSound.open(hitSoundStream);

            winSound = AudioSystem.getClip();
            winSound.open(winSoundStream);

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

    private void playWinSound() {
        if (winSound.isRunning()) {
            winSound.stop();
        }
        winSound.setFramePosition(0);
        winSound.start();
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
                }
            }
        }
    }

    // Código posterior
        
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
        g2d.drawImage(backgroundImage, 0, 0, null);
        
        for (Enemy enemy : enemies) {
            g2d.setColor(Color.RED);
            g2d.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
        }
        
        int silhouetteX = rectangle.x - rectangle.width / 2;
        int silhouetteY = rectangle.y - rectangle.height / 2;
        g2d.drawImage(silhouetteImage, silhouetteX, silhouetteY, null);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Revealed: " + calculateRevealedPercentage() + "%", 10, 20);
        g2d.drawString("Lives: " + lives, 10, 40);
        
        if (gameOver) {
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial", Font.BOLD, 32));
            String message = (calculateRevealedPercentage() >= PERCENTAGE_TO_WIN) ? "You Win!" : "Game Over";
            int messageWidth = g2d.getFontMetrics().stringWidth(message);
            g2d.drawString(message, WIDTH / 2 - messageWidth / 2, HEIGHT / 2);
        }

    }
    private static class Enemy {
        private int x;
        private int y;
        private int width;
        private int height;
        
        public Enemy(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
        public boolean contains(Point point) {
            return (point.x >= x && point.x < x + width && point.y >= y && point.y < y + height);
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
