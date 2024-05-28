import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the GrowPaddle power-up.
 * It makes the opponent's paddle grow in size when applied.
 *
 @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public class GrowPaddle extends PowerUp {
    
    public void applyEffect(Ball ball, PingPongWorld world) {
        // Apply the effect of growing the opponent's paddle
        Paddle opponent;
        if (ball.getHorizontalSpeed() > 0) {
            opponent = world.getPaddle1();
        } else {
            opponent = world.getPaddle2();
        }
        int originalHeight = opponent.getImage().getHeight();
        opponent.getImage().scale(opponent.getImage().getWidth(), originalHeight * 2);

        // Add a timed effect to revert the paddle back to original size after 6 seconds
        world.addObject(new TimedEffect(6000, () -> {}, () -> {
            opponent.getImage().scale(opponent.getImage().getWidth(), originalHeight);
        }), 0, 0);
    }
}
