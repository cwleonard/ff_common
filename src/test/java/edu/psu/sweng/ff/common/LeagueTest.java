package edu.psu.sweng.ff.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for Member
 */
public class LeagueTest
{
    @Test
    public void testSetCommissioner()
    {
    	League l = new League();
    	
    	Member m = new Member();
    	m.setUserName("tester");
    	
    	l.setCommissioner(m);
    	
    	assertEquals("tester", l.getCommissioner().getUserName());
    	
    }
    
    
    
}
