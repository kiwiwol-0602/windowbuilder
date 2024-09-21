package t23_Hoewon;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HoewonList extends JFrame{
	private JTable table;
	JPanel pn1, pn2, pn3;
	JButton btnExit;
	Vector title, vData;
	DefaultTableModel dtm;
	JScrollPane scrollPane;
	
	HoewonDAO dao = new HoewonDAO();
	private JComboBox cbList;
	private JComboBox cbAD;
	private JButton btnAlign;
	
	
	public HoewonList() {
		setTitle("회원리스트");
    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
   getContentPane().setLayout(null);
    
    pn1 = new JPanel();
    pn1.setBounds(0, 0, 784, 60);
    getContentPane().add(pn1);
    pn1.setLayout(null);
    
    JButton btnList = new JButton("초기화");
    btnList.setFont(new Font("굴림", Font.PLAIN, 14));
    btnList.setBounds(592, 10, 180, 40);
    pn1.add(btnList);
    
    JLabel lblTitle = new JLabel("회원리스트 전체조회");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
    lblTitle.setBounds(0, 0, 578, 60);
    pn1.add(lblTitle);
    
    pn2 = new JPanel();
    pn2.setBounds(0, 61, 784, 427);
    getContentPane().add(pn2);
    pn2.setLayout(null);
    
    
    
    pn3 = new JPanel();
    pn3.setBounds(0, 488, 784, 73);
    getContentPane().add(pn3);
    pn3.setLayout(null);
    
    btnExit = new JButton("작업종료");
    btnExit.setFont(new Font("굴림", Font.PLAIN, 14));
    btnExit.setBounds(614, 10, 158, 53);
    pn3.add(btnExit);
    
    cbList = new JComboBox();
    cbList.setFont(new Font("굴림", Font.PLAIN, 15));
    cbList.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "가입일", "주소"}));
    cbList.setBounds(12, 10, 143, 53);
    pn3.add(cbList);
    
    cbAD = new JComboBox();
    cbAD.setFont(new Font("굴림", Font.PLAIN, 15));
    cbAD.setModel(new DefaultComboBoxModel(new String[] {"오름차순", "내림차순"}));
    cbAD.setBounds(166, 10, 143, 53);
    pn3.add(cbAD);
    
    btnAlign = new JButton("정렬");
    btnAlign.setFont(new Font("굴림", Font.PLAIN, 14));
    btnAlign.setBounds(321, 10, 96, 53);
    pn3.add(btnAlign);
    
    
    
    // JTable 설계
    //1.'부제목'을 Vector로 만들어 준다. (저장)
	    title = new Vector();
	    title.add("번호");
	    title.add("이름");
	    title.add("나이");
	    title.add("성별");
	    title.add("가입일");
	    title.add("주소");
	    
	    //2. '데이터'를  Vector타입으로 만들어준다. 회원데이터는  데이터베이스에서 가져온다.
	    vData = dao.getHoewonList();
	    //  System.out.println("vData :"+vData);
    
	    //3. DB에서 가져온 자료(vData)와 타이틀(title)을 DefaultTableModel(데이터, 타이틀) 객체에 생성하면서 담아준다.
	    dtm = new DefaultTableModel(vData, title);
	    
	    //4. DefaultTableModel에 담긴 백터타입의 '데이터/타이틀'을 JTable객체 생성시에 담아준다.
	    table = new JTable(dtm);
	    
	    //5. 자료가 담긴 JTable객체를 JScrollPane객체 생성시에 담아준다.
//	    scrollPane.setViewportView(table);
	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(0, 0, 783, 428);
	    pn2.add(scrollPane);
	    
	    //6. 실행시킨후, 출력된 화면에서 결과를 확인한다.
	    
	    // JTable 속성 제어연습
	    // table의 컬럼크기/크기고정/ 셀의 위치고정
	    table.getColumnModel().getColumn(0).setMaxWidth(30); // 컬럼의 최대크기 지정
	    table.getColumnModel().getColumn(0).setResizable(false);// 컬럼의 크기 고정
	    
	    table.getColumnModel().getColumn(2).setMaxWidth(50); // 컬럼의 최대크기 지정
	    table.getColumnModel().getColumn(2).setResizable(false);// 컬럼의 크기 고정
	    table.getTableHeader().setReorderingAllowed(false); //컬럼 위치 고정
	    
	    //테이블안의 셀 내용을 수평정렬하기
	    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	    TableColumnModel tcm = table.getColumnModel();
	    
	    //전체셀 가운데 정렬
	    for(int i=0; i<tcm.getColumnCount(); i++) {
	    	tcm.getColumn(i).setCellRenderer(dtcr);	    	
	    }
    
    
    
    
    
    
    
    /*===================================================*/
    setVisible(true);
    /*===================================================*/
    //초기화 버튼클릭
    btnList.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		vData = dao.getHoewonList();
        dtm.setDataVector(vData, title);
    	}
    });
    //정렬버튼 클릭
    btnAlign.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String list = "";
    		String align = "";
    		
    		if(cbList.getSelectedItem().toString().equals("성명")) {
          list = "name";
       }
       else if(cbList.getSelectedItem().toString().equals("나이")) {
      	 // 나이는 정규식으로 유효성 검사를 해야함 .
      	 list ="age";
       }
       else if(cbList.getSelectedItem().toString().equals("성별")) {
      	 list ="gender";
       }
       else if(cbList.getSelectedItem().toString().equals("가입일")) {
      	 list ="joinday";
       }
       else if(cbList.getSelectedItem().toString().equals("주소")) {
      	 list ="address";
       }
    		
    	 if(cbAD.getSelectedItem().toString().equals("오름차순")) {
    		 align = "a";
       }
       else if(cbAD.getSelectedItem().toString().equals("내림차순")) {
      	 align ="d";
       }
    		vData = dao.getHoewonAlign(list, align);
    		dtm.setDataVector(vData, title);
    	}
    });
    
    //작업종료버튼 클릭
    btnExit.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		dispose();
    		new HoewonMain();
    	}
    });
    
	}
}
