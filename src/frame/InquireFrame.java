package frame;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import po.MessagePo;
import logic.Client;
import logicservice.ClientService;

import javax.swing.JTable;
import javax.swing.JTextArea;

public class InquireFrame extends JFrame{
	
	private JPanel contentPanel;
	private JTextField expressField;
	private JTextArea textArea;
	
	public InquireFrame(){
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int widthOfScreen = (int)screensize.getWidth();
		int heightOfScreen = (int)screensize.getHeight();
		int width=450;
		int height=300;
		
		setTitle("查询");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((widthOfScreen-width)/2, (heightOfScreen-height)/2, width, height);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel expressId=new JLabel("订单号");
		expressId.setBounds(10, 10, 40, 50);
		contentPanel.add(expressId);
		
		expressField=new JTextField();
		expressField.setBounds(60, 14, 120, 44);
		contentPanel.add(expressField);
		
		JButton inquireButton=new JButton("查询");
		inquireButton.setBounds(243, 20,80 , 30);
		contentPanel.add(inquireButton);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 70, 404, 181);
		contentPanel.add(textArea);
		
		setVisible(true);
		
		inquireButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inquireID=expressField.getText();
				ClientService client=new Client();
				try {
					client.init();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				MessagePo m=new MessagePo();
				client.sendMessage(m.setInquireMessage(inquireID));
			
				textArea.append(client.getMessage().replace("/n", "\r\n"));
			}
		});
	}
}
