package t22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T2 extends JFrame{
	JPanel pn1, pn2, pn3;
	JButton btn1, btn2, btn3, btn4, btn5, btnExit, btnRand;
	JLabel lblTitle, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl10, lbl11, lbl12, lbl13;
	int[] cnt  = new int[4];
	
	public T2() {
		setTitle("연습하기");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 146);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("이미지 연습창");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(194, 10, 412, 113);
		pn1.add(lblTitle);
		
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btnExit.setBounds(613, 10, 159, 58);
		pn1.add(btnExit);
		
		btnRand = new JButton("랜덤보기");
		btnRand.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btnRand.setBounds(12, 10, 159, 58);
		pn1.add(btnRand);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 144, 784, 271);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lbl1 = new JLabel("");
		lbl1.setIcon(new ImageIcon(T2.class.getResource("/t22_Swing/images/0.jpg")));
		lbl1.setBounds(36, 10, 138, 251);
		pn2.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon(T2.class.getResource("/t22_Swing/images/1.jpg")));
		lbl2.setBounds(230, 10, 138, 251);
		pn2.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon("C:\\Users\\green\\Desktop\\2.jpg"));
		lbl3.setBounds(414, 10, 138, 251);
		pn2.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setIcon(new ImageIcon("C:\\Users\\green\\Desktop\\3.jpg"));
		lbl4.setBounds(598, 10, 138, 251);
		pn2.add(lbl4);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 415, 784, 146);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btn1 = new JButton("그림1");
		btn1.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btn1.setBounds(39, 40, 110, 58);
		pn3.add(btn1);
		
		btn2 = new JButton("그림2");
		btn2.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btn2.setBounds(188, 40, 110, 58);
		pn3.add(btn2);
		
		btn3 = new JButton("그림3");
		btn3.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btn3.setBounds(337, 40, 110, 58);
		pn3.add(btn3);
		
		btn4 = new JButton("그림4");
		btn4.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btn4.setBounds(486, 40, 110, 58);
		pn3.add(btn4);
		
		btn5 = new JButton("모두보기");
		btn5.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btn5.setBounds(635, 40, 110, 58);
		pn3.add(btn5);
		
		lbl5 = new JLabel("횟수 :");
		lbl5.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		lbl5.setBounds(39, 108, 47, 15);
		pn3.add(lbl5);
		
		lbl6 = new JLabel("횟수 :");
		lbl6.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		lbl6.setBounds(188, 108, 47, 15);
		pn3.add(lbl6);
		
		lbl7 = new JLabel("횟수 :");
		lbl7.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		lbl7.setBounds(337, 108, 47, 15);
		pn3.add(lbl7);
		
		lbl8 = new JLabel("횟수 :");
		lbl8.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		lbl8.setBounds(486, 108, 47, 15);
		pn3.add(lbl8);
		
		lbl10 = new JLabel("");
		lbl10.setBounds(92, 108, 57, 15);
		pn3.add(lbl10);
		
		lbl11 = new JLabel("");
		lbl11.setBounds(241, 108, 57, 15);
		pn3.add(lbl11);
		
		lbl12 = new JLabel("");
		lbl12.setBounds(390, 108, 57, 15);
		pn3.add(lbl12);
		
		lbl13 = new JLabel("");
		lbl13.setBounds(539, 108, 57, 15);
		pn3.add(lbl13);
		
		
		setVisible(true);
		
		/*==============================================*/
		
		//종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//1번 그림보기
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(true);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		//2번 그림보기
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(true);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		//3번 그림보기
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(true);
				lbl4.setVisible(false);
			}
		});
		//4번 그림보기
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(true);
			}
		});
		//모든그림보기
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(true);
				lbl2.setVisible(true);
				lbl3.setVisible(true);
				lbl4.setVisible(true);
			}
		});
		
		//랜덤그림보기
		btnRand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random random = new Random();
				
				switch (random.nextInt(4)+1) {
					case 1:
						lbl1.setVisible(false);
						lbl2.setVisible(true);
						lbl3.setVisible(false);
						lbl4.setVisible(false);
						cnt[0]++;
						break;
					case 2:
						lbl1.setVisible(false);
						lbl2.setVisible(true);
						lbl3.setVisible(false);
						lbl4.setVisible(false);
						cnt[1]++;
						break;
					case 3:
						lbl1.setVisible(false);
						lbl2.setVisible(false);
						lbl3.setVisible(true);
						lbl4.setVisible(false);
						cnt[2]++;
						break;
					case 4:
						lbl1.setVisible(false);
						lbl2.setVisible(false);
						lbl3.setVisible(false);
						lbl4.setVisible(true);
						cnt[3]++;
						break;

					default:
						break;
				}
					lbl10.setText(cnt[0]+"");
					lbl11.setText(cnt[1]+"");
					lbl12.setText(cnt[2]+"");
					lbl13.setText(cnt[3]+"");
			}
		});
	}
	
	public static void main(String[] args) {
		new T2();
	}
}
