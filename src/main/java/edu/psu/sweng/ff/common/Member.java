package edu.psu.sweng.ff.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Member 
{
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String mobileNumber;
	private boolean hideEmail;
	private boolean hideName;
	private String passwordHash;
	private List<Invitation> invitations;

	private transient String accessToken;
	private transient String password;

	public Member() {
		invitations = new ArrayList<Invitation>();
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
		try {
			this.setPasswordHash(this.getHash(this.password));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPasswordHash(String ph) {
		this.passwordHash = ph;
	}
	
	public String getPasswordHash() {
		return this.passwordHash;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the hideEmail
	 */
	public boolean isHideEmail() {
		return hideEmail;
	}

	/**
	 * @param hideEmail the hideEmail to set
	 */
	public void setHideEmail(boolean hideEmail) {
		this.hideEmail = hideEmail;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the hideName
	 */
	public boolean isHideName() {
		return hideName;
	}

	/**
	 * @param hideName the hideName to set
	 */
	public void setHideName(boolean hideName) {
		this.hideName = hideName;
	}

	/**
	 * @return the invitations
	 */
	public List<Invitation> getInvitations() {
		return invitations;
	}

	/**
	 * @param invitations the invitations to set
	 */
	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}

	public static String getHash(String s) throws NoSuchAlgorithmException,
	UnsupportedEncodingException {

		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.reset();
		byte[] hashed = digest.digest(s.getBytes("UTF-8"));
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashed.length; ++i) {
			sb.append(Integer.toHexString((hashed[i] & 0xFF) | 0x100)
					.substring(1, 3));
		}
		return sb.toString();

	}
	
	public boolean equals(Object o) {

		if (o instanceof Member) {
			
			Member om = (Member)o;
			return (om.id == this.id);
			
		} else {
			return false;
		}
		
	}
	
}
