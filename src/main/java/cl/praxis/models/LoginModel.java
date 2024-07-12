package cl.praxis.models;

import java.io.Serializable;

public class LoginModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name = "";
	private String email = "";
	private String nick = "";
	private String password = "";
	private String adress = "";
	private Integer weight = 0;
	private String rol = "";
	
	public LoginModel() {
		super();
	}
	
	public LoginModel(String name, String email, String nick, String password, String adress, Integer weight,
			String rol) {
		super();
		this.name = name;
		this.email = email;
		this.nick = nick;
		this.password = password;
		this.adress = adress;
		this.weight = weight;
		this.rol = rol;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "LoginModel [name=" + name + ", email=" + email + ", nick=" + nick + ", password=" + password
				+ ", adress=" + adress + ", weight=" + weight + ", rol=" + rol + "]";
	}

	
}
