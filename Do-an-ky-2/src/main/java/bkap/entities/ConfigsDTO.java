package bkap.entities;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class ConfigsDTO {

	private Integer id;
	
	private String logoImage;
	
	private String bannerImage;	
	
	@NotEmpty(message = "Address is not null !!")
	private String address;
	
	@NotEmpty(message = "Map is not null !!")
	private String map;
	
	@NotEmpty(message = "Email is not null !!")
	private String email;
	
	@NotEmpty(message = "Phone is not null !!")
	private String phone;
	
	private Date createdAt;
	
	public ConfigsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfigsDTO(Integer id, String logoImage, String bannerImage,
			@NotEmpty(message = "Address is not null !!") String address,
			@NotEmpty(message = "Map is not null !!") String map,
			@NotEmpty(message = "Email is not null !!") String email,
			@NotEmpty(message = "Phone is not null !!") String phone, Date createdAt) {
		super();
		this.id = id;
		this.logoImage = logoImage;
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
		return logoImage;
	}

	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
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
