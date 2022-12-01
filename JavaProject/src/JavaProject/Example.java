package JavaProject;
import java.awt.*;
import javax.swing.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Example extends JFrame implements ActionListener {
	JButton jb1,jb2;
	JPanel jp=null;

public static void main(String[] args) {
Example test=new Example();
}


public Example(){
		jb1=new JButton("Login");
		jb2=new JButton("Cancel");
		jp=new JPanel();
		jp.add(jb1);
		jp.add(jb2);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		this.add(jp,BorderLayout.SOUTH);
		this.setBounds(600,300,200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

}


public void actionPerformed(ActionEvent e) {

	if(e.getSource()==jb1){
		LoginWin lw=new LoginWin();

}
	else if(e.getSource()==jb2){
		System.exit(0);

		}

	}



}

class LoginWin extends JFrame {

public LoginWin()

{

this.setBounds(100,100,200,200);



this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
this.setVisible(true);

}

}