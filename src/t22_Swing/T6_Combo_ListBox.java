package t22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T6_Combo_ListBox extends JFrame{
	JPanel pn1,pn2,pn3,pn4;
	JLabel lblTitle, lblMsg;
	JComboBox comboJob;
	JList listjob1, listjob2;
	JButton btnCombo,btnList1,btnList2,btnExit;
	JTextArea textArea;
	
	public T6_Combo_ListBox() {
		setTitle("콤보상자/리스트박스 연습");
    setSize(600,480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setLayout(null);
    
    pn1 = new JPanel();
    pn1.setBounds(0, 0, 296, 247);
    getContentPane().add(pn1);
    pn1.setLayout(null);
    
    lblTitle = new JLabel("직업을 선택하세요");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setFont(new Font("굴림", Font.BOLD, 15));
    lblTitle.setBounds(12, 10, 272, 36);
    pn1.add(lblTitle);
    
    comboJob = new JComboBox();
    comboJob.setFont(new Font("굴림", Font.BOLD, 12));
    comboJob.setModel(new DefaultComboBoxModel(new String[] {"학   생", "군   인", "회사원", "변호사", "프리랜서", "공무원", "기   타"}));
    comboJob.setBounds(12, 45, 272, 36);
    pn1.add(comboJob);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 91, 272, 146);
    pn1.add(scrollPane);
    
    textArea = new JTextArea();
    scrollPane.setViewportView(textArea);
    
    pn2 = new JPanel();
    pn2.setBounds(294, 0, 290, 247);
    getContentPane().add(pn2);
    pn2.setLayout(null);
    
    listjob1 = new JList();
    listjob1.setModel(new AbstractListModel() {
    	String[] values = new String[] {"학   생", "군   인", "의   사", "회사원", "변호사", "자영업", "공무원", "기   타"};
    	public int getSize() {
    		return values.length;
    	}
    	public Object getElementAt(int index) {
    		return values[index];
    	}
    });
    listjob1.setBounds(12, 10, 266, 96);
    pn2.add(listjob1);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(12, 116, 266, 121);
    pn2.add(scrollPane_1);
    
    listjob2 = new JList();
    listjob2.setModel(new AbstractListModel() {
    	String[] values = new String[] {"학   생", "군   인", "의   사", "회사원", "변호사", "자영업", "공무원", "기   타"};
    	public int getSize() {
    		return values.length;
    	}
    	public Object getElementAt(int index) {
    		return values[index];
    	}
    });
    listjob2.setToolTipText("");
    scrollPane_1.setViewportView(listjob2);
    
    pn3 = new JPanel();
    pn3.setBounds(0, 250, 584, 93);
    getContentPane().add(pn3);
    pn3.setLayout(null);
    
    btnCombo = new JButton("콤보출력");
    btnCombo.setFont(new Font("굴림", Font.BOLD, 15));
    btnCombo.setBounds(3, 10, 142, 73);
    pn3.add(btnCombo);
    
    btnList1 = new JButton("리스트출력1");
    btnList1.setFont(new Font("굴림", Font.BOLD, 15));
    btnList1.setBounds(148, 10, 142, 73);
    pn3.add(btnList1);
    
    btnList2 = new JButton("리스트출력2");
    btnList2.setFont(new Font("굴림", Font.BOLD, 15));
    btnList2.setBounds(293, 10, 142, 73);
    pn3.add(btnList2);
    
    btnExit = new JButton("작업종료");
    btnExit.setFont(new Font("굴림", Font.BOLD, 15));
    btnExit.setBounds(438, 10, 142, 73);
    pn3.add(btnExit);
    
    pn4 = new JPanel();
    pn4.setBounds(0, 342, 584, 99);
    getContentPane().add(pn4);
    pn4.setLayout(null);
    
    lblMsg = new JLabel("출력 메세지");
    lblMsg.setFont(new Font("굴림", Font.BOLD, 15));
    lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
    lblMsg.setBounds(0, 0, 584, 99);
    pn4.add(lblMsg);
    
    
    
    
/*   ===============================   */
    setVisible(true);
/*   ===============================   */
 
    //콤보 버튼
    btnCombo.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String msg = comboJob.getSelectedItem().toString() + "("+comboJob.getSelectedIndex()+")";
    		lblMsg.setText(msg);
    		JOptionPane.showMessageDialog(null, msg);
    		textArea.setText(msg);
    		
    	}
    });
    //리스트1 버튼
    btnList1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
//    		Object[] jobs = listjob1.getSelectedValues();
    		List<String> jobs = listjob1.getSelectedValuesList();
    		String msg = "";
    		for(String job : jobs) {
    			msg += job + "/";
    		}
    		msg = msg.substring(0, msg.length()-1);
    		
    		lblMsg.setText(msg);
    	}
    });
    //리스트2 버튼
    btnList2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		List<String> jobs = listjob2.getSelectedValuesList();
    		String msg = "";
    		for(String job : jobs) {
    			msg += job + "/";
    		}
    		msg = msg.substring(0, msg.length()-1);
    		
    		lblMsg.setText(msg);
    	}
    });
    //작업종료
    btnExit.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.exit(0);
    	}
    });
    
    
	
	
	
	
	}
	
	public static void main(String[] args) {
		new T6_Combo_ListBox();
	}
}
