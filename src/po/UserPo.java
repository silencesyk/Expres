package po;

import logic.Client;
import logicservice.ClientService;
import frame.AdminFrame;
import frame.CourierFrame;
import frame.LoginFrame;

public class UserPo {
	private String id,passwd,identity;
	
	public UserPo(String id,String passwd,String identity){
		this.id=id;
		this.passwd=passwd;
		this.identity=identity;

	}
	
	public void createWindow(LoginFrame loginFrame){
		if(identity.equals("快递员")){
			CourierFrame courierFrame=new CourierFrame();
			loginFrame.dispose();
		}
		else if(identity.equals("营业厅业务员")){
			
		}
		else if(identity.equals("中转中心业务员")){
			
		}
		else if(identity.equals("中转中心仓库管理人员")){
			
		}
		else if(identity.equals("财务人员")){
			
		}
		else if(identity.equals("总经理")){
			
		}
		else if(identity.equals("管理员")){
			AdminFrame adminFrame=new AdminFrame();
			loginFrame.dispose();
		}
	}
}
