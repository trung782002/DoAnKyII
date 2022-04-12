package bkap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Configs")
public class Configs {
	@Column(name = "LogoImage")
	@NotEmpty(message = "LogoImage is not null !!")
	private String LogoImage;
	@Column(name = "BannerImage")
	@NotEmpty(message = "BannerImage is not null !!")
	private String bannerImage;	
	@Column(name = "Address")
	@NotEmpty(message = "Address is not null !!")
	private String address;
	@Column(name = "Map")
	@NotEmpty(message = "Map is not null !!")
	private String map;
	@Column(name = "Email")
	@NotEmpty(message = "Email is not null !!")
	private String email;	
	@Column(name = "Phone")
	@NotEmpty(message = "Phone is not null !!")
	private String phone;
	@Column(name = "CreatedAt")
	private Date createdAt;
	public Configs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Configs(String logoImage, String bannerImage, String address, String map, String email, String phone,
			Date createdAt) {
		super();
		LogoImage = logoImage;
		this.bannerImage = bannerImage;
		this.address = address;
		this.map = map;
		this.email = email;
		this.phone = phone;
		this.createdAt = createdAt;
	}
	public String getLogoImage() {
		return LogoImage;
	}
	public void setLogoImage(String logoImage) {
		LogoImage = logoImage;
	}
	public String getBannerImage() {
		return bannerImage;
	}
	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
