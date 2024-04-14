package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class calculator implements ActionListener  {
    JFrame jf;
    JTextField jtf;
    JButton nb[]=new JButton[10];
    JButton fb[]=new JButton[9];
    JButton addButton, subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negeButton;
    JPanel panel;
    Font myFont= new Font("",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    calculator(){
            jf=new JFrame("Calculator");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(415,550);
            jf.setLayout(null);


           jtf=new JTextField();
           jtf.setBounds(46,25,300,50);
           jtf.setFont(myFont);
           jtf.setEditable(false);
           
            addButton =new JButton("+");
            subButton =new JButton("-");
            mulButton =new JButton("*");
            divButton =new JButton("/");
            decButton =new JButton(".");
            equButton =new JButton("=");
            delButton =new JButton("Del");
            clrButton =new JButton("Clr");
            negeButton=new JButton("(-)");
            fb[0]=addButton;
            fb[1]=subButton;
            fb[2]=mulButton;
            fb[3]=divButton;
            fb[4]=decButton;
            fb[5]=equButton;
            fb[6]=delButton;
            fb[7]=clrButton;
            fb[8]=negeButton;

            for (int i=0;i<9;i++){
              fb[i].addActionListener(this);
              fb[i].setFont(myFont);
              fb[i].setFocusable(false);

            }
            for(int i=0;i<10;i++){
                nb[i]=new JButton(String.valueOf(i));
                nb[i].addActionListener(this);
                nb[i].setFont(myFont);
                nb[i].setFocusable(false);
            }
             negeButton.setBounds(50,430,100,50);
             delButton.setBounds(150,430,100,50);
             clrButton.setBounds(250,430,100,50);
             panel=new JPanel();
             panel.setBounds(50,100,300,300);
             panel.setLayout(new GridLayout(4,4,10,10));
             //panel.setBackground(Color.LIGHT_GRAY);
             panel.add(nb[1]);
             panel.add(nb[2]);
             panel.add(nb[3]);
             panel.add(addButton);
             panel.add(nb[4]);
             panel.add(nb[5]);
             panel.add(nb[6]);
             panel.add(subButton);
             panel.add(nb[7]);
             panel.add(nb[8]);
             panel.add(nb[9]);
             panel.add(mulButton);
             panel.add(decButton);
             panel.add(nb[0]);
             panel.add(equButton);
             panel.add(divButton);




             
            jf.add(panel);
            jf.add(negeButton);
            jf.add(delButton);
            jf.add(clrButton);
            jf.add(jtf);
            jf.setVisible(true);
    }
    
    public static void main(String[] args) {
      new calculator();
        
    }
    public void actionPerformed(ActionEvent e) {
      for(int i=0;i<10;i++){
        if(e.getSource()==nb[i]){
          jtf.setText(jtf.getText().concat(String.valueOf(i)));
        }
      }
      if(e.getSource()==decButton){
        jtf.setText(jtf.getText().concat("."));
      }
      if(e.getSource()==addButton){
        num1=Double.parseDouble(jtf.getText());
        operator='+';
        jtf.setText("");
      }
      if(e.getSource()==subButton){
        num1=Double.parseDouble(jtf.getText());
        operator='-';
        jtf.setText("");
      }
      if(e.getSource()==mulButton){
        num1=Double.parseDouble(jtf.getText());
        operator='*';
        jtf.setText("");
      }
      if(e.getSource()==divButton){
        num1=Double.parseDouble(jtf.getText());
        operator='/';
        jtf.setText("");
      }
      if(e.getSource()==equButton){
        num2=Double.parseDouble(jtf.getText());
        switch (operator) {
            case '*':result=num1*num2;
              break;
            case '/':result=num1/num2;
              break;
            case '+':result=num1+num2;
              break;
            case '-':result=num1-num2;
              break;
      }
      jtf.setText(String.valueOf(result));
      num1=result;
      }
      if(e.getSource()==clrButton){
        jtf.setText("");
      }
      if(e.getSource()==delButton){
      String str=jtf.getText();
      jtf.setText("");
      for(int i=0;i<str.length()-1;i++){
        jtf.setText(jtf.getText()+str.charAt(i));
      }

    }
    if(e.getSource()==negeButton){
      double temp=Double.parseDouble(jtf.getText());
      temp*=-1;
      jtf.setText(String.valueOf(temp));
    }
  }
    
}

