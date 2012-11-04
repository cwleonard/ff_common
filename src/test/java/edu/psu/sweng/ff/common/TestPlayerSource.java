package edu.psu.sweng.ff.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TestPlayerSource implements PlayerSource, RosterStore {

	private List<Player> allPlayers = new ArrayList<Player>();
	private List<Player> selectedPlayers = new ArrayList<Player>();
	
	private String[] positions = {"QB","RB","WR","TE","DE","K"};

	private Random rand = new Random();
	
	public TestPlayerSource() {
		
		// generate a bunch of random players
		for (int i = 0; i < 500; i++) {
			
			Player p = new Player();
			p.setId(UUID.randomUUID().toString());
			p.setFirstName(i + "First");
			p.setLastName(i + "Last");
			p.setCollege(i + "College");
			p.setHeight(72);
			p.setWeight(220);
			p.setNflTeam(i + "NFLTeam");
			p.setPosition(positions[rand.nextInt(positions.length)]);
			p.setBirthdate(new Date());
			allPlayers.add(p);
			
		}
		
	}
	
	@Override
	public List<Player> getByType(String type) {
		return this.getByType(0, type);
	}

	@Override
	public List<Player> getByType(String... types) {
		return this.getByType(0, types);
	}

	@Override
	public List<Player> getByType(int leagueId, String type) {
		
		List<Player> players = new ArrayList<Player>();
		Iterator<Player> i = allPlayers.iterator();
		while (i.hasNext()) {
			Player p = i.next();
			if (p.getPosition().equals(type) && (!selectedPlayers.contains(p))) {
				players.add(p);
			}
		}
		return players;
		
	}

	@Override
	public List<Player> getByType(int leagueId, String... types) {

		List<Player> players = new ArrayList<Player>();
		Iterator<Player> i = allPlayers.iterator();
		while (i.hasNext()) {
			Player p = i.next();
			for (int j = 0; j < types.length; j++) {
				if (p.getPosition().equals(types[j]) && (!selectedPlayers.contains(p))) {
					players.add(p);
				}
			}
		}
		return players;
	
	}

	@Override
	public void store(Roster r) {
		
		selectedPlayers.addAll(r.getStartingPlayers());
		selectedPlayers.addAll(r.getBenchPlayers());
		
	}

}
