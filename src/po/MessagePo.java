package po;

public class MessagePo {
	
	
	    private String message;
	    
	    public MessagePo(){
	    	
	    }
	    
		public MessagePo(String msg){
			this.message=msg;
		}
		
		
		
		public String setLoginMessage(String uname,String password,String identity){
			message="login"+" "+uname+" "+password+" "+identity;
			return message;
		}
		
		public String setInquireMessage(String id){
			message="inquire "+id;
			return message;
		}

		public String setSend(String msg) {
			message="send "+msg;
			return message;
		}

		public String setCreate(String msg) {
			message="create "+msg;
			return message;
		}

		public String setChangePassword(String string) {
			message="change "+string;
			return message;
		}

		public String setGet(String string) {
			message="get "+string;
			return message;
		}
}
