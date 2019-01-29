package myproject.cviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myproject.cviewer.dao.ClientDao;
import myproject.cviewer.dto.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	@Transactional
	public Client getById(int id) {		
		return clientDao.getById(id);
	}

	@Override
	@Transactional
	public void create(Client client) {
		clientDao.create(client);
	}

	@Override
	@Transactional
	public void update(Client client) {
		clientDao.update(client);
	}

	@Override
	@Transactional
	public void delete(Client client) {
		clientDao.delete(client);
	}

	@Override
    @Transactional(readOnly = true)
	public List<Client> getAll() {
		List<Client> clients = clientDao.getAll();		
		return clients;
	}

}
