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
	@JoinColumn(name = "ProId",referencedColumnName = "ProId")
	private Products objProductOfImage;
	
	public Product_images() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_images(Integer id, String imageUrl, Products objProductOfImage) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.objProductOfImage = objProductOfImage;
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

	public Products getObjProductOfImage() {
		return objProductOfImage;
	}

	public void setObjProductOfImage(Products objProductOfImage) {
		this.objProductOfImage = objProductOfImage;
	}
	
	
}
