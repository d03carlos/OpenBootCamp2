package LadyKF;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private BufferedImage backgroundImage;
    private BufferedImage playerImage;
    private BufferedImage enemyImage;
    private boolean running;
    private int playerX;
    private int playerY
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FPS = 60;
    private static final long DELAY = 1000 / FPS;
    private boolean running;
    private Thread gameThread;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        // Cargar las imágenes desde archivos

        // Inicializar running en true
        running = true;
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        loadImageBackground();
        loadImagePlayer();
        labelText = "Score: 0";
        // Inicializar la posición del jugador
        playerX = 0;
        playerY = 0;
        // Llamar al método de bucle de juego
        gameLoop();
        try {
            backgroundImage = ImageIO.read(getClass().getResource("background.png"));
            playerImage = ImageIO.read(getClass().getResource("player.png"));
            enemyImage = ImageIO.read(getClass().getResource("enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Agregar un KeyListener al panel para detectar las pulsaciones de teclas
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Implementar el manejo de las teclas presionadas
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                // Implementar el manejo de las teclas liberadas
            }
        });
        
        setFocusable(true); // Asegurarse de que el panel tenga el foco para recibir eventos de teclado
    
    }

    private void loadImageBackground() {
        // Cargar la imagen de fondo desde un archivo o utilizar alguna otra fuente
        // backgroundImage = loadImageFromFile("background.png");
        // Si lo deseas, puedes usar un fondo sólido en lugar de una imagen
        backgroundImage = createSolidColorImage(WIDTH, HEIGHT, Color.BLACK);
    }

    private void loadImagePlayer() {
        // Cargar la imagen del jugador desde un archivo o utilizar alguna otra fuente
        // playerImage = loadImageFromFile("player.png");
        // Si lo deseas, puedes usar un rectángulo sólido en lugar de una imagen
        playerImage = createSolidColorImage(50, 50, Color.BLUE);
    }

    // Otros métodos y lógica del juego

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar el fondo
        g2d.drawImage(backgroundImage, 0, 0, null);

        // Dibujar el jugador
        int playerX = WIDTH / 2 - playerImage.getWidth(null) / 2;
        int playerY = HEIGHT / 2 - playerImage.getHeight(null) / 2;
        g2d.drawImage(playerImage, playerX, playerY, null);
        g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        
        // Dibujar el jugador
        g2d.drawImage(playerImage, playerX, playerY, null);
        
        // Dibujar los enemigos, obstáculos y otros elementos del juego
        
        // Realizar más dibujos según sea necesario
        
        // Dibujar texto
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString(labelText, 10, 20);

        // Dibujar otros componentes gráficos adicionales, como enemigos, balas, etc.

        // Otros dibujos y lógica del juego
    }
    public void keyPressed(KeyEvent e) {
        // Manejar las teclas presionadas por el usuario
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            // Mover el jugador hacia la izquierda
            playerX -= 5;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // Mover el jugador hacia la derecha
            playerX += 5;
        } else if (keyCode == KeyEvent.VK_UP) {
            // Mover el jugador hacia arriba
            playerY -= 5;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            // Mover el jugador hacia abajo
            playerY += 5;
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
    
    private void gameLoop() {
        while (running) {
            // Actualizar el estado del juego
            
            // Renderizar los elementos gráficos del juego
            
            // Controlar la entrada del usuario
            
            // Añadir una pausa para el bucle de juego
            // Actualizar la lógica del juego
            updateGame();
            
            // Renderizar los elementos gráficos del juego
            repaint();
            
            // Controlar la entrada del usuario
            
            // Pausa para el bucle de juego
            // ...
            try {
                Thread.sleep(16); // 60 FPS (1000 ms / 60)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void updateGame() {
        // Actualizar la lógica del juego (movimiento, colisiones, puntuación, etc.)
        // Aquí implementarás la lógica del juego según tus requisitos específicos
    }
    public void startGame() {
        if (!running) {
            running = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }
    public void stopGame() {
        if (running) {
            running = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        long startTime;
        long elapsedTime;
        long sleepTime;

        init();

        while (running) {
            startTime = System.nanoTime();

            update();
            render();
            draw();

            elapsedTime = System.nanoTime() - startTime;
            sleepTime = DELAY - elapsedTime / 1_000_000;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void init() {
        // Inicializar los componentes del juego, cargar recursos, etc.
    }

    private void update() {
        // Actualizar la lógica del juego, como la posición de los personajes, detección de colisiones, etc.
    }

    private void render() {
        // Preparar los elementos del juego para su renderizado, como el dibujo de fondos, personajes, enemigos, etc.
    }

    private void draw() {
        // Dibujar los elementos del juego en el panel
        // Este método se encarga de realizar el dibujado final en el panel
        // Puedes utilizar técnicas de doble búfer para evitar parpadeos y mejorar el rendimiento
        // Aquí se utiliza el objeto Graphics para dibujar los elementos en el panel
        // Recuerda llamar a super.paintComponent(g) para asegurar que el panel se limpie antes de dibujar
        repaint();
    }
}
