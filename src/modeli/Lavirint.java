package modeli;

import java.io.Serializable;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Lavirint implements Serializable{
    private char[][] lavirint;
    
    
    public Lavirint() {
        lavirint=new char[9][9];
        defaultni();
        
    }
    private void popuniOkvir()
    {
        for (int i = 0; i < lavirint.length; i++) {
            for (int j = 0; j < lavirint[i].length; j++) {
                if(i==0 || j==0 || i==lavirint.length-1 || j==lavirint[i].length-1)
                { 
                    lavirint[i][j]='@';
                }
                else
                {
                    lavirint[i][j]=' ';
                }
            }
        }
    }
    public void defaultni()
    {
        popuniOkvir();
        lavirint[3][8]='E';
        lavirint[1][6]='R';
        
        lavirint[2][2]='@';
        lavirint[2][3]='@';
        lavirint[2][4]='@';
        lavirint[2][5]='@';
        lavirint[2][6]='@';
        lavirint[3][3]='@';
        lavirint[4][1]='@';
        lavirint[4][3]='@';
        lavirint[4][5]='@';
        lavirint[4][6]='@';
        lavirint[4][7]='@';
        lavirint[6][2]='@';
        lavirint[6][3]='@';
        lavirint[6][4]='@';
        lavirint[6][5]='@';
        lavirint[6][6]='@';   
    }
    public void randomPrepreke()
    {
        popuniOkvir();
        int poz;
        
        for (int i = 1; i < lavirint.length; i++) {
            if(i%2==0)
            {
                poz=new Random().nextInt(lavirint[i].length-2)+1;
                for (int j = 1; j < lavirint[i].length; j++) {
                    if(j!=poz)
                        lavirint[i][j]='@';
                }
            }
        }
        lavirint[3][8]='E';
        lavirint[1][6]='R';
        
    }
    public void iscrtaj(GridPane gpz3)
    {
        ObservableList<Node> lbls = gpz3.getChildren();
        int n=0;
        for (int i = 0; i < lavirint.length; i++) {
            for (int j = 0; j < lavirint[i].length; j++) {
                if (lavirint[i][j]==' ') {
                    ((Label)lbls.get(n++)).setText("  "+lavirint[i][j]);
                }
                else
                    ((Label)lbls.get(n++)).setText(""+lavirint[i][j]);
            }
        }
    }
    public void popuni(GridPane gpz3)
    {
        ObservableList<Node> lbls = gpz3.getChildren();
        int n=0;
        for (int i = 0; i < lavirint.length; i++) {
            for (int j = 0; j < lavirint[i].length; j++) {
                if (((Label)lbls.get(n)).getText().trim().isEmpty()) {
                    lavirint[i][j]=' ';
                }
                else 
                    lavirint[i][j]=((Label)lbls.get(n)).getText().toCharArray()[0];
                n++;
            }
        }
    }
    public char[][] getLavirint() {
        return lavirint;
    }

    public void setLavirint(char[][] lavirint) {
        this.lavirint = lavirint;
    }
    
}
