package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.List;

public class Draft {

	private boolean automatic;

	private int round;
	
	private Member waitingFor;
	
	/**
	 * @return the automatic
	 */
	public boolean isAutomatic() {
		return automatic;
	}

	/**
	 * @param automatic the automatic to set
	 */
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}
	
	public void start() {
		//TODO: more
		this.round = 1;
	}

	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * @param round the round to set
	 */
	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * @return the waitingFor
	 */
	public Member getWaitingFor() {
		return waitingFor;
	}

	/**
	 * @param waitingFor the waitingFor to set
	 */
	public void setWaitingFor(Member waitingFor) {
		this.waitingFor = waitingFor;
	}
	
	/**
	 * Should return a list of the players that are available
	 * in the current round of the draft.
	 * 
	 * @return
	 */
	public List<Player> getAvailablePlayers() {
		return new ArrayList<Player>();
	}
	
	/**
	 * Should return true if this round is for picking bench players
	 * 
	 * @return
	 */
	public boolean isBenchRound() {
		return (round > 10);
	}
	
	/**
	 * Should return true if this round is for picking starting players
	 * 
	 * @return
	 */
	public boolean isStarterRound() {
		return (round < 11);
	}
	
	public void nextRound() {
		this.round++;
	}
}
