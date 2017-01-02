package MyOwnAutomata;

import java.util.ArrayList;
import java.util.Iterator;

public class FSA {

	State currentState;

	FSA() {
		this.statelist = new ArrayList<State>();
	}

	ArrayList<State> statelist;

	public ArrayList<State> getStatelist() {
		return statelist;
	}

	public void setStatelist(ArrayList<State> statelist) {
		this.statelist = statelist;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void AddState(State state) {
		this.statelist.add(state);
		if (state.isStart() == true)
			currentState = state;
	}

	public void setCurrentState(State c) {
		this.currentState = c;
	}

	public void setnotification(boolean notification) {
		for (Iterator iterator = statelist.iterator(); iterator.hasNext();) {
			State state = (State) iterator.next();
			state.setNotification(notification);

		}
	}

	public boolean Parse(String expression) {

		boolean result = false;
		int len = expression.length() - 1;
		int i = 0;
		while (len >= 0) {

			/*
			 * if ((this.currentState.isIsend() && len != i) ||
			 * (!this.currentState.isIsend() && len > i)) return false; if
			 * (this.currentState.isIsend() && len == i) { return true; }
			 */

			char a = expression.charAt(len - i - 1);
			if (this.currentState.transition.containsKey(a)) {
				this.currentState = this.currentState.transition.get(a);
				i++;
			} else {
				if (i == len && this.currentState.isIsend())
					return true;
				else
					return false;
			}

		}

		return result;

	}
}
