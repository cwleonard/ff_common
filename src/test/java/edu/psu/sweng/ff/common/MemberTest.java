package edu.psu.sweng.ff.common;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
    	
    	//System.out.println(m.getPasswordHash());
    	
    	assertEquals("firstname", m.getFirstName());
    	assertEquals("lastname", m.getLastName());
        
    }
    
    @Test
    public void testHash() {
    	
    	try {
    		
			String hash1 = Member.getHash("password");
			String hash2 = Member.getHash("password");
			
			assertEquals(hash1, hash2);
			
		} catch (NoSuchAlgorithmException e) {
			fail(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			fail(e.getMessage());
		}
    	
    }
    
    
}
