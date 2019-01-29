package myproject.cviewer.dao;

import java.util.List;

import myproject.cviewer.dto.Client;

public interface ClientDao {
	Client getById(int id);
	void create (Client client);
	void update (Client client);
	void delete (Client client);
	List<Client> getAll();
}
