package frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import po.MessagePo;
import logic.Client;
import logic.GoodsInfo;
import logicservice.ClientService;

public class CourierFrame extends JFrame{
	
	private JPanel sendPanel,getExPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton radioButton;
	JRadioButton radioButton_1;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2 ;
	JRadioButton rdbtnNewRadioButton_3 ;
	JRadioButton rdbtnNewRadioButton_4 ;
	JLabel lblNewLabel_18;
	JComboBox comboBox_1 ;
	JComboBox comboBox_2;
	JComboBox comboBox;
	JButton btnNewButton;
	String type;
	String wrapType;
	JTextField getDate1Field;
	JTextField getDate3Field;
	JTextField geterField;
	JTextField getIdField;
	
	public CourierFrame(){
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int widthOfScreen = (int)screensize.getWidth();
		int heightOfScreen = (int)screensize.getHeight();
		int width=600;
		int height=400;
		
		setTitle("快递员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((widthOfScreen-width)/2, (heightOfScreen-height)/2, width, height);
		sendPanel = new JPanel();
		getExPanel=new JPanel();
		sendPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getExPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(sendPanel);
		sendPanel.setLayout(null);
		getExPanel.setLayout(null);
		
		JButton sendButton=new JButton("寄件信息");
		sendButton.setBounds(0, 0, 150, 30);
		getExPanel.add(sendButton);
		
		JLabel sendLabel=new JLabel("寄件信息",JLabel.CENTER);
		sendLabel.setBounds(0, 0, 150, 30);
		sendPanel.add(sendLabel);
		
		JButton getButton =new JButton("收件信息");
		getButton.setBounds(0, 30, 150, 30);
		sendPanel.add(getButton);
		
		JLabel getLabel=new JLabel("收件信息",JLabel.CENTER);
		getLabel.setBounds(0, 30, 150, 30);
		getExPanel.add(getLabel);
		
		JLabel label = new JLabel("寄件人信息");
		label.setBounds(10, 70, 75, 15);
		sendPanel.add(label);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(20, 95, 54, 15);
		sendPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 92, 66, 21);
		sendPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("地址");
		lblNewLabel_1.setBounds(20, 131, 54, 15);
		sendPanel.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(100, 128, 66, 21);
		comboBox.addItem("北京");
		comboBox.addItem("上海");
		comboBox.addItem("广州");
		comboBox.addItem("南京");
		sendPanel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 165, 146, 21);
		sendPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("联系方式");
		lblNewLabel_2.setBounds(20, 215, 54, 15);
		sendPanel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 212, 66, 21);
		sendPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("收件人信息");
		lblNewLabel_3.setBounds(192, 8, 75, 15);
		sendPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("姓名");
		lblNewLabel_4.setBounds(202, 30, 54, 15);
		sendPanel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(292, 27, 66, 21);
		sendPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("地址");
		lblNewLabel_5.setBounds(202, 70, 54, 15);
		sendPanel.add(lblNewLabel_5);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(292, 67, 66, 21);
		comboBox_1.addItem("北京");
		comboBox_1.addItem("上海");
		comboBox_1.addItem("广州");
		comboBox_1.addItem("南京");
		sendPanel.add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(202, 109, 156, 21);
		sendPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("联系方式");
		lblNewLabel_6.setBounds(202, 155, 54, 15);
		sendPanel.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(292, 152, 66, 21);
		sendPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("货物信息");
		lblNewLabel_7.setBounds(192, 180, 54, 15);
		sendPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("原件数");
		lblNewLabel_8.setBounds(202, 194, 54, 15);
		sendPanel.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(292, 194, 66, 21);
		sendPanel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("实际重量(kg)");
		lblNewLabel_9.setBounds(202, 228, 80, 15);
		sendPanel.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(292, 225, 66, 21);
		sendPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("内件品名");
		lblNewLabel_11.setBounds(202, 336, 54, 15);
		sendPanel.add(lblNewLabel_11);
		
		textField_9 = new JTextField();
		textField_9.setBounds(292, 333, 66, 21);
		sendPanel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("长(cm)");
		lblNewLabel_10.setBounds(202, 258, 54, 15);
		sendPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("宽(cm)");
		lblNewLabel_12.setBounds(202, 285, 54, 15);
		sendPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("高(cm)");
		lblNewLabel_13.setBounds(202, 310, 54, 15);
		sendPanel.add(lblNewLabel_13);
		
		textField_8 = new JTextField();
		textField_8.setBounds(292, 255, 66, 21);
		sendPanel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(292, 282, 66, 21);
		sendPanel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(292, 307, 66, 21);
		sendPanel.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("快递类型");
		lblNewLabel_14.setBounds(10, 244, 54, 15);
		sendPanel.add(lblNewLabel_14);
		
		
		
		
		rdbtnNewRadioButton = new JRadioButton("经济快递");
		rdbtnNewRadioButton.setBounds(20, 265, 80, 23);
		sendPanel.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("标准快递",true);
		radioButton.setBounds(20, 291, 80, 23);
		sendPanel.add(radioButton);
		
		radioButton_1 = new JRadioButton("特快专递");
		radioButton_1.setBounds(20, 317, 80, 23);
		sendPanel.add(radioButton_1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_15 = new JLabel("包装费");
		lblNewLabel_15.setBounds(387, 8, 54, 15);
		sendPanel.add(lblNewLabel_15);
		
		rdbtnNewRadioButton_1 = new JRadioButton("纸箱(5元)",true);
		rdbtnNewRadioButton_1.setBounds(397, 34, 121, 23);
		sendPanel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("木箱(10元)");
		rdbtnNewRadioButton_2.setBounds(397, 59, 121, 23);
		sendPanel.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("快递袋(1元)");
		rdbtnNewRadioButton_3.setBounds(397, 84, 121, 23);
		sendPanel.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("其他");
		rdbtnNewRadioButton_4.setBounds(397, 108, 55, 23);
		sendPanel.add(rdbtnNewRadioButton_4);
		
		ButtonGroup wrapButtonGroup=new ButtonGroup();
		wrapButtonGroup.add(rdbtnNewRadioButton_1);
		wrapButtonGroup.add(rdbtnNewRadioButton_2);
		wrapButtonGroup.add(rdbtnNewRadioButton_3);
		wrapButtonGroup.add(rdbtnNewRadioButton_4);
		
		textField_12 = new JTextField();
		textField_12.setBounds(452, 109, 66, 21);
		sendPanel.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("条形码");
		lblNewLabel_16.setBounds(387, 155, 54, 15);
		sendPanel.add(lblNewLabel_16);
		
		textField_13 = new JTextField();
		textField_13.setBounds(397, 177, 121, 21);
		sendPanel.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("费用合计");
		lblNewLabel_17.setBounds(387, 228, 54, 15);
		sendPanel.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel();//费用显示
		lblNewLabel_18.setBounds(397, 258, 54, 15);
		sendPanel.add(lblNewLabel_18);
		
		btnNewButton = new JButton("计算费用");
		btnNewButton.setBounds(387, 306, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GoodsInfo gi=new GoodsInfo();
				
				if(rdbtnNewRadioButton.isSelected())
					type="经济快递";
				if(radioButton.isSelected())
					type="标准快递";
				if(radioButton_1.isSelected())
					type="特快专递";
				gi.setType(type);
				gi.setFrom(comboBox.getSelectedItem().toString());
				gi.setTo(comboBox_1.getSelectedItem().toString());
				try{
					gi.setWeight(Double.parseDouble(textField_7.getText()));
					gi.setVolume(Integer.parseInt(textField_8.getText())*Integer.parseInt(textField_10.getText())*Integer.parseInt(textField_11.getText()));
					double wrap=0;
					if(rdbtnNewRadioButton_1.isSelected()){
						wrap=5;
						wrapType="纸箱";
					}
					if(rdbtnNewRadioButton_2.isSelected()){
						wrapType="木箱";
						wrap=10;
					}
						
					if(rdbtnNewRadioButton_3.isSelected()){
						wrapType="快递袋";
						wrap=1;
					}
					
					if(rdbtnNewRadioButton_4.isSelected()){
						wrapType="其他";
						wrap=Double.parseDouble(textField_12.getText().toString());
					}
					
					gi.setWrap(wrap);
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null,"有信息未填","错误",JOptionPane.ERROR_MESSAGE);
				}
					lblNewLabel_18.setText(gi.calculate());
					setVisible(true);
			}
		});
		sendPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("完成寄件");
		btnNewButton_1.setBounds(481, 306, 93, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton.doClick();
				String msg="";
				
	

				try{				
					String vol=""+Integer.parseInt(textField_8.getText())*Integer.parseInt(textField_10.getText())*Integer.parseInt(textField_11.getText());
					msg+=textField.getText()+" "+comboBox.getSelectedItem().toString()+" "+textField_1.getText()+" "
							+textField_2.getText()+" "+type+" "+textField_3.getText()+" "+comboBox_1.getSelectedItem().toString()+" "
							+textField_4.getText()+" "+textField_5.getText()+" "+textField_6.getText()+" "+textField_7.getText()+" "+vol+" "+textField_9.getText()+" "
							+wrapType+" "+textField_13.getText()+" "+lblNewLabel_18.getText();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"有信息未填","错误",JOptionPane.ERROR_MESSAGE);
				}
				String str[]=msg.split(" ");
				if(str.length<16)
					JOptionPane.showMessageDialog(null,"有信息未填","错误",JOptionPane.ERROR_MESSAGE);
				else{
					MessagePo mp=new MessagePo();
					ClientService client=new Client();
					try {
						client.init();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					client.sendMessage(mp.setSend(msg));
					JOptionPane.showMessageDialog(null,client.getMessage(),"提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		sendPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_19 = new JLabel("元");
		lblNewLabel_19.setBounds(520, 112, 54, 15);
		sendPanel.add(lblNewLabel_19);

		
		
		JLabel geter=new JLabel("收件人");
		geter.setBounds(200, 50, 100, 30);
		geterField=new JTextField();
		geterField.setBounds(300,50,100,30);
		
		JLabel getId=new JLabel("收件编号");
		getId.setBounds(200, 110, 100, 30);
		getIdField=new JTextField();
		getIdField.setBounds(300,110,100,30);
		
		JLabel getDate1=new JLabel("收件时间");
		getDate1.setBounds(200, 170, 100, 30);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		getDate1Field=new JTextField(df.format(new java.util.Date()));
		getDate1Field.setBounds(300,170,200,30);
		JLabel getDate2=new JLabel("收件地点");
		getDate2.setBounds(200, 230, 100, 30);
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(300, 230 ,100, 30);
		comboBox_2.addItem("北京");
		comboBox_2.addItem("上海");
		comboBox_2.addItem("广州");
		comboBox_2.addItem("南京");
		getExPanel.add(comboBox_2);
		getDate3Field=new JTextField();
		getDate3Field.setBounds(200,290,200,30);
		
		JButton getConfirm=new JButton("完成收件");
		getConfirm.setBounds(450, 290, 100, 30);
		getConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//完成收件
				String geter=geterField.getText();
				String getId=getIdField.getText();
				String getTime=getDate1Field.getText();
				String getPlace=comboBox_2.getSelectedItem().toString()+getDate3Field.getText();
				MessagePo mp=new MessagePo();
				ClientService client=new Client();
				try {
					client.init();
				} catch ( IOException e1) {
					e1.printStackTrace();
				}
				client.sendMessage(mp.setGet(geter+" "+getId+" "+getTime+" "+getPlace));
				JOptionPane.showMessageDialog(null,client.getMessage(),"提示",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		getExPanel.add(geter);
		getExPanel.add(geterField);
		getExPanel.add(getId);
		getExPanel.add(getIdField);
		getExPanel.add(getDate1);
		getExPanel.add(getDate2);
		getExPanel.add(getDate1Field);
		getExPanel.add(getDate3Field);
		getExPanel.add(getConfirm);
		
		
		getButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 打开收件信息
				sendPanel.setVisible(false);
				setContentPane(getExPanel);
				getExPanel.setVisible(true);
			}
		});
		
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 打开寄件信息
				getExPanel.setVisible(false);
				setContentPane(sendPanel);
				sendPanel.setVisible(true);
			}
		});
		
		setVisible(true);
	}
}
