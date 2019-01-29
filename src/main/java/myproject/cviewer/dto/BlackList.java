package myproject.cviewer.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "clientBlackList")
@Proxy(lazy =false) //так делать нельзя, но я не нашел как надо, т.к. на уровне контролерра Exeption 
//org.hibernate.LazyInitializationException: could not initialize proxy - no Session 
public class BlackList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@OneToOne
    @JoinColumn(name = "client_id")
	private Client client;
	/* Description of the reason for adding to the blacklist */
	@Column(name = "description")
	private String description;
	
	@ManyToOne(targetEntity=Admin.class)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	public BlackList() {}

	public BlackList(Client client, String description, Admin admin) {
		super();
		this.client = client;
		this.description = description;
		this.admin = admin;
	}

	public BlackList(int id, Client client, String description, Admin admin) {
		super();
		this.id = id;
		this.client = client;
		this.description = description;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		BlackList other = (BlackList) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientBlackList [id=" + id + ", client=" + client.getFirstName() 
			+ client.getLastName() + ", description=" + description + "]";
	}
	
	
}
