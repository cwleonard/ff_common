package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {

	private int leagueId;
	
	private Map<Integer, List<Matchup>> matchups;
	
	public Schedule() {
		
		matchups = new HashMap<Integer, List<Matchup>>();
		
	}
	
	public List<Matchup> getMatchups(int week) {
		List<Matchup> m = matchups.get(week);
		if (m == null) {
			m = new ArrayList<Matchup>();
			matchups.put(week, m);
		}
		return m;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	
	
	
}
