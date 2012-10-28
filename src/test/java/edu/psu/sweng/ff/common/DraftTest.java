package edu.psu.sweng.ff.common;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class DraftTest {

	@Test
	public void testManualSetting() {
		
		League l = new League();
		l.setAutoDraft(false);
		
		assertFalse(l.isAutoDraft());
		
	}
	
	@Test
	public void testRoundType() {

		League l = new League();
		Team t1 = new Team();
		Team t2 = new Team();
		l.setAutoDraft(true);
		l.getTeams().add(t1);
		l.getTeams().add(t2);

		Draft d = new Draft();
		d.setLeague(l);
		try {
			d.start();
		} catch (DraftException e) {
			e.printStackTrace();
		}
		
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(2);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(3);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(4);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(5);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(6);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(7);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(8);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(9);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		d.setRound(10);
		assertTrue(d.isStarterRound());
		assertFalse(d.isBenchRound());
		
		d.setRound(11);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(12);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(13);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(14);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(15);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(16);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(17);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(18);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(19);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		d.setRound(20);
		assertTrue(d.isBenchRound());
		assertFalse(d.isStarterRound());
		
	}
	
	@Test
	public void testAutoDraft() {
		
		League l = new League();
		Team t1 = new Team();
		t1.getRosters().add(new Roster()); // need a week 1 roster
		Team t2 = new Team();
		t2.getRosters().add(new Roster()); // need a week 1 roster
		l.setAutoDraft(true);
		l.getTeams().add(t1);
		l.getTeams().add(t2);
		
		Draft d = new Draft();
		d.setLeague(l);
		d.setPlayerSource(new TestPlayerSource());
		try {
			d.start();
		} catch (DraftException e) {
			e.printStackTrace();
		}
		
		assertEquals("round after completion should be 21", 21, d.getRound());
		
		Roster r1 = t1.getRoster(1);
		List<Player> sp1 = r1.getStartingPlayers();
		List<Player> bp1 = r1.getBenchPlayers();
		assertEquals("team 1 starting roster should be 10 players", 10, sp1.size());
		assertEquals("team 1 bench roster should be 10 players", 10, bp1.size());

		Roster r2 = t1.getRoster(1);
		List<Player> sp2 = r2.getStartingPlayers();
		List<Player> bp2 = r2.getBenchPlayers();
		assertEquals("team 2 starting roster should be 10 players", 10, sp2.size());
		assertEquals("team 2 bench roster should be 10 players", 10, bp2.size());		
		
	}
	
	@Test
	public void testManualPlayerDraft() {
		
		League l = new League();
		Team t1 = new Team();
		t1.getRosters().add(new Roster()); // need a week 1 roster
		Team t2 = new Team();
		t2.getRosters().add(new Roster()); // need a week 1 roster
		l.setAutoDraft(false);
		l.getTeams().add(t1);
		l.getTeams().add(t2);
		
		Draft d = new Draft();
		d.setLeague(l);
		d.setPlayerSource(new TestPlayerSource());
		
		try {
			d.start();
		} catch (DraftException e) {
			e.printStackTrace();
		}
		
		Member m = d.getWaitingFor();
		
		List<Player> players = d.getAvailablePlayers();
		assertTrue("There should be more than 0 available players", players.size() > 0);
		
		Team t = l.getTeam(m);
		Roster r = t.getRoster(1);
		
		Player p = players.get(0);
		if (d.isStarterRound()) {
			r.addStartingPlayer(p);
		} else {
			r.addBenchPlayer(p);
		}
		
		// player should no longer be available
		List<Player> players2 = d.getAvailablePlayers();
		assertFalse(players2.contains(p));
		
		// player should be on team
		assertTrue(t.hasPlayer(p));
		
	}

	@Test
	public void testPlayerRestriction() {
		
		League l = new League();
		Team t1 = new Team();
		Team t2 = new Team();
		l.setAutoDraft(false);
		l.getTeams().add(t1);
		l.getTeams().add(t2);
		
		Draft d = new Draft();
		d.setLeague(l);
		d.setPlayerSource(new TestPlayerSource());

		try {
			d.start();
		} catch (DraftException e) {
			e.printStackTrace();
		}

		do {
		
			List<Player> players = d.getAvailablePlayers();
			Iterator<Player> it = players.iterator();
			assertTrue(players.size() >= 40); // there must be at least 40 players (2 teams * 20 players)
			while (it.hasNext()) {
				Player p = it.next();
				if (d.getRound() == 1 || d.getRound() == 11) {
					// all must be QB for rounds 1 and 11
					assertTrue(p.getPosition().equals("QB"));
				} else if (d.getRound() == 2 || d.getRound() == 3 || d.getRound() == 12 || d.getRound() == 13) {
					// all must be RB for rounds 2, 3, 12, and 13
					assertTrue(p.getPosition().equals("RB"));
				} else if (d.getRound() == 4 || d.getRound() == 5 || d.getRound() == 14 || d.getRound() == 15) {
					// all must be WR for rounds 4, 5, 14, and 15
					assertTrue(p.getPosition().equals("WR"));
				} else if (d.getRound() == 6 || d.getRound() == 16) {
					// all must be TE for rounds 6 and 16
					assertTrue(p.getPosition().equals("TE"));
				} else if (d.getRound() == 7 || d.getRound() == 8 || d.getRound() == 17 || d.getRound() == 18) {
					// all must be RB, WR, or TE for rounds 7, 8, 17 and 18
					assertTrue(p.getPosition().equals("RB") || p.getPosition().equals("WR") || p.getPosition().equals("TE"));
				} else if (d.getRound() == 9 || d.getRound() == 19) {
					// all must be DE for rounds 9 and 19
					assertTrue(p.getPosition().equals("DE"));
				} else if (d.getRound() == 10 || d.getRound() == 20) {
					// all must be K for rounds 10 and 20
					assertTrue(p.getPosition().equals("K"));
				}
			}
		
		} while (d.nextRound());
		
	}

	
}
