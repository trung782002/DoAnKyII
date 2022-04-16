package bkap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Configs")
public class Configs {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "LogoImage")
	private String logoImage;
	
	@Column(name = "BannerImage")
	private String bannerImage;	
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Map")
	private String map;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "UpdatedAt")
	private Date updatedAt;
	
	public Configs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Configs(Integer id, String logoImage, String bannerImage, String address, String map, String email,
			String phone, Date updatedAt) {
		super();
		this.id = id;
		this.logoImage = logoImage;
		this.bannerImage = bannerImage;
		this.address = address;
		this.map = map;
		this.email = email;
		this.phone = phone;
		this.updatedAt = updatedAt;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
