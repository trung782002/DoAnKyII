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

@Entity
@Table(name = "Reviews")
public class Reviews {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ProductQuality")
	private Integer productQuality;
	
	@Column(name = "ContentRated")
	private Integer contentRated;
	
	@Column(name = "Reply")
	private String reply;
	
	@Column(name = "Status")
	private boolean status;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "AccId", referencedColumnName = "AccId")
	private Accounts objAccountOfReview;
	
	@ManyToOne
	@JoinColumn(name = "ProId", referencedColumnName = "ProId")
	private Products objProductOfReview;

	public Reviews() {
		// TODO Auto-generated constructor stub
	}

	public Reviews(Integer id, Integer productQuality, Integer contentRated, String reply, boolean status,
			Date createdAt, Accounts objAccountOfReview, Products objProductOfReview) {
		super();
		this.id = id;
		this.productQuality = productQuality;
		this.contentRated = contentRated;
		this.reply = reply;
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

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
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
