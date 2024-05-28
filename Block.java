import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents a Block in the Ping Pong game.
 * The block moves up and down and can be broken by the ball.
 *
   @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public class Block extends Actor {
    int ySpeed = 1; // Speed of the block's vertical movement

    public void act() {
        // Move the block each act cycle
        move();
    }

    public void move() {
        // Move the block vertically and bounce when it hits the top or bottom
        setLocation(getX(), getY() + ySpeed);
        if (getY() + getImage().getHeight() / 2 >= getWorld().getHeight() || getY() <= 0) {
            ySpeed = -ySpeed;
        }
    }

    public void breakBlock() {
        // Break the block and remove it from the world
        PingPongWorld world = (PingPongWorld) getWorld();
        world.blockBroken();
        getWorld().removeObject(this);
    }
}
