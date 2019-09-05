package Tank_java;

public class Shot implements Runnable{
    int x;
    int y;
    int dirct;
    int speed=1;
    boolean isalive;
    public  Shot(int x,int y,int direct){
        if(direct==1){
            this.x=x-2;
            this.y=y-15-4;
            this.dirct=direct;
        }else if(direct==2){
            this.x=x-2;
            this.y=y+15;
            this.dirct=direct;
        }else if(direct==3){
            this.x=x-15-4;
            this.y=y-2;
            this.dirct=direct;
        }else{
            this.x=x+15;
            this.y=y-4;
            this.dirct=direct;
        }

    }
    public void run() {
        while(true){

            if(this.dirct==1){
                this.y-=this.speed;
            } if(this.dirct==2){
                this.y+=this.speed;
            } if(this.dirct==3){
                this.x-=this.speed;
            }if(this.dirct==4) {
                this.x+=this.speed ;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
