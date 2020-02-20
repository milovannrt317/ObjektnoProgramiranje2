package modeli;

import java.io.Serializable;

public class Palindrom implements Serializable{
    private String palindrom;

    public Palindrom(String palindrom) {
        this.palindrom = palindrom;
    }

    public String getPalindrom() {
        return palindrom;
    }

    public void setPalindrom(String palindrom) {
        this.palindrom = palindrom;
    }    
}
