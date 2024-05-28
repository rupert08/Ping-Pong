import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the Ping Pong game world.
 * It sets up the paddles, ball, and scoreboards.
 * It also handles game mechanics like scoring and power-ups.
 * 
 * * @authors (Rupert & Rayond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public class PingPongWorld extends World {
    private Paddle paddle1; 
    private Paddle paddle2; 
    private Ball ball; 
    private Scoreboard scoreboard1; 
    private Scoreboard scoreboard2; 
    private int blockCount = 0; // Number of blocks in the world
    private Block block; 

    public PingPongWorld() {
        super(800, 600, 1);
        prepare();
    }

    public void act() {
        // Add a block if there are less than 3
        if (blockCount < 3) {
            addBlock();
        }
        // Generate a random power-up
        generateRandomPowerUp();
    }

    private void prepare() {
        // Create and add paddles, ball, and scoreboards
        paddle1 = new Paddle(true);
        addObject(paddle1, 50, getHeight() / 2);

        paddle2 = new Paddle(false);
        addObject(paddle2, getWidth() - 50, getHeight() / 2);

        scoreboard1 = new Scoreboard();
        addObject(scoreboard1, 100, 50);

        scoreboard2 = new Scoreboard();
        addObject(scoreboard2, getWidth() - 100, 50);

        ball = new Ball();
        addObject(ball, getWidth() / 2, getHeight() / 2);
        ball.stickToPaddle(paddle1);
    }

    public void resetBall() {
        // Reset the ball to the center and stick it to the appropriate paddle
        ball.setLocation(getWidth() / 2, getHeight() / 2);
        ball.stickToPaddle(ball.getHorizontalSpeed() > 0 ? paddle2 : paddle1);
    }

    public void resetPaddles() {
        // Reset paddles to their original positions and sizes
        paddle1.setLocation(50, getHeight() / 2);
        paddle2.setLocation(getWidth() - 50, getHeight() / 2);
        paddle1.getImage().scale(13, 100);
        paddle2.getImage().scale(13, 100);
    }

    public void scorePoint(int player) {
        // Update scores and check for game over
        if (player == 1) {
            scoreboard1.addScore(1);
            scoreboard2.loseLife();
            if (scoreboard2.isOutOfLives()) {
                displayWinner("Player 1 Wins!");
                resetBall();
                resetPaddles();
            }
        } else {
            scoreboard2.addScore(1);
            scoreboard1.loseLife();
            if (scoreboard1.isOutOfLives()) {
                displayWinner("Player 2 Wins!");
                resetBall();
                resetPaddles();
            }
        }
        Greenfoot.playSound("mixkit-animated-small-group-applause-523.wav");
    }

    private void displayWinner(String winnerMessage) {
        // Display the winner message and stop the game
        showText(winnerMessage, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

    public Paddle getPaddle1() {
        return paddle1;
    }

    public Paddle getPaddle2() {
        return paddle2;
    }

    public void generateRandomPowerUp() {
        // 0.1% chance to generate a power-up each act cycle
        if (Greenfoot.getRandomNumber(500) < 0.1) { 
            PowerUp powerUp = null;

            int random = Greenfoot.getRandomNumber(3); // Randomly choose a power-up type
            switch (random) {
                case 1: powerUp = new ShrinkPaddleEffect(); 
                break;
                case 2: powerUp = new GrowPaddle();
                break;
            
                // Add cases for other power-ups here
            }

            if (powerUp != null) {
                // Add the power-up to a random position in the world
                addObject(powerUp, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            }
        }
    }

    public void addBlock() {
        // Add a new block if there are less than 3
        if (blockCount < 3) {
            block = new Block();
            addObject(block, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            blockCount++;
        }
    }

    public void blockBroken() {
        // Decrease the block count when a block is broken
        blockCount--;
    }
}
