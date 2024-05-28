import greenfoot.*;  
/**
 * This class represents an abstract PowerUp in the game.
 * Different power-ups will extend this class and implement the applyEffect method.
 *
 @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public abstract class PowerUp extends Actor {
    int ySpeed = 4; // Speed of the power-up's vertical movement

    public abstract void applyEffect(Ball ball, PingPongWorld world);

    public void move() {
        // Move the power-up vertically and bounce when it hits the top or bottom
        setLocation(getX(), getY() + ySpeed);
        if (getY() + getImage().getHeight() / 2 >= getWorld().getHeight() || getY() <= 0) {
            ySpeed = -ySpeed;
        }
    }
}
