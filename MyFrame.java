import java.io.*;
import java.lang.String.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class MyFrame implements ActionListener
{
	JFrame f;
	JButton b1,b2;
	JTextField t1;
	JPasswordField t2;
	JLabel l1,l2;
	JPanel p1;
			MyFrame()
			{
				f=new JFrame("LOGIN Frame");
				f.setContentPane(new JLabel(new ImageIcon("C:\\javapgm\\s.jpg")));
				f.setLayout(null);
				p1=new JPanel();
				p1.setBounds(20,20,350,170);
				p1.setBackground(new Color(0,0,0,20));
				p1.setLayout(null);
				
				l1=new JLabel("User Name");
				l1.setBounds(20,20,100,30);
				l2=new JLabel("Password");
				l2.setBounds(20,70,100,30);
				t1=new JTextField(10);
				t1.setBounds(120,20,150,30);
				t2=new JPasswordField(10);
				t2.setBounds(120,70,150,30);
				b1=new JButton("Login");
				b1.setBounds(100,150,80,30);
				b2=new JButton("New");
				b2.setBounds(200,150,80,30);
				
				b1.addActionListener(this);
				b2.addActionListener(this);
				
				f.add(p1);
				p1.add(l1);p1.add(t1);
				p1.add(l2);p1.add(t2);  
				f.add(b1);f.add(b2);
				f.setSize(400,250);
				//t1.setText("abc");
				//t2.setText("234");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
			
			
							public void actionPerformed(ActionEvent ae)
							{	
								String s1=t1.getText();
								String s2=t2.getText();
								try
								{
										if(ae.getSource()==b1)
										{
											Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
											Connection con=DriverManager.getConnection("Jdbc:Odbc:DataDSN");
											PreparedStatement ps=con.prepareStatement("select password from user where unm=?");
											ps.setString(1,s1);
											ResultSet rs;
											rs=ps.executeQuery();
											rs.next();
											String s3=rs.getString(1);
										//	JOptionPane.showMessageDialog(f,"string:"+s3);
										//	JOptionPane.showMessageDialog(f,"user:"+s1);
												if(s2.compareTo(s3)==0)
												{
												JOptionPane.showMessageDialog(f,"Login Success");
												f.setVisible(false);
												new MainScreen(s1);
												}
											else
												JOptionPane.showMessageDialog(f,"Invalid User Name & Password");
											
										}
										if(ae.getSource()==b2)
										{
											JOptionPane.showMessageDialog(f,"Welcome New User");
											f.setVisible(false);
											new Sigh_up();
										}
									}
									catch(Exception e)
									{
									e.printStackTrace();
									}
							}
							
	
	
				public static void main(String[] args)
				{
					new MyFrame();
				}
}