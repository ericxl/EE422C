package assignment2;

/**
 * Created by Eric on 9/17/16.
 */
public class Driver {
    public static void main(String[] args) {
        Game game;
        if(args.length > 0 && args[0].equals("1")){
            game = new Game(true);
        }else {
            game = new Game(false);
        }
        game.runGame();
    }
}
