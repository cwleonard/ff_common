package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	public Collection<Matchup> getAllMatchups() {
		
		Collection<Matchup> cm = new ArrayList<Matchup>();
		
		Iterator<Integer> ki = matchups.keySet().iterator();
		while (ki.hasNext()) {
			List<Matchup> lm = matchups.get(ki.next());
			cm.addAll(lm);
		}
		
		return cm;
		
	}
	
}
