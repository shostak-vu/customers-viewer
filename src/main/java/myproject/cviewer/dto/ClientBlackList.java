package myproject.cviewer.dto;

public class ClientBlackList {
	private int id;
	private Client client;
	/* Description of the reason for adding to the blacklist */
	private String description;
	private Admin admin;
	
	public ClientBlackList() {}

	public ClientBlackList(Client client, String description, Admin admin) {
		super();
		this.client = client;
		this.description = description;
		this.admin = admin;
	}

	public ClientBlackList(int id, Client client, String description, Admin admin) {
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
		ClientBlackList other = (ClientBlackList) obj;
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
