package bkap.entities;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Products")
public class Products {
	@Id
	@Column(name = "ProId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer proId;
	
	@Column(name = "Name")
	@NotEmpty(message = "Proudct Name is not null !!")
	private String name;
	
	@Column(name = "ImageUrl")
	private String imageUrl;
	
	@Column(name = "Price")
	@NotNull(message = "Proudct Price is not null !!")
	private double price;
	
	@Column(name = "Discount")
	@NotNull(message = "Proudct Price is not null !!")
	private double discount;
	
	@Column(name = "ShortDescription")
	@NotEmpty(message = "Proudct ShortDescription is not null !!")
	private String shortDescription;
	
	@Column(name = "Description")
	@NotEmpty(message = "Proudct Description is not null !!")
	private String description;
	
	@Column(name = "Quanity")
	@NotNull(message = "Proudct Quanity is not null !!")
	private Integer quanity;
	
	@Column(name = "Status")
	private Boolean status;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "CateId",referencedColumnName = "CateId")
	@NotNull(message = "Category Name is not null !!")
	private Categories objCategoryOfProduct;
	
	@ManyToOne
	@JoinColumn(name = "BrandId",referencedColumnName = "BrandId")
	@NotNull(message = "Brand Name is not null !!")
	private Brands objBrandOfProduct;
	
	@OneToMany(mappedBy = "objProductOfImage")
	private Set<Product_images> listProductImages;
	
	@OneToMany(mappedBy = "objProductOfReview")
	private Set<Reviews> listReviews;
	
	@OneToMany(mappedBy = "objProductOfCart")
	private Set<Carts> listCarts;
	
	@OneToMany(mappedBy = "objProductOfOrderDetail")
	private Set<OrderDetails> listOrderDetails;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Integer proId, @NotEmpty(message = "Proudct Name is not null !!") String name, String imageUrl,
			@NotNull(message = "Proudct Price is not null !!") double price,
			@NotNull(message = "Proudct Price is not null !!") double discount,
			@NotEmpty(message = "Proudct ShortDescription is not null !!") String shortDescription,
			@NotEmpty(message = "Proudct Description is not null !!") String description,
			@NotNull(message = "Proudct Quanity is not null !!") Integer quanity, Boolean status, Date createdAt,
			@NotNull(message = "Category Name is not null !!") Categories objCategoryOfProduct,
			@NotNull(message = "Brand Name is not null !!") Brands objBrandOfProduct,
			Set<Product_images> listProductImages, Set<Reviews> listReviews, Set<Carts> listCarts,
			Set<OrderDetails> listOrderDetails) {
		super();
		this.proId = proId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.discount = discount;
		this.shortDescription = shortDescription;
		this.description = description;
		this.quanity = quanity;
		this.status = status;
		this.createdAt = createdAt;
		this.objCategoryOfProduct = objCategoryOfProduct;
		this.objBrandOfProduct = objBrandOfProduct;
		this.listProductImages = listProductImages;
		this.listReviews = listReviews;
		this.listCarts = listCarts;
		this.listOrderDetails = listOrderDetails;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuanity() {
		return quanity;
	}

	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
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

	public Categories getObjCategoryOfProduct() {
		return objCategoryOfProduct;
	}

	public void setObjCategoryOfProduct(Categories objCategoryOfProduct) {
		this.objCategoryOfProduct = objCategoryOfProduct;
	}

	public Brands getObjBrandOfProduct() {
		return objBrandOfProduct;
	}

	public void setObjBrandOfProduct(Brands objBrandOfProduct) {
		this.objBrandOfProduct = objBrandOfProduct;
	}

	public Set<Product_images> getListProductImages() {
		return listProductImages;
	}

	public void setListProductImages(Set<Product_images> listProductImages) {
		this.listProductImages = listProductImages;
	}

	public Set<Reviews> getListReviews() {
		return listReviews;
	}

	public void setListReviews(Set<Reviews> listReviews) {
		this.listReviews = listReviews;
	}

	public Set<Carts> getListCarts() {
		return listCarts;
	}

	public void setListCarts(Set<Carts> listCarts) {
		this.listCarts = listCarts;
	}

	public Set<OrderDetails> getListOrderDetails() {
		return listOrderDetails;
	}

	public void setListOrderDetails(Set<OrderDetails> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}
	
	
}
