package t21_Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T04_Button extends JFrame{
	JButton btnExit;
	
	public T04_Button() {
		super("스윙연습1");
		setSize(300, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		btnExit = new JButton("종료");
		add(btnExit);
		
		
		
		setVisible(true);
		
		/*==================================================*/
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		new T04_Button();
	}
}
