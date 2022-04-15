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
@Table(name = "Account_Roles")
public class Account_Roles {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "AccId", referencedColumnName = "AccId")
	private Accounts objAccountOfAccountRole;
	
	@ManyToOne
	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	private Roles objRoleOfAccountRole;

	public Account_Roles(Integer id, Accounts objAccountOfAccountRole, Roles objRoleOfAccountRole) {
		super();
		this.id = id;
		this.objAccountOfAccountRole = objAccountOfAccountRole;
		this.objRoleOfAccountRole = objRoleOfAccountRole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Accounts getObjAccountOfAccountRole() {
		return objAccountOfAccountRole;
	}

	public void setObjAccountOfAccountRole(Accounts objAccountOfAccountRole) {
		this.objAccountOfAccountRole = objAccountOfAccountRole;
	}

	public Roles getObjRoleOfAccountRole() {
		return objRoleOfAccountRole;
	}

	public void setObjRoleOfAccountRole(Roles objRoleOfAccountRole) {
		this.objRoleOfAccountRole = objRoleOfAccountRole;
	}

	
}
