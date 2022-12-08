package JavaProject;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Frame extends JFrame{
	String s;
	Connection conn;
	final String URL="jdbc:sqlserver://10.0.0.19:1433;databaseName=Inventory;";
	final String USER="sa";
	final String PASSWORD="123456";
	Statement st;
	ResultSet rs;
	
	

	JLabel jl1=new JLabel("SKU: ");
	JLabel jl2=new JLabel("Brand: ");
	JLabel jl3=new JLabel("Name: ");
	JLabel jl4=new JLabel("Delete: ");
	JLabel jl5=new JLabel("Add: ");
	JLabel jl6=new JLabel("Update: ");
	

	JTextField jt1=new JTextField(20);
	JTextField jt2=new JTextField(20);
	JTextField jt3=new JTextField(20);
	JTextField jt4=new JTextField(20);
	JTextField jt5=new JTextField(20);
	JTextField jt6=new JTextField(20);

	
	
	JButton jb1=new JButton("Check");
	JButton jb2=new JButton("Check");
	JButton jb3=new JButton("Check");
	JButton jb4=new JButton("Delete");
	JButton jb5=new JButton("Add");
	JButton jb6=new JButton("Update");
	
	
	JTextArea jt=new JTextArea("jt");
	
	
	public void createframe() {
		this.setTitle("Inventory Check");
		this.setLayout(null);
		this.setLocation(300,100);
		this.setSize(800, 700);
		this.setLayout(null);
		
		
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		JPanel jp6=new JPanel();
		JPanel jp7=new JPanel();
	
		jp1.setBounds(10, 10, 700, 60);
		jp2.setBounds(10, 80, 700, 60);
		jp3.setBounds(10, 150, 700, 60);
		jp4.setBounds(10, 220, 700, 60);
		jp5.setBounds(10, 290, 700, 60);
		jp6.setBounds(10, 360, 700, 60);
		jp7.setBounds(10, 400, 700, 160);
		
		
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp4.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp5.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp6.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp7.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.add(jp7);
		
		jp1.add(jl1);
		jp1.add(jt1);
		jp1.add(jb1);
		jp2.add(jl2);
		jp2.add(jt2);
		jp2.add(jb2);
		jp3.add(jl3);
		jp3.add(jt3);
		jp3.add(jb3);
		jp4.add(jl4);
		jp4.add(jt4);
		jp4.add(jb4);
		jp5.add(jl5);
		jp5.add(jt5);
		jp5.add(jb5);
		jp6.add(jl6);
		jp6.add(jt6);
		jp6.add(jb6);
		jp7.add(jt);
		this.setVisible(true);
		
		
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jb1) {
					if(jt1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter the SKU!","Error!",JOptionPane.ERROR_MESSAGE);
						jt1.grabFocus();
					}
					else {
						JOptionPane.showMessageDialog(null, "Search successful!","Success!",JOptionPane.INFORMATION_MESSAGE);
						s=jt1.getText();
						try {
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							conn=DriverManager.getConnection(URL,USER,PASSWORD);
							String sql="select * From Shoes Where SKU = '"+s+"'"+"\n";
							st=conn.createStatement();
							rs=st.executeQuery(sql);
							if(rs.next()) {
								jt.setText("SKU:"+rs.getString("SKU")+", Brand:"+rs.getString("Brand")+", Name: "+rs.getString("Name")+"\n");
							}
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Database connection failed"+e1.getMessage());
						}
						
					}
				}
				jt1.setText("");
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jb2) {
					if(jt2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter the Brand!","Error!",JOptionPane.ERROR_MESSAGE);
						jt2.grabFocus();
					}
					else {
						JOptionPane.showMessageDialog(null, "Search successful!","Success!",JOptionPane.INFORMATION_MESSAGE);
						s=jt2.getText();
						try {
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							conn=DriverManager.getConnection(URL,USER,PASSWORD);
							String sql="select * FROM Shoes WhERE Brand ='"+s+"'";
							st=conn.createStatement();
							rs=st.executeQuery(sql);
							if(rs.next()) {
								jt.setText("SKU: "+rs.getString("SKU")+"，Brand: "+rs.getString("Brand")+"，Name: "+rs.getString("Name")+'\n');
							}
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Database connection failed"+e1.getMessage());
						}
						jt2.setText("");
					}
				}
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb3) {
					if(jt3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter the Name!","Error!",JOptionPane.ERROR_MESSAGE);
						jt3.grabFocus();
					}
					else {
						JOptionPane.showMessageDialog(null, "Search successful!","Success!",JOptionPane.INFORMATION_MESSAGE);
						s=jt3.getText();
						try {
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							conn=DriverManager.getConnection(URL,USER,PASSWORD);
							String sql="select * FROM Shoes WHERE Name ='"+s+"'";
							st=conn.createStatement();
							rs=st.executeQuery(sql);
							if(rs.next()) {
								jt.setText("SKU: "+rs.getString("SKU")+"，Brand:"+rs.getString("Brand")+"，Name: "+rs.getString("Name")+'\n');
							}
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Database connection failed"+e1.getMessage());
						}
						jt3.setText("");
					}
				}
			}
		});
		
		
				
	}
	
}



