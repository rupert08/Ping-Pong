import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.Font;
import greenfoot.Color;

/**
 * This class represents the scoreboard that tracks the score and lives of a player.
 * 
   @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public class Scoreboard extends Actor {
    private int score; 
    private int lives; 
    public Scoreboard() {
        // Constructor initializes score and lives, then updates the display image
        score = 0;
        lives = 3;
        updateImage();
    }

    public void addScore(int points) {
        // Add points to the score and update the display image
        score += points;
        updateImage();
    }

    public void loseLife() {
        // Decrease lives by 1 and update the display image
        lives--;
        updateImage();
    }

    public int getLives() {
        // Return the number of lives left
        return lives;
    }
    
    public boolean isOutOfLives() {
        // Check if the player is out of lives
        return lives <= 0;
    }

    private void updateImage() {
        // Update the display image with the current score and lives
        setImage(new GreenfootImage("Score: " + score + " Lives: " + lives, 24, Color.WHITE, Color.BLACK));
    }
}
