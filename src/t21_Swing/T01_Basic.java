package t21_Swing;

import javax.swing.JFrame;

public class T01_Basic extends JFrame{
	
	
	public T01_Basic() {
		super("스윙연습1");
		setBounds(300, 250, 300, 250);
		
		setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		new T01_Basic();
	}
}
