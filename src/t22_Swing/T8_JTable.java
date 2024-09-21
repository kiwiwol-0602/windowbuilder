package t22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import t23_Hoewon.HoewonDAO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class T8_JTable extends JFrame{
	private JTable table;
	JPanel pn1, pn2, pn3;
	JLabel lblNewLabel;
	JButton btnSelect,btnExit;
	Vector title, vData;
	DefaultTableModel dtm;
	JScrollPane scrollPane;
	
	HoewonDAO dao = new HoewonDAO();
	
	
	
	public T8_JTable() {
		setTitle("콤보상자/리스트박스 연습");
    setSize(600,480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setLayout(null);
    
    pn1 = new JPanel();
    pn1.setBounds(0, 0, 584, 60);
    getContentPane().add(pn1);
    pn1.setLayout(null);
    
    lblNewLabel = new JLabel("회 원 리 스 트");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
    lblNewLabel.setBounds(0, 0, 584, 60);
    pn1.add(lblNewLabel);
    
    pn2 = new JPanel();
    pn2.setBounds(0, 61, 584, 317);
    getContentPane().add(pn2);
    pn2.setLayout(null);
    
    
    
    pn3 = new JPanel();
    pn3.setBounds(0, 381, 584, 60);
    getContentPane().add(pn3);
    pn3.setLayout(null);
    
    btnSelect = new JButton("선택셀값출력");
    btnSelect.setFont(new Font("굴림", Font.PLAIN, 14));
    btnSelect.setBounds(12, 10, 153, 40);
    pn3.add(btnSelect);
    
    btnExit = new JButton("작업종료");
    btnExit.setFont(new Font("굴림", Font.PLAIN, 14));
    btnExit.setBounds(419, 10, 153, 40);
    pn3.add(btnExit);
    
    
    
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
	    scrollPane.setBounds(0, 0, 584, 317);
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
	    
    /*==================================*/
    setVisible(true);
    /*==================================*/
    // 선택한 셀
    btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					//System.out.println("선택된 내용 : " + table.getValueAt(row, 0));
					String temp = "성명:"+table.getValueAt(row, 1)+", 나이:"+table.getValueAt(row, 2)+", 성별:"+table.getValueAt(row, 3)
					+", 가입일:"+table.getValueAt(row, 4).toString().substring(0,10)+", 주소:"+table.getValueAt(row, 5);
					JOptionPane.showMessageDialog(null, temp);
				}
				
			}
		});    
//   종료버튼   
   btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   });
    
	}
	
	
	public static void main(String[] args) {
		new T8_JTable();
		
		
		
	}
}
