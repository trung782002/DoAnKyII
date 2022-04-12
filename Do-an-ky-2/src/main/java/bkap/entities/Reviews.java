package bkap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Reviews")
public class Reviews {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ProductQuality")
	@NotEmpty(message = "ProductQuality is null")
	private Integer productQuality;
	
	@Column(name = "ContentRated")
	@NotEmpty(message = "ContentRated is null")
	private Integer contentRated;
	
	@Column(name = "Status")
	private Boolean status;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "AccId", referencedColumnName = "AccId")
	private Accounts objAccountOfReview;
	
	@ManyToOne
	@JoinColumn(name = "ProId", referencedColumnName = "ProId")
	private Products objProductOfReview;

	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reviews(Integer id, @NotEmpty(message = "ProductQuality is null") Integer productQuality,
			@NotEmpty(message = "ContentRated is null") Integer contentRated, Boolean status, Date createdAt,
			Accounts objAccountOfReview, Products objProductOfReview) {
		super();
		this.id = id;
		this.productQuality = productQuality;
		this.contentRated = contentRated;
		this.status = status;
		this.createdAt = createdAt;
		this.objAccountOfReview = objAccountOfReview;
		this.objProductOfReview = objProductOfReview;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Accounts getObjAccountOfReview() {
		return objAccountOfReview;
	}

	public void setObjAccountOfReview(Accounts objAccountOfReview) {
		this.objAccountOfReview = objAccountOfReview;
	}

	public Products getObjProductOfReview() {
		return objProductOfReview;
	}

	public void setObjProductOfReview(Products objProductOfReview) {
		this.objProductOfReview = objProductOfReview;
	}

	
}
