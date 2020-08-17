package gameserver;

public class RandomIntGenerator {
    private int low;
    private int high;
    private static final int BUFFER_SIZE = 10;
    private static double[] buffer = new double[BUFFER_SIZE];
    
    public RandomIntGenerator(int l, int h) {
        low = l;
        high = h;
    }
    
    public int draw() {
        int rs=0;
        while (rs==0) {
            rs = (int) (java.lang.Math.random()*10);
            // System.out.println("Random: "+rs);
        }        
        return rs;
    }
    
    public int drawX() {
        int r = low + (int) ((high-low+1) * nextRandom());
        if (r>high) r = high;
        
        return r;
    }
    //
    private static double nextRandom() {
        int pos = (int) (java.lang.Math.random()*BUFFER_SIZE);
        if (pos == BUFFER_SIZE) pos = BUFFER_SIZE - 1;
        double r = buffer[pos];
        buffer[pos] = java.lang.Math.random();
        return r;
    }    
}
