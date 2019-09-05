package Tank_java;

import java.awt.*;

public class Hero extends Tank{
    Shot shot;
    public Hero(int x,int y,int direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
        this.color= Color.blue;
        speed=2;

    }
    public void shotothers(int x,int y,int direct){
        shot=new Shot(this.x,this.y,this.direct);
        Thread t1=new Thread(shot);
        t1.start();
    }
}