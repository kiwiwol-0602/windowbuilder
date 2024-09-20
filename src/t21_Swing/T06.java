package t21_Swing;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T06 extends JFrame{
   JPanel pn1;
   JButton btnExit;
   CheckboxGroup gender;
   Checkbox rdGender1, rdGender2, rdGender3;
   
   public T06() {
      setTitle("라디오버튼 연습");
      setSize(1000, 700);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);
      
      setLayout(new FlowLayout());
      
      pn1 = new JPanel();
      
      gender = new CheckboxGroup();
      rdGender1 = new Checkbox("남자", gender, true);
      rdGender2 = new Checkbox("여자", gender, false);
      rdGender3 = new Checkbox("중성", gender, false);
      
      pn1.add(rdGender1);
      pn1.add(rdGender2);
      pn1.add(rdGender3);
      
      add(pn1);
      
      
      setVisible(true);
      
      /*   =============================================   */
      
   }
   
   public static void main(String[] args) {
      new T06();
   }
}
