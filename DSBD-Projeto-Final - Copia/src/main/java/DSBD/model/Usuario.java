package DSBD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int pk_username;
	private String username;
	private String password;
	
	
	public Usuario(int pk_username, String username, String password) {
		this.pk_username = pk_username;
		this.username = username;
		this.password = password;
	}
	
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Usuario() {
	
	}

	public int getPk_username() {
		return pk_username;
	}

	public void setPk_username(int pk_username) {
		this.pk_username = pk_username;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
