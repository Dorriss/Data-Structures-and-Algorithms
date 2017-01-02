package MyOwnAutomata;

import java.util.Map;

public class State {
	private int stateid;
	private boolean isStart;
	private boolean isend;
	private boolean notification;
	Map<Character,State> transition;
	

	public Map<Character, State> getTransition() {
		return transition;
	}

	public void setTransition(Map<Character, State> transition) {
		this.transition = transition;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isIsend() {
		return isend;
	}

	public void setIsend(boolean isend) {
		this.isend = isend;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	State(boolean isStart, boolean isEnd, int stateid,Map<Character,State> transition) {
		this.setStart(isStart);
		this.setIsend(isEnd);
		this.setStateid(stateid);
		this.setTransition(transition);
		
		

	}

	
	
	

}
