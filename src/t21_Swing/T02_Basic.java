package t21_Swing;

import javax.swing.JFrame;

public class T02_Basic extends JFrame{
	
	
	public T02_Basic() {
		super("스윙연습1");
		setBounds(300, 250, 300, 250);
		
		setVisible(true);
	
		// 윈도우 창 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new T02_Basic();
	}
}
