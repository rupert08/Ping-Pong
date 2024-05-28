import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the Ball in the Ping Pong game.
 * It handles the movement, collisions, and interactions with other objects.
 
 * @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1.0)
 */
public class Ball extends Actor {
    private int horizontalSpeed = 3; // Speed of the ball horizontally
    private int verticalSpeed = 3; // Speed of the ball vertically
    private boolean isStuck = true; // If the ball is stuck to the paddle
    private Paddle currentPaddle; // The paddle the ball is stuck to

    public Ball() {
        // Constructor for the ball class
    }

    public void act() {
        if (isStuck) {
            // If the ball is stuck to a paddle, check for space key to release it
            if (Greenfoot.isKeyDown("space")) {
                isStuck = false;
            } 
            else if (currentPaddle != null) {
                // Align the ball with the paddle
                if (currentPaddle.isPlayerOne) {
                    setLocation(currentPaddle.getX() + currentPaddle.getImage().getWidth() / 2 + getImage().getWidth() / 2, currentPaddle.getY());
                } else {
                    setLocation(currentPaddle.getX() - currentPaddle.getImage().getWidth() / 2 - getImage().getWidth() / 2, currentPaddle.getY());
                }
            }
        } else {
            // Move the ball and check for collisions
            move();
            checkCollision();
        }
    }

    public void stickToPaddle(Paddle paddle) {
        // Stick the ball to the given paddle
        isStuck = true;
        currentPaddle = paddle;

        if (paddle.isPlayerOne) {
            setLocation(paddle.getX() + paddle.getImage().getWidth() / 2 + getImage().getWidth()  / 2, paddle.getY());
            horizontalSpeed = 3;
        } else {
            setLocation(paddle.getX() - paddle.getImage().getWidth() / 2 - getImage().getWidth() / 2, paddle.getY());
            horizontalSpeed = -3;
        }
    }

    public void setSpeed(int horizontalSpeed, int verticalSpeed) {
        // Set the speed of the ball
        this.horizontalSpeed = horizontalSpeed;
        this.verticalSpeed = verticalSpeed;
    }

    public int getHorizontalSpeed() {
        return horizontalSpeed;
    }

    public int getVerticalSpeed() {
        return verticalSpeed;
    }

    private void move() {
        // Move the ball based on its speed
        setLocation(getX() + horizontalSpeed, getY() + verticalSpeed);
    }

    private void checkCollision() {
        // Check for collisions with the edges of the world, paddles, and power-ups
        if (getY() <= 0 || getY() >= getWorld().getHeight() - 1) {
            verticalSpeed = -verticalSpeed;
            Greenfoot.playSound("mixkit-arcade-game-jump-coin-216.wav");
        }

        if (isTouching(Paddle.class)) {
            Paddle paddle = (Paddle) getOneIntersectingObject(Paddle.class);
            if (getX() < paddle.getX() + paddle.getImage().getWidth() / 2 && getX() > paddle.getX() - paddle.getImage().getWidth() / 2) {
                // Ball hit the top or bottom of the paddle
                verticalSpeed = -verticalSpeed;
            } else {
                // Ball hit the side of the paddle
                if (paddle.isPlayerOne) {
                    horizontalSpeed = 5;
                } else {
                    horizontalSpeed = -5;
                }
            }
            Greenfoot.playSound("mixkit-game-ball-tap-2073.wav");
        }

        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1) {
            // Check for scoring when the ball hits the left or right edge
            PingPongWorld world = (PingPongWorld) getWorld();
            if (getX() <= 0) {
                world.scorePoint(2); // Player 2 scores
                world.resetBall();
                world.resetPaddles();
            } else {
                world.scorePoint(1); // Player 1 scores
                world.resetBall();
                world.resetPaddles();
            }
        }

        if (isTouching(PowerUp.class)) {
            // Apply power-up effect when the ball touches a power-up
            PowerUp powerUp = (PowerUp) getOneIntersectingObject(PowerUp.class);
            powerUp.applyEffect(this, (PingPongWorld) getWorld());
            Greenfoot.playSound("mixkit-arcade-bonus-alert-767.wav");
            getWorld().removeObject(powerUp);
        }

        if (isTouching(Block.class)) {
            // Handle collision with a block
            Block block = (Block) getOneIntersectingObject(Block.class);
            Greenfoot.playSound("mixkit-electronic-retro-block-hit-2185.wav");
            block.breakBlock();
            // Change direction of the ball
            horizontalSpeed = -horizontalSpeed;
        }
    }
}
