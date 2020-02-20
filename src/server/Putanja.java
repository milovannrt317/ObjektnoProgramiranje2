package server;

public class Putanja {
    String smer;
    int x,y;

    public Putanja(String smer, int x, int y) {
        this.smer = smer;
        this.x = x;
        this.y = y;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
