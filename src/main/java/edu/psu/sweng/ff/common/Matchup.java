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
	
	public int hashCode() {
		if (teamA < teamB) {
			return (teamA + "_" + teamB).hashCode();
		} else {
			return (teamB + "_" + teamA).hashCode();
		}
	}
	
	public boolean equals(Object o) {
		
		if (o instanceof Matchup) {
			
			Matchup other = (Matchup)o;
			boolean same = ((this.teamA == other.teamB && this.teamB == other.teamA) ||
					(this.teamA == other.teamA && this.teamB == other.teamB));
			return same;
			
		} else {
			return false;
		}
		
	}
	
}
