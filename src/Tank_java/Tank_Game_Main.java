package Tank_java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tank_Game_Main extends JFrame implements ActionListener{
	StartPanel start=new StartPanel();
	Mypanel my;
	JMenuBar menubar=new JMenuBar();
	JMenuItem first,second,third,forth;
	public Tank_Game_Main(){
		 JMenu menu;
		 menu=new JMenu("菜单");
		 menubar.add(menu);
		 setJMenuBar(menubar);
		 first=new JMenuItem("开始新游戏");
		 first.addActionListener(this);
		 second=new JMenuItem("接着上局游戏");
		 third=new JMenuItem("存盘退出");
		 forth=new JMenuItem("退出游戏");
  	    menu.add(first);
		menu.add(second);
		menu.add(third);
		menu.add(forth);
		menubar.add(menu);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("坦克大战");
		this.setBounds(300,300,500,500);
	    this.setLayout(new BorderLayout());
	    this.add(start,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		Tank_Game_Main tankgame=new Tank_Game_Main();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==first){
			System.out.println("game is beginning !");
			this.remove(start);
			 my=new Mypanel(); 
			this.addKeyListener(my);
			Thread game=new Thread(my);
			game.start();
			this.add(my,BorderLayout.CENTER);
			this.setVisible(true);
		}
	}
}