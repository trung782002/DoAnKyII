package bkap.entities;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles {
	@Id
	@Column(name = "RoleId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Status")
	private boolean status;
	
	@OneToMany(mappedBy = "objRoleOfAccountRole")
	private Set<Account_Roles> listAccountRoles;
	
	public Roles() {
		// TODO Auto-generated constructor stub
	}

	public Roles(Integer roleId, String name, boolean status, Set<Account_Roles> listAccountRoles) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.status = status;
		this.listAccountRoles = listAccountRoles;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public Set<Account_Roles> getListAccountRoles() {
		return listAccountRoles;
	}

	public void setListAccountRoles(Set<Account_Roles> listAccountRoles) {
		this.listAccountRoles = listAccountRoles;
	}

	
}

