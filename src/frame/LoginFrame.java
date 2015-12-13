package frame;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.handler.MessageContext;

import logic.Client;
import logicservice.ClientService;
import po.MessagePo;
import po.UserPo;

public class LoginFrame extends JFrame{
	
	private JPanel contentPanel;
	private JTextField idField;
	private JPasswordField passwordField;
	private final JComboBox box ;
	private static LoginFrame loginframe; 
	
	public static void display(){
		loginframe=new LoginFrame();
		loginframe.setVisible(true);
	}
	
	public LoginFrame(){
		
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int widthOfScreen = (int)screensize.getWidth();
		int heightOfScreen = (int)screensize.getHeight();
		int width=450;
		int height=300;
		
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((widthOfScreen-width)/2, (heightOfScreen-height)/2, width, height);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel idLabel=new JLabel("用户名");
		idLabel.setBounds(62, 42, 96, 26);
		contentPanel.add(idLabel);
		
		idField=new JTextField();
		idField.setBounds(158, 45, 174, 21);
		contentPanel.add(idField);
		
		JLabel passwordLabel=new JLabel("密码");
		passwordLabel.setBounds(62, 92, 96, 26);
		contentPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 98, 174, 21);
		contentPanel.add(passwordField);
		
		JLabel identityLabel=new JLabel("身份");
		identityLabel.setBounds(62, 142, 96, 26);
		contentPanel.add(identityLabel);
		
		box = new JComboBox();
		box.addItem("快递员");
		box.addItem("营业厅业务员");
		box.addItem("中转中心业务员");
		box.addItem("中转中心仓库管理人员");
		box.addItem("财务人员");
		box.addItem("总经理");
		box.addItem("管理员");
		box.setBounds(158, 146, 174, 21);
		contentPanel.add(box);
		
		JButton login=new JButton("登录");
		login.setBounds(100, 200, 80, 30);
		contentPanel.add(login);
		
		setVisible(true);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 登录
				String id=idField.getText();
				String passwd=passwordField.getText();
				String identity=box.getSelectedItem().toString();
				//验证密码是否正确
				MessagePo m=new MessagePo();
				ClientService client=new Client();
				try {
					client.init();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				client.sendMessage(m.setLoginMessage(id, passwd, identity));
				//正确则进入对应窗口
				if(client.getMessage().equals("login true")){
					UserPo user=new UserPo(id, passwd, identity);
					user.createWindow(loginframe);
				}else{
					JOptionPane.showMessageDialog(null,"登录信息错误","错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
		JButton inquire=new JButton("寄件人查询");
		inquire.setBounds(250, 200, 150, 30);
		contentPanel.add(inquire);
		inquire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 寄件人查询窗口
				InquireFrame inquireFrame=new InquireFrame();
				loginframe.dispose();
			}
		});
	}
	
	
}
