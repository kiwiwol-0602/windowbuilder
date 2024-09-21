package t22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class T4_TextField extends JFrame{
	JPanel pn1, pn2, pn3;
	JTextField txtMid, txtName, txtAge;
	JLabel lblNewLabel, lblMid, lblPwd, lblName, lblAge, lblNewLabel_1;
	JButton btnInput, btnReset, btnExit;
	JPasswordField txtPwd;
	
	String regAge = "^[0-9]+$";
	
   public T4_TextField() {
      setTitle("텍스트박스 연습");
      setSize(600,480);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);
      getContentPane().setLayout(null);
      
      pn1 = new JPanel();
      pn1.setBackground(Color.ORANGE);
      pn1.setBounds(12, 10, 560, 46);
      getContentPane().add(pn1);
      pn1.setLayout(null);
      
      lblNewLabel = new JLabel("회원가입");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 23));
      lblNewLabel.setBounds(0, 0, 560, 46);
      pn1.add(lblNewLabel);
      
      pn2 = new JPanel();
      pn2.setBackground(Color.CYAN);
      pn2.setBounds(12, 385, 560, 46);
      getContentPane().add(pn2);
      pn2.setLayout(null);
      
      btnInput = new JButton("회원가입");
      btnInput.setBounds(65, 10, 99, 26);
      pn2.add(btnInput);
      
      btnReset = new JButton("다시입력");
      btnReset.setBounds(229, 12, 99, 26);
      pn2.add(btnReset);
      
      btnExit = new JButton("작업종료");
      btnExit.setBounds(393, 12, 99, 26);
      pn2.add(btnExit);
      
      pn3 = new JPanel();
      pn3.setBounds(12, 66, 560, 309);
      getContentPane().add(pn3);
      pn3.setLayout(null);
      
      lblMid = new JLabel("아이디");
      lblMid.setHorizontalAlignment(SwingConstants.CENTER);
      lblMid.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      lblMid.setBounds(78, 35, 136, 33);
      pn3.add(lblMid);
      
      lblPwd = new JLabel("비밀번호");
      lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
      lblPwd.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      lblPwd.setBounds(78, 103, 136, 33);
      pn3.add(lblPwd);
      
      lblName = new JLabel("성명");
      lblName.setHorizontalAlignment(SwingConstants.CENTER);
      lblName.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      lblName.setBounds(78, 171, 136, 33);
      pn3.add(lblName);
      
      lblAge = new JLabel("나이");
      lblAge.setHorizontalAlignment(SwingConstants.CENTER);
      lblAge.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      lblAge.setBounds(78, 239, 136, 33);
      pn3.add(lblAge);
      
      txtMid = new JTextField();
      txtMid.setHorizontalAlignment(SwingConstants.LEFT);
      txtMid.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      txtMid.setBounds(251, 35, 212, 33);
      pn3.add(txtMid);
      txtMid.setColumns(10);
      
      txtPwd = new JPasswordField();
      txtPwd.setHorizontalAlignment(SwingConstants.LEFT);
      txtPwd.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      txtPwd.setBounds(251, 103, 212, 33);
      pn3.add(txtPwd);
      
      txtName = new JTextField();
      txtName.setHorizontalAlignment(SwingConstants.LEFT);
      txtName.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      txtName.setColumns(10);
      txtName.setBounds(251, 171, 212, 33);
      pn3.add(txtName);
      
      txtAge = new JTextField();
      txtAge.setHorizontalAlignment(SwingConstants.LEFT);
      txtAge.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
      txtAge.setColumns(10);
      txtAge.setBounds(251, 239, 212, 33);
      pn3.add(txtAge);
      
      lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setIcon(new ImageIcon(T4_TextField.class.getResource("/t22_Swing/images/21.jpg")));
      lblNewLabel_1.setBounds(0, 0, 560, 309);
      pn3.add(lblNewLabel_1);
      /*=====================================*/
      setVisible(true);
      
      /*   ===============================   */
      
      //회원가입버튼 클릭
      btnInput.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		if(txtMid.getText().trim().equals("")) {
      			JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
      			txtMid.requestFocus();
      		}
      		else if(txtPwd.getText().trim().equals("")) {
      			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
      			txtPwd.requestFocus();
      		}
      		else if(txtName.getText().trim().equals("")) {
      			JOptionPane.showMessageDialog(null, "성명을 입력하세요.");
      			txtName.requestFocus();
      		}
//      		else if(txtAge.getText().trim().equals("")) {
      		else if(!Pattern.matches(regAge, txtAge.getText().trim())) {
      			JOptionPane.showMessageDialog(null, "나이를 입력하세요.(나이는 숫자만 가능)");
      			 txtAge.requestFocus();
          }
          else {
             JOptionPane.showMessageDialog(null, "회원가입 성공!");
          }
      	}
      });
      //다시입력버튼 클릭
      btnReset.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		txtMid.setText("");
      		txtPwd.setText("");
      		txtName.setText("");
      		txtAge.setText("");
      		txtMid.requestFocus();
      	}
      });
      
      //작업종료버튼 클릭
      btnExit.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		System.exit(0);
      	}
      });
      
      
   }
   
   public static void main(String[] args) {
      new T4_TextField();
   }
}
