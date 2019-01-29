package myproject.cviewer.service;

import java.util.List;

import myproject.cviewer.dto.Client;

public interface ClientService {
	Client getById(int id);
	void create (Client client);
	void update (Client client);
	void delete (Client client);
	List<Client> getAll();
}
