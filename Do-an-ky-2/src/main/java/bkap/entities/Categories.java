package bkap.entities;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Categories")
public class Categories {
	@Id
	@Column(name = "CateId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cateId;
	@Column(name = "Name")
	@NotEmpty(message = "Category Name is not null !!")
	private String name;
	@Column(name = "Status")
	private boolean status;
	@Column(name = "CreatedAt")
	private Date createdAt;
	@OneToMany(mappedBy = "objProudct")
	private Set<Products> listProduct;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(Integer cateId, String name, boolean status, Set<Products> listProduct) {
		super();
		this.cateId = cateId;
		this.name = name;
		this.status = status;
		this.listProduct = listProduct;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<Products> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Set<Products> listProduct) {
		this.listProduct = listProduct;
	}

	
}
