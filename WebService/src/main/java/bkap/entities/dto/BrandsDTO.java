package bkap.entities.dto;

import java.util.Date;

public class BrandsDTO {
	
	private Integer brandId;

	private String name;

	private String imageUrl;
	
	private boolean status;
	
	private Date createdAt;
	
	public BrandsDTO() {
		// TODO Auto-generated constructor stub
	}

	public BrandsDTO(Integer brandId, String name, String imageUrl, boolean status, Date createdAt) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
}
