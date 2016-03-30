package cal;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class cal {
	static boolean yet=false,point=false;

	public static void main(String[] args){
		
		Label l = new Label("0",2);
		Label l2 = new Label("",2);
		Label l3 = new Label("",1);
		
		Frame f = new Frame("calculator");
		f.setBounds(100,200,550,400);		
		
		f.setResizable(false);
		f.setVisible(true);
		f.setLayout(null);
		
		Panel p1 = new Panel(new GridLayout(4,3));
		Panel p2 = new Panel(new GridLayout(5,1));
		p1.setBounds(90,150,300,240);
		p2.setBounds(400,150,70,240);		
		f.add(l);
		f.add(p1);
		f.add(p2);
		
		ActionListener nh= new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    String n=((JButton)(e.getSource())).getText();
		    if(yet){
			    if(l2.getText()!="0")
				    l2.setText(l2.getText()+n);
				    else
				    l2.setText(n);
		    }else{
		    if(l.getText()!="0")
		    l.setText(l.getText()+n);
		    else
		    l.setText(n);
		    }
		    }
		};
		
		ActionListener ph= new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    String n=((JButton)(e.getSource())).getText();
		    if(yet){
			    if(point!=true){
			    l2.setText(l2.getText()+n);
			    point=true;
			    }else
			    JOptionPane.showMessageDialog(null,  "已有小數點","錯誤",0);
			    
		    }else{
			    if(point!=true){
			    l.setText(l.getText()+n);
			    point=true;
			    }else
			    JOptionPane.showMessageDialog(null,  "已有小數點","錯誤",0);
		    }   
		    }
		};
		

		ActionListener ch= new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    l.setText("0");
		    l2.setText("");
		    l3.setText("");
		    yet=false;
		    point=false;
		    }
		};

		ActionListener sh= new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    	String n=((JButton)(e.getSource())).getText();
			    l3.setText(n);
			    if(!yet)
			    point=false;
			    	
			    yet=true;
		    }
		};

		ActionListener eh= new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    l.setText(cc(l.getText(),l2.getText(),l3.getText())+"");
			    l2.setText("");
			    l3.setText("");
			    yet=false;
			    point=false;
		    }
		};
		
		
		for(int i=1;i<=9;i++){
			JButton b = new JButton(""+i);
			p1.add(b);
			b.addActionListener(nh);
		}
		
	
		 JButton Z = new JButton("0");
		    p1.add(Z);
			Z.addActionListener(nh);
			
		 JButton S = new JButton(".");
		    p1.add(S);
		    S.addActionListener(ph);
		 JButton amo = new JButton("=");
		    p1.add(amo);		 
		    amo.addActionListener(eh);
		 JButton ad = new JButton("+");
		    p2.add(ad);		   
		    ad.addActionListener(sh);
		 JButton sub = new JButton("-");
		    p2.add(sub);		   
		    sub.addActionListener(sh);
		 JButton mul = new JButton("*");
		    p2.add(mul);		   
		    mul.addActionListener(sh);
		 JButton div = new JButton("/");
		    p2.add(div);  
		    div.addActionListener(sh);
		 JButton C = new JButton("C");
		    p2.add(C);
		    C.addActionListener(ch);
		    
		
		    //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    
		    f.addWindowListener(new WindowAdapter(){
		    	public void windowClosing(WindowEvent e){System.exit(0);}});  
		        f.add(l);
		        f.add(l2);
		        f.add(l3);
		        l.setBounds(150,20,350,50);
		        l.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		        l2.setBounds(150,70,350,50);
		        l2.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		        l3.setBounds(50,20,100,100);
		        l3.setFont(new Font("微軟正黑體", Font.BOLD, 32));

		        Color c = Color.LIGHT_GRAY;
		        l.setBackground(c);
		        l2.setBackground(c);
		        l3.setBackground(c);
		        f.add(p1);
		        f.add(p2);
		        f.setVisible(true);
		
	}
	
	public static double cc(String a,String b,String x)
	{
		double s=0;
		double d1 = Double.valueOf(a).doubleValue();
		double d2 = Double.valueOf(b).doubleValue();
		switch(x){
		case "+":
			s=d1+d2;
			break;
		case "-":
			s=d1-d2;
			break;
		case "*":
			s=d1*d2;
			break;
		case "/":
			s=d1/d2;
			break;
		}
		return s;
	}

}
