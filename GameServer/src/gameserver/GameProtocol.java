package gameserver;


public class GameProtocol {
    private static final int WAITING = 0;
    private static final int PLAYING = 1;
    private int state = WAITING;
    private GameRules gr;
    
    public GameProtocol() {
        gr = new GameRules();
    }

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Connected...";
            state = PLAYING;
        } 
        else if (state == PLAYING) {
            if (theInput.equalsIgnoreCase("PLAY")) {
                // Random Number
                gr.randomNumber();
                theOutput = "READY";
            } 
            else if  (theInput.substring(0,6).equalsIgnoreCase("GUESS:")) {
                int gn = Integer.parseInt(theInput.substring(6));
                theOutput = "RESULT:" +gr.getResult(gn);                
            } 
            else {
                theOutput = "BYE";
            }
        }
        return theOutput;
    }
}
