package t23_Hoewon;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class HoewonInput extends JFrame{
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
  JPanel pn1, pn2, pn3;
  JLabel lblTitle, lblName, lblAge, lblGender, lblJoinday, lblAddress, lblYY, lblMM, lblDD;
  JComboBox cbYY, cbMM, cbDD;
  JRadioButton rdMale, rdFemale;
  JButton btnInput, btnReset, btnClose;
  
  HoewonVO vo = new HoewonVO();
  HoewonDAO dao = new HoewonDAO();
  int res = 0;
  
	
	public HoewonInput() {
		setTitle("회원등록");
    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setLayout(null);
    
    pn1 = new JPanel();
    pn1.setBounds(0, 0, 784, 110);
    getContentPane().add(pn1);
    pn1.setLayout(null);
    
    lblTitle = new JLabel("회 원 가 입 폼");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
    lblTitle.setBounds(0, 0, 784, 110);
    pn1.add(lblTitle);
    
    pn2 = new JPanel();
    pn2.setBounds(0, 112, 784, 339);
    getContentPane().add(pn2);
    pn2.setLayout(null);
    
    lblName = new JLabel("성    명");
    lblName.setFont(new Font("굴림", Font.BOLD, 20));
    lblName.setHorizontalAlignment(SwingConstants.CENTER);
    lblName.setBounds(116, 26, 149, 36);
    pn2.add(lblName);
    
    lblAge = new JLabel("나    이");
    lblAge.setHorizontalAlignment(SwingConstants.CENTER);
    lblAge.setFont(new Font("굴림", Font.BOLD, 20));
    lblAge.setBounds(116, 88, 149, 36);
    pn2.add(lblAge);
    
    lblGender = new JLabel("성    별");
    lblGender.setHorizontalAlignment(SwingConstants.CENTER);
    lblGender.setFont(new Font("굴림", Font.BOLD, 20));
    lblGender.setBounds(116, 150, 149, 36);
    pn2.add(lblGender);
    
    lblJoinday = new JLabel("가 입 일");
    lblJoinday.setHorizontalAlignment(SwingConstants.CENTER);
    lblJoinday.setFont(new Font("굴림", Font.BOLD, 20));
    lblJoinday.setBounds(116, 212, 149, 36);
    pn2.add(lblJoinday);
    
    lblAddress = new JLabel("주    소");
    lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
    lblAddress.setFont(new Font("굴림", Font.BOLD, 20));
    lblAddress.setBounds(116, 274, 149, 36);
    pn2.add(lblAddress);
    
    txtName = new JTextField();
    txtName.setFont(new Font("굴림", Font.BOLD, 20));
    txtName.setBounds(268, 26, 328, 36);
    pn2.add(txtName);
    txtName.setColumns(10);
    
    txtAge = new JTextField();
    txtAge.setFont(new Font("굴림", Font.BOLD, 20));
    txtAge.setColumns(10);
    txtAge.setBounds(268, 88, 328, 36);
    pn2.add(txtAge);
    
    txtAddress = new JTextField();
    txtAddress.setFont(new Font("굴림", Font.BOLD, 20));
    txtAddress.setColumns(10);
    txtAddress.setBounds(268, 274, 328, 36);
    pn2.add(txtAddress);
    
    rdMale = new JRadioButton("남자");
    buttonGroup.add(rdMale);
    rdMale.setFont(new Font("굴림", Font.BOLD, 20));
    rdMale.setBounds(268, 159, 121, 23);
    pn2.add(rdMale);
    
    rdFemale = new JRadioButton("여자");
    rdFemale.setSelected(true);
    buttonGroup.add(rdFemale);
    rdFemale.setFont(new Font("굴림", Font.BOLD, 20));
    rdFemale.setBounds(475, 159, 121, 23);
    pn2.add(rdFemale);
    
    // 년도/월/일 초기값 생성하기
    String[] yy = new String[20];
    String[] mm = new String[12];
    String[] dd = new String[31];
    
    int imsi = 0;
    for(int i=0; i<yy.length; i++) {
    	imsi = 2024-i;
    	yy[i] = imsi + "";
    }
    for(int i=0; i<mm.length; i++) {
    	mm[i] = (i+1) + "";
    }
    for(int i=0; i<dd.length; i++) {
    	dd[i] = (i+1) + "";
    }
    
    
    cbYY = new JComboBox(yy);
    cbYY.setFont(new Font("굴림", Font.BOLD, 15));
    cbYY.setBounds(268, 212, 79, 36);
    pn2.add(cbYY);
    
    lblYY = new JLabel("년");
    lblYY.setFont(new Font("굴림", Font.BOLD, 20));
    lblYY.setBounds(357, 212, 34, 37);
    pn2.add(lblYY);
    
    cbMM = new JComboBox(mm);
    cbMM.setFont(new Font("굴림", Font.BOLD, 15));
    cbMM.setBounds(420, 213, 54, 36);
    pn2.add(cbMM);
    
    lblMM = new JLabel("월");
    lblMM.setFont(new Font("굴림", Font.BOLD, 20));
    lblMM.setBounds(484, 212, 34, 37);
    pn2.add(lblMM);
    
    cbDD = new JComboBox(dd);
    cbDD.setFont(new Font("굴림", Font.BOLD, 15));
    cbDD.setBounds(553, 213, 54, 36);
    pn2.add(cbDD);
    
    lblDD = new JLabel("일");
    lblDD.setFont(new Font("굴림", Font.BOLD, 20));
    lblDD.setBounds(617, 212, 34, 37);
    pn2.add(lblDD);
    
    pn3 = new JPanel();
    pn3.setBounds(0, 451, 784, 110);
    getContentPane().add(pn3);
    pn3.setLayout(null);
    
    btnInput = new JButton("가입하기");
    btnInput.setFont(new Font("굴림", Font.BOLD, 18));
    btnInput.setBounds(54, 10, 189, 90);
    pn3.add(btnInput);
    
    btnReset = new JButton("다시입력");
    btnReset.setFont(new Font("굴림", Font.BOLD, 18));
    btnReset.setBounds(297, 10, 189, 90);
    pn3.add(btnReset);
    
    btnClose = new JButton("종   료");
    btnClose.setFont(new Font("굴림", Font.BOLD, 18));
    btnClose.setBounds(540, 10, 189, 90);
    pn3.add(btnClose);
    
    /*===================================================*/
    setVisible(true);
    /*===================================================*/
    
    // 회원가입 버튼을 키보드 엔터키로 쳤을때 수행처리
    btnInput.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		setHoewonInput();
    	}
		});
    
    // 회원가입 버튼 클릭(마우스로 클릭시에 수행된다.)
    btnInput.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		setHoewonInput();
    	}
    });
    
    // 창닫기 버튼 클릭
    btnClose.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		dispose();
    		new HoewonMain();
    	}
    });
	}

	//회원가입처리 메소드
	protected void setHoewonInput() {
		String name = txtName.getText().trim();
		String age = txtAge.getText().trim();
		String gender = "";
		String joinday = cbYY.getSelectedItem() +"-"+cbMM.getSelectedItem() +"-"+cbDD.getSelectedItem();
		String adress = txtAddress.getText().trim();
		
		//유효성 검사
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "성명을 입력하세요.");
			txtName.requestFocus();
		}
		else if(!Pattern.matches("^[0-9]+$", age)) {
			JOptionPane.showMessageDialog(null, "나이를 숫자로 입력하세요.");
			txtAge.requestFocus();
		}
		else {
			if(rdMale.isSelected()) gender = "남자";
			else gender = "여자";
			
			//모든 체크가 정상적으로 끝나면 DB에 새로운 회원을 저장한다.
			//회원 중복처리 할것........
			
			//회원 중복처리가 끝난 정상적인 자료는 DB에 저장처리한다.
			vo.setName(name);
			vo.setAge(Integer.parseInt(age));
			vo.setGender(gender);
			vo.setJoinday(joinday);
			vo.setAddress(adress);
			
			res = dao.setHoewonInput(vo);
			
			if(res != 0) {
				JOptionPane.showMessageDialog(null, "회원에 가입되셨습니다.");
				dispose();
				new HoewonMain();
			}
			else {
				JOptionPane.showMessageDialog(null, "회원 가입 실패");
				txtName.requestFocus();
			}
		}
	}
}
//public static void main(String[] args) {
//		new HoewonInput();
//}
