package spring.boot.restful.crud.swagger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AppUser")
@Table(name = "app_user")

public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;
	
	@Column(name = "useremail")
	private String useremail;

	@Column(name = "userfirstname")
	private String userfirstname;

	@Column(name = "userlastname")
	private String userlastname;

	@Column(name = "useraddress")
	private String useraddress;

	@Column(name = "userenabled")
	private boolean userenabled;
	
	

	public AppUser() {
		super();
	}



	public AppUser(Long id, String username, String useremail, String userfirstname, String userlastname,
			String useraddress, boolean userenabled) {
		super();
		this.id = id;
		this.username = username;
		this.useremail = useremail;
		this.userfirstname = userfirstname;
		this.userlastname = userlastname;
		this.useraddress = useraddress;
		this.userenabled = userenabled;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUseremail() {
		return useremail;
	}



	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}



	public String getUserfirstname() {
		return userfirstname;
	}



	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}



	public String getUserlastname() {
		return userlastname;
	}



	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}



	public String getUseraddress() {
		return useraddress;
	}



	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}



	public boolean isUserenabled() {
		return userenabled;
	}



	public void setUserenabled(boolean userenabled) {
		this.userenabled = userenabled;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", useremail=" + useremail + ", userfirstname="
				+ userfirstname + ", userlastname=" + userlastname + ", useraddress=" + useraddress + ", userenabled="
				+ userenabled + "]";
	}



}
