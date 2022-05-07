package bkap.entities;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Products")
public class Products {
	@Id
	@Column(name = "ProId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer proId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "ImageUrl")
	private String imageUrl;
	
	@Column(name = "Price")
	private Double price;
	
	@Column(name = "Discount")
	private Double discount;
	
	@Column(name = "ShortDescription")
	private String shortDescription;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Quanity")
	private Integer quanity;
	
	@Column(name = "Status")
	private boolean status;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "CateId",referencedColumnName = "CateId")
	private Categories objCategoryOfProduct;
	
	@ManyToOne
	@JoinColumn(name = "BrandId",referencedColumnName = "BrandId")
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

	public Products(Integer proId, String name, String imageUrl, Double price, Double discount, String shortDescription,
			String description, Integer quanity, boolean status, Date createdAt, Categories objCategoryOfProduct,
			Brands objBrandOfProduct, Set<Product_images> listProductImages, Set<Reviews> listReviews,
			Set<Carts> listCarts, Set<OrderDetails> listOrderDetails) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
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
