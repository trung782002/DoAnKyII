package bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product_images")
public class Product_images {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ImageUrl")
	private String imageUrl;	
	@ManyToOne
	@JoinColumn(name = "ProId",referencedColumnName = "Id")
	private Products objImage;
	public Product_images() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product_images(Integer id, String imageUrl, Products objImage) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.objImage = objImage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Products getObjImage() {
		return objImage;
	}
	public void setObjImage(Products objImage) {
		this.objImage = objImage;
	}
	
}
