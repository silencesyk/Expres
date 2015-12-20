package frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Client;
import logicservice.ClientService;
import po.MessagePo;
import po.UserPo;

public class AdminFrame extends JFrame{
	
	private JPanel createPanel;
	private JPanel changePanel;
	private JTextField idField,oldField;
	private JPasswordField passwordField,newField,new2Field;
	private JPasswordField password2Field;
	private final JComboBox box ;
	
	public AdminFrame(){
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int widthOfScreen = (int)screensize.getWidth();
		int heightOfScreen = (int)screensize.getHeight();
		int width=600;
		int height=400;
		
		setTitle("管理员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((widthOfScreen-width)/2, (heightOfScreen-height)/2, width, height);
		createPanel = new JPanel();
		createPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(createPanel);
		createPanel.setLayout(null);
		
		JLabel idLabel=new JLabel("用户名");
		idLabel.setBounds(162, 42, 96, 26);
		createPanel.add(idLabel);
		
		idField=new JTextField();
		idField.setBounds(258, 45, 174, 21);
		createPanel.add(idField);
		
		JLabel passwordLabel=new JLabel("密码");
		passwordLabel.setBounds(162, 92, 96, 26);
		createPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 98, 174, 21);
		createPanel.add(passwordField);
		
		JLabel password2Label=new JLabel("确认密码");
		password2Label.setBounds(162, 142, 96, 26);
		createPanel.add(password2Label);
		
		password2Field = new JPasswordField();
		password2Field.setBounds(258, 147, 174, 21);
		createPanel.add(password2Field);
		
		JLabel identityLabel=new JLabel("身份");
		identityLabel.setBounds(162, 192, 96, 26);
		createPanel.add(identityLabel);
		
		box = new JComboBox();
		box.addItem("快递员");
		box.addItem("营业厅业务员");
		box.addItem("中转中心业务员");
		box.addItem("中转中心仓库管理人员");
		box.addItem("财务人员");
		box.addItem("总经理");
		box.setBounds(258,197, 174, 21);
		createPanel.add(box);
		
		changePanel = new JPanel();
		changePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		changePanel.setLayout(null);
		
		JLabel oldLabel=new JLabel("原密码");
		oldLabel.setBounds(162, 42, 96, 26);
		changePanel.add(oldLabel);
		
		oldField=new JTextField();
		oldField.setBounds(258, 45, 174, 21);
		changePanel.add(oldField);
		
		JLabel newLabel=new JLabel("新密码");
		newLabel.setBounds(162, 92, 96, 26);
		changePanel.add(newLabel);
		
		newField = new JPasswordField();
		newField.setBounds(258, 98, 174, 21);
		changePanel.add(newField);
		
		JLabel new2Label=new JLabel("确认密码");
		new2Label.setBounds(162, 142, 96, 26);
		changePanel.add(new2Label);
		
		new2Field = new JPasswordField();
		new2Field.setBounds(258, 147, 174, 21);
		changePanel.add(new2Field);
		
		JLabel now1=new JLabel("创建新用户",JLabel.CENTER);
		now1.setBounds(0, 0, 150, 30);
		createPanel.add(now1);
		
		JLabel now2=new JLabel("修改密码",JLabel.CENTER);
		now2.setBounds(0, 30, 150, 30);
		changePanel.add(now2);
		
		JButton confirm2=new JButton("确认更改");
		confirm2.setBounds(350, 275, 150, 30);
		changePanel.add(confirm2);
		confirm2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 更改
				String id="admin";
				String password=oldField.getText();
				String newPassword=newField.getText();
				String newPassword2=new2Field.getText();
				if(newPassword.equals(newPassword2)){
					ClientService client=new Client();
					MessagePo mp=new MessagePo();
					try {
						client.init();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					client.sendMessage(mp.setChangePassword(id+" "+password+" "+newPassword));
					JOptionPane.showMessageDialog(null,client.getMessage(),"提示",JOptionPane.INFORMATION_MESSAGE);
				}
				else 
					JOptionPane.showMessageDialog(null,"2次密码出入不同","错误",JOptionPane.ERROR_MESSAGE);
					
			}
		});
		
		JButton createUser=new JButton("创建新用户");
		createUser.setBounds(0, 0, 150, 30);
		createPanel.add(createUser);
		createUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 新建账户
				changePanel.setVisible(false);
				setContentPane(createPanel);
				createPanel.setVisible(true);
			}
		});
		
		JButton confirm=new JButton("确认创建");
		confirm.setBounds(350, 275, 150, 30);
		createPanel.add(confirm);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 确定创建
				String id=idField.getText();
				String password =passwordField.getText();
				String password2=password2Field.getText();
				String identity=box.getSelectedItem().toString();
				if(password.equals(password2)){
					ClientService client=new Client();
					MessagePo mp=new MessagePo();
					try {
						client.init();
					} catch ( IOException e1) {
						e1.printStackTrace();
					}
					client.sendMessage(mp.setCreate(id+" "+password+" "+identity));
					JOptionPane.showMessageDialog(null,client.getMessage(),"提示",JOptionPane.INFORMATION_MESSAGE);
				}
				else 
					JOptionPane.showMessageDialog(null,"2次密码出入不同","错误",JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
		JButton changePassword=new JButton("修改密码");
		changePassword.setBounds(0,30, 150, 30);
		createPanel.add(changePassword);
		changePanel.add(createUser);
		changePanel.add(confirm2);
		changePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//修改管理员密码
				createPanel.setVisible(false);
				setContentPane(changePanel);
				changePanel.setVisible(true);
			}
		});
		setVisible(true);
	}
}
