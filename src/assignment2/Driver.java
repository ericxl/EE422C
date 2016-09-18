package assignment2;

/**
 * Created by Eric on 9/17/16.
 */
public class Driver {
    private static Game gameInstance;
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("1")){
            gameInstance = new Game(true);
        }else {
            gameInstance = new Game(false);
        }
        gameInstance.runGame();
    }
}
