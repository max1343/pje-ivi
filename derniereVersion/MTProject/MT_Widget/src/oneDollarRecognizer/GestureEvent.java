package oneDollarRecognizer;

import java.util.EventObject;

public class GestureEvent extends EventObject implements GestureEventListener{
	public GestureEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	String templateName;
	double score;
	
	public String getTemplateName(){
		return this.templateName;
	}
	
	public double getScore(){
		return this.score;
	}
}
