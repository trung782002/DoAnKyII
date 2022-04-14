package bkap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Configs")
public class Configs {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "LogoImage")
	private String LogoImage;
	
	@Column(name = "BannerImage")
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

	public Configs(Integer id, String logoImage, String bannerImage,
			@NotEmpty(message = "Address is not null !!") String address,
			@NotEmpty(message = "Map is not null !!") String map,
			@NotEmpty(message = "Email is not null !!") String email,
			@NotEmpty(message = "Phone is not null !!") String phone, Date createdAt) {
		super();
		this.id = id;
		LogoImage = logoImage;
		this.bannerImage = bannerImage;
		this.address = address;
		this.map = map;
		this.email = email;
		this.phone = phone;
		this.createdAt = createdAt;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
