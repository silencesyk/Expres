package frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InquireFrame extends JFrame{
	
	private JPanel contentPanel;
	
	
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
		expressId.setBounds(100, 80, 40, 50);
		contentPanel.add(expressId);
		
		JTextField expressField=new JTextField();
		expressField.setBounds(160, 83, 120, 44);
		contentPanel.add(expressField);
		
		JButton inquireButton=new JButton("查询");
		inquireButton.setBounds(250, 200,80 , 30);
		contentPanel.add(inquireButton);
		
		setVisible(true);
	}
	
}
