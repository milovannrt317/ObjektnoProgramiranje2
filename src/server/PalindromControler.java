package server;

import modeli.Palindrom;

public class PalindromControler {
    private String palindrom;

    public PalindromControler(Palindrom pal) {
        this.palindrom = pal.getPalindrom();
    }
    public String ispitaj()
    {
        StringBuilder pom=new StringBuilder(palindrom.replace(" ", ""));
        return "Unos \""+palindrom+"\" "+((palindrom.replace(" ", "").compareToIgnoreCase(new String(pom.reverse()))==0)?"jeste":"nije")+" palindrom."; 
    }
}
