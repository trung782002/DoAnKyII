package bkap.entities.dto;

import java.util.Date;

public class ConfigsDTO {
	
	private Integer id;

	private String logoImage;

	private String bannerImage;	

	private String address;

	private String map;

	private String email;

	private String phone;

	private Date createdAt;
	
	public ConfigsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ConfigsDTO(Integer id, String logoImage, String bannerImage, String address, String map, String email,
			String phone, Date createdAt) {
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
