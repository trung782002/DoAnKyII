package bkap.entities.dto;

import java.util.Date;

public class ReviewsDTO {
	
	private Integer id;
	
	private Integer accId;
	
	private Integer proId;
	
	private Integer productQuality;
	
	private Integer contentRated;
	
	private boolean status;
	
	private Date createdAt;
	
	public ReviewsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewsDTO(Integer id, Integer accId, Integer proId, Integer productQuality, Integer contentRated,
			boolean status, Date createdAt) {
		super();
		this.id = id;
		this.accId = accId;
		this.proId = proId;
		this.productQuality = productQuality;
		this.contentRated = contentRated;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Integer getProductQuality() {
		return productQuality;
	}

	public void setProductQuality(Integer productQuality) {
		this.productQuality = productQuality;
	}

	public Integer getContentRated() {
		return contentRated;
	}

	public void setContentRated(Integer contentRated) {
		this.contentRated = contentRated;
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
