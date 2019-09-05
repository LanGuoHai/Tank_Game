package Tank_java;
import java.awt.*;
import java.util.Vector;

public class Enemy extends Tank implements Runnable{
    static Vector<Enemy> ets=new Vector<Enemy>();
    Vector <Shot>ss=new Vector<Shot>();
    public Enemy(int x,int y,int direct){
        this.x=x;
        this.y=y;
        this.direct =direct;
        this.color= Color.yellow;
        shotothers(x,y,direct);
    }
    public void shotothers(int x,int y,int direct){
        Shot shot=new Shot(this.x,this.y,this.direct);
        ss.add(shot);
        Thread t1=new Thread(shot);
        t1.start();
    }
    public void run(){
        while(true){
            direct=(int)(Math.random()*4+1);
            for(int i=0;i<30;i++)
            {
                if(direct==1){
                    y-=speed;
                    if(touchothers()){y+=speed;
                        //	y++;
                        break;}
                    // y-=speed;
                }else if(direct==2){
                    y+=speed;
                    if(touchothers()){y-=speed;
                        //y--;
                        break;}
                    //y+=speed;
                }else if(direct==3){
                    x-=speed;
                    if(touchothers()){x+=speed;
                        break;}
                    //x-=speed;
                }else{
                    x+=speed;
                    if(touchothers()){x-=speed;
                        //x++;
                        break;}
                    //x+=speed;
                }
                if(x<=15||y<=15||x>=465||y>=420){
                    break;
                }

                if(ss.size()<=5&&Math.random()<=0.05){
                    shotothers(x,y,direct);
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
    }
    public void setEts(Vector <Enemy> mpets){
        ets=mpets;
    }
    public boolean touchothers(){
        //for(int i=0;i<ets.size();i++){
        if(touch()){
            return true;
            //	}
        }
        return false;
    }
    public boolean touch(){
        for(int i=0;i<ets.size()&&(x!=ets.get(i).x&&y!=ets.get(i).y);i++)
        {
            //if((Math.abs(ets.get(i).x-x)<=25&&Math.abs(ets.get(i).y-y)<=25)||
    /*		if((Math.abs(ets.get(i).x-x)<=25&&Math.abs(ets.get(i).y-y)<=25)||
    	(Math.abs(ets.get(i).x-x)<=30&&Math.abs(ets.get(i).y-y)<=20)||
    	(Math.abs(ets.get(i).x-x)<=25&&Math.abs(ets.get(i).y-y)<=25)||
    	(Math.abs(ets.get(i).x-x)<=20&&Math.abs(ets.get(i).y-y)<=30))
    	*/
            if(Math.abs(ets.get(i).x-x)<=20&&Math.abs(ets.get(i).y-y)<=20)
            {
                return true;
            }
        }
        return false;

    }
}