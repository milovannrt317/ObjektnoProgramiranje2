package modeli;

import java.io.Serializable;

public class Sistem implements Serializable{
    private int x1,x2,x3,y1,y2,y3,z1,z2,z3,t1,t2,t3;
    private int[][] d;
    private int[][] dx;
    private int[][] dy;
    private int[][] dz;

    public Sistem(int x1, int x2, int x3, int y1, int y2, int y3, int z1, int z2, int z3, int t1, int t2, int t3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.z1 = z1;
        this.z2 = z2;
        this.z3 = z3;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        d=new int[][]{{x1,y1,z1},{x2,y2,z2},{x3,y3,z3}};
        dx=new int[][]{{t1,y1,z1},{t2,y2,z2},{t3,y3,z3}};
        dy=new int[][]{{x1,t1,z1},{x2,t2,z2},{x3,t3,z3}};
        dz=new int[][]{{x1,y1,t1},{x2,y2,t2},{x3,y3,t3}};
    }
   

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getZ1() {
        return z1;
    }

    public void setZ1(int z1) {
        this.z1 = z1;
    }

    public int getZ2() {
        return z2;
    }

    public void setZ2(int z2) {
        this.z2 = z2;
    }

    public int getZ3() {
        return z3;
    }

    public void setZ3(int z3) {
        this.z3 = z3;
    }

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public int getT2() {
        return t2;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

    public int getT3() {
        return t3;
    }

    public void setT3(int t3) {
        this.t3 = t3;
    }

    public int[][] getD() {
        return d;
    }

    public void setD(int[][] d) {
        this.d = d;
    }

    public int[][] getDx() {
        return dx;
    }

    public void setDx(int[][] dx) {
        this.dx = dx;
    }

    public int[][] getDy() {
        return dy;
    }

    public void setDy(int[][] dy) {
        this.dy = dy;
    }

    public int[][] getDz() {
        return dz;
    }

    public void setDz(int[][] dz) {
        this.dz = dz;
    }
    
}
