package server;

import modeli.Sistem;

public class SistemControler {
    private Sistem s;

    public SistemControler(Sistem sistem) {
        this.s = sistem;
    }

    private int det(int[][] mat)
    {
        int det=0;
        for(int i=0;i<mat.length;i++)
        {
            det+=(mat[0][i]*(mat[1][(i+1)%3]*mat[2][(i+2)%3]-mat[1][(i+2)%3]*mat[2][(i+1)%3]));
        }
        return det;
    }
    public String izracunaj()
    {
        if(det(s.getD())==0&&det(s.getDx())==0&&det(s.getDy())==0&&det(s.getDz())==0)
            return "Sistem ima beskonacno mnogo resenja!";
        else if(det(s.getD())==0&&(det(s.getDx())!=0||det(s.getDy())!=0||det(s.getDz())!=0))
            return "Sistem nema resenja!";
        else
            return "x="+(double)det(s.getDx())/det(s.getD())+" y="+(double)det(s.getDy())/det(s.getD())+" z="+(double)det(s.getDz())/det(s.getD());
    }
}
