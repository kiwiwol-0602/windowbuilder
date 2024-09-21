package t22_Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class T1 extends JFrame {

	private JPanel contentPane;


	public T1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 700, 500);
		setSize(800,600);     
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 10, 760, 270);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JButton btnStart = new JButton("시작");
		btnStart.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setBounds(77, 119, 150, 50);
		panel1.add(btnStart);
		
		JButton btnStop = new JButton("정지");
		btnStop.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnStop.setBounds(304, 119, 150, 50);
		panel1.add(btnStop);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnExit.setBounds(531, 119, 150, 50);
		panel1.add(btnExit);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 279, 760, 272);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblMessage = new JLabel("New label");
		lblMessage.setIcon(new ImageIcon("C:\\Users\\green\\Desktop\\kiwi.jpg"));
		lblMessage.setBounds(130, 60, 223, 155);
		panel2.add(lblMessage);

	}

	public static void main(String[] args) {
		new T1();
	}
}
