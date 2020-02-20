package server;

import java.util.ArrayList;
import modeli.Lavirint;

public class LavirintControler {
    
    private char[][] lavirint;
    
    private boolean[][] poseceni;
    private boolean nadjen = false;
    private ArrayList<Putanja> putanja=new ArrayList<>();

    public LavirintControler(Lavirint lavir) {
        this.lavirint = lavir.getLavirint();
        poseceni=new boolean[lavirint.length][lavirint[0].length];
        popuniPosecene();
    }

    private void popuniPosecene()
    {
        for (int i = 0; i < lavirint.length; i++) {
            for (int j = 0; j < lavirint[i].length; j++) {
                if(lavirint[i][j]=='@')
                { 
                    poseceni[i][j]=true;
                }
                else
                {
                    poseceni[i][j]=false;
                }
            }
        }
    }
    
    public String trazi(){
        int Rx=-1;
        int Ry=-1;
        
        for (int i = 0; i < lavirint.length; i++) {
            if(Rx!=-1 && Ry!=-1)
                    break;
            for (int j = 0; j < lavirint[i].length; j++) {
                if(lavirint[i][j]=='R')
                {
                    Rx=i;
                    Ry=j;
                    break;
                }
            }
        }
        
        nadji(null,Rx, Ry);
        
        if (nadjen) 
        {
            String put="";
            for (Putanja p : putanja) {
                put+=p.getSmer()+" ";
            }
            return put;
        }
        else
            return "Nema izlaz!";
    }
    
    private void nadji(String smer,int x, int y) {
        
        if (nadjen || poseceni[x][y])
            return;
        
        poseceni[x][y] = true;
        
        if(lavirint[x][y]=='R')
            lavirint[x][y]=' ';
        if(smer!=null)
            putanja.add(new Putanja(smer, x, y));
        
        if (lavirint[x][(y+1)]==' ') 
        {
            nadji("desno",x, y + 1);
        }
        else if (lavirint[x][(y+1)]=='E') {
            nadjen = true;
            putanja.add(new Putanja("desno", x, y+1));
        }
        if (lavirint[(x+1)][y]==' ')
        {
            nadji("dole",x + 1, y);
        }
        else if (lavirint[(x+1)][y]=='E') {
            nadjen = true;
            putanja.add(new Putanja("dole", x+1, y));
        }
        if (lavirint[x][(y-1)]==' ') 
        {
            nadji("levo",x, y - 1);
        }
        else if (lavirint[x][(y-1)]=='E') {
            nadjen = true;
            putanja.add(new Putanja("levo", x, y-1));
        }
        if (lavirint[(x-1)][y]==' ') 
        {
            nadji("gore",x - 1, y);
        }
        else if (lavirint[(x-1)][y]=='E') {
            nadjen = true;
            putanja.add(new Putanja("gore", x-1, y));
        }
        if (nadjen) return;

        //brisanje putanje ako se vraca unazad
        for (Putanja p : putanja) {
            if (p.getX()==x&&p.getY()==y) {
                putanja.remove(p);
                break;
            }
        }
    }
}
