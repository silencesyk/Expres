package logic;

import java.math.BigDecimal;

public class GoodsInfo {
	private String type;
	private String from;
	private String to;
	private final int inCity=30;
	private double weight;
	private int volume;
	private double wrap;
	private final double distance[][]={{30,1064.7,1888.8,900},{1064.7,30,1213,266},{1888.8,1213,30,1132},{900,266,1132,30}};
	public GoodsInfo(){
		
	}
	public void setFrom(String from){
		this.from=from;
	}
	public void setTo(String to ){
		this.to =to;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	public void setVolume(int volume){
		this.volume=volume;
	}
	public void setWrap(double wrap){
		this.wrap=wrap;
	}
	public void setType(String type){
		this.type=type;
	}
	
	public String calculate(){
		double price=0;
		double weight=this.weight;
		if(volume*1.0/5000>this.weight)
			weight=volume*1.0/5000;
		int from=-1;
		switch(this.from){
			case"北京":from=0;break;
			case"上海":from=1;break;
			case"广州":from=2;break;
			case"南京":from=3;break;
		}
		int to=-1;
		switch(this.to){
		case"北京":to=0;break;
		case"上海":to=1;break;
		case"广州":to=2;break;
		case"南京":to=3;break;
	}
		double distance=this.distance[from][to];
		switch(this.type){
		case"经济快递":
			price=weight*distance*1.0/1000*18;
			break;
		case"标准快递":
			price=weight*distance*1.0/1000*23;
			break;
		case"特快专递":
			price=weight*distance*1.0/1000*25;
			break;
	}
		BigDecimal   b   =   new   BigDecimal(price+wrap);  
		double   price1  =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		return ""+price1;
	}
	
	
	
}
