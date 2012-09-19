package edu.psu.sweng.ff.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for Member
 */
public class MemberTest
{
    @Test
    public void testMember() {
    	
    	Member m = new Member();
    	m.setFirstName("firstname");
    	m.setLastName("lastname");
    	m.setPassword("password");
    	
    	System.out.println(m.getPasswordHash());
    	
    	assertEquals("firstname", m.getFirstName());
    	assertEquals("lastname", m.getLastName());
        
    }
    
    
    
}
