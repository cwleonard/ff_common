package edu.psu.sweng.ff.common;

public class Matchup {

	private int week;
	
	private int teamA;
	
	private int teamB;

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getTeamA() {
		return teamA;
	}

	public void setTeamA(int teamA) {
		this.teamA = teamA;
	}

	public int getTeamB() {
		return teamB;
	}

	public void setTeamB(int teamB) {
		this.teamB = teamB;
	}
	
	public boolean equals(Object o) {
		
		if (o instanceof Matchup) {
			
			Matchup other = (Matchup)o;
			return (this.week == other.week && this.teamA == other.teamA && this.teamB == other.teamB);
			
		} else {
			return false;
		}
		
	}
	
}
