import greenfoot.*;  
/**
 * This class represents the ShrinkPaddleEffect power-up.
 * It makes the opponent's paddle shrink in size when applied.
 *
   @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public class ShrinkPaddleEffect extends PowerUp {
    
    public void applyEffect(Ball ball, PingPongWorld world) {
        // Apply the effect of shrinking the opponent's paddle
        Paddle opponent = ball.getHorizontalSpeed() > 0 ? world.getPaddle1() : world.getPaddle2();
        int originalHeight = opponent.getImage().getHeight();
        opponent.getImage().scale(opponent.getImage().getWidth(), originalHeight / 2);

        // Add a timed effect to revert the paddle back to original size after 6 seconds
        world.addObject(new TimedEffect(6000, () -> {}, () -> {
            opponent.getImage().scale(opponent.getImage().getWidth(), originalHeight);
        }), 0, 0);
    }
}
