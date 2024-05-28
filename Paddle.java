import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents a Paddle in the Ping Pong game.
 * It handles the movement and controls for the paddle.
   @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1.0)
 */
public class Paddle extends Actor {
    private int speed = 5; 
    public boolean isPlayerOne; // Determines if this is player one's paddle

    public Paddle(boolean isPlayerOne) {
        // Constructor to set if this paddle belongs to player one
        this.isPlayerOne = isPlayerOne;
    }

    public void act() {
        // Act method called in every cycle to handle movement
        handleMovement();
    }
    
    private void handleMovement() {
        // Handle the movement of the paddle based on key presses
        int halfHeight = getImage().getHeight() / 2;
        int minY = halfHeight;
        int maxY = getWorld().getHeight() - halfHeight;
        int newY = getY();
        if (newY < minY) {
            newY = minY;
        } else if (newY > maxY) {
            newY = maxY;
        }

        setLocation(getX(), newY);
        if (isPlayerOne) {
            // Controls for player one
            if (Greenfoot.isKeyDown("w")) {
                setLocation(getX(), getY() - speed);
            }
            if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() + speed);
            }
        } else {
            // Controls for player two
            if (Greenfoot.isKeyDown("up")) {
                setLocation(getX(), getY() - speed);
            }
            if (Greenfoot.isKeyDown("down")) {
                setLocation(getX(), getY() + speed);
            }
        }
    }
        
    public void setSpeed(int newSpeed) {
        // Set a new speed for the paddle
        speed = newSpeed;
    }
}
