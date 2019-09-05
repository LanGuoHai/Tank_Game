package Tank_java;

public class Bomb {
        int x;
        int y;
        int lifetime=9;
        boolean isalive;
        public Bomb(int x,int y){
            this.x=x;
            this.y=y;
            this.isalive=true;
        }
        public void lifedown(){
            if(lifetime>0)
            {
                lifetime--;
            }else{
                isalive=false;
            }
        }
}
