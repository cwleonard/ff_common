package edu.psu.sweng.ff.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class DraftTest {

	@Test
	public void testDraftRounds() {
		
		League l = new League();
		Team t1 = new Team();
		Team t2 = new Team();
		l.setAutoDraft(true);
		l.getTeams().add(t1);
		l.getTeams().add(t2);
		
		Draft d = new Draft();
		d.start();
		
		assertEquals(20, d.getRound());
		
		
	}
	
	@Test
	public void testRound1() {
		
		assertTrue(false);
		
	}
	
	@Test
	public void testRound2() {
		
		assertTrue(false);
		
	}
	
	//TODO: the rest of the tests
	
}
