/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

/**
 *
 * @author Simon
 */

public class GameRules {
    private RandomIntGenerator rig;
    private int result=0;
    
    public GameRules() {
            
    }
    
    public void randomNumber() {
        result = new RandomIntGenerator(1, 10).draw();
    }
    
    public String getResult(int guess) {
        if (guess == result) {
            return result + ";"+"YOU WIN!";
        }
        else return result + ";"+ "YOU LOSE!";
    }
}
