package myproject.cviewer.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myproject.cviewer.dto.Client;
@Repository
public class ClientDaoImpl implements ClientDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Client getById(int id) {
		return sf.getCurrentSession().byId(Client.class).getReference(id);		
	}

	@Override
	public void create(Client client) {
		sf.getCurrentSession().save(client);
	}

	@Override
	public void update(Client client) {
		sf.getCurrentSession().saveOrUpdate(client);
	}

	@Override
	public void delete(Client client) {
		sf.getCurrentSession().delete(client);
	}

	
	@Override
	public List<Client> getAll() {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> querys = sf.getCurrentSession().createQuery("From Client");
		return querys.getResultList();
	}

}
