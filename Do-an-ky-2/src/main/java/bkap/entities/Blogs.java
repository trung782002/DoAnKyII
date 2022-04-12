package bkap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Blogs")

public class Blogs {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Name")
	@NotEmpty(message = "Name is not null !!")
	private String name;
	@Column(name = "Title")
	@NotEmpty(message = "Title is not null !!")
	private String title;	
	@Column(name = "MainImageUrl")
	@NotEmpty(message = "MainImageUrl is not null !!")
	private String mainImageUrl;
	@Column(name = "Content_1")
	@NotEmpty(message = "Content_1 is not null !!")
	private String content_1;
	@Column(name = "SecondImageUrl")
	@NotEmpty(message = "SecondImageUrl is not null !!")
	private String secondImageUrl;
	@Column(name = "Content_2")
	@NotEmpty(message = "Content_2 is not null !!")
	private String content_2;
	@Column(name = "ThirdImageUrl")
	@NotEmpty(message = "ThirdImageUrl is not null !!")
	private String ThirdImageUrl;
	@Column(name = "Content_3")
	@NotEmpty(message = "Content_3 is not null !!")
	private String Content_3;
	@Column(name = "Status")
	private boolean status;
	@Column(name = "CreatedAt")
	private Date createdAt;
	public Blogs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blogs(Integer id, String name, String title, String mainImageUrl, String content_1, String secondImageUrl,
			String content_2, String thirdImageUrl, String content_3, boolean status, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.mainImageUrl = mainImageUrl;
		this.content_1 = content_1;
		this.secondImageUrl = secondImageUrl;
		this.content_2 = content_2;
		ThirdImageUrl = thirdImageUrl;
		Content_3 = content_3;
		this.status = status;
		this.createdAt = createdAt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMainImageUrl() {
		return mainImageUrl;
	}
	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}
	public String getContent_1() {
		return content_1;
	}
	public void setContent_1(String content_1) {
		this.content_1 = content_1;
	}
	public String getSecondImageUrl() {
		return secondImageUrl;
	}
	public void setSecondImageUrl(String secondImageUrl) {
		this.secondImageUrl = secondImageUrl;
	}
	public String getContent_2() {
		return content_2;
	}
	public void setContent_2(String content_2) {
		this.content_2 = content_2;
	}
	public String getThirdImageUrl() {
		return ThirdImageUrl;
	}
	public void setThirdImageUrl(String thirdImageUrl) {
		ThirdImageUrl = thirdImageUrl;
	}
	public String getContent_3() {
		return Content_3;
	}
	public void setContent_3(String content_3) {
		Content_3 = content_3;
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
