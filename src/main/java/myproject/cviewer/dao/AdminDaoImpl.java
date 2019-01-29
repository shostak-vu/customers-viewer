package myproject.cviewer.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myproject.cviewer.dto.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Admin getById(int id) {
		return sf.getCurrentSession().byId(Admin.class).getReference(id); 
	}

	@Override
	public void create(Admin admin) {
		sf.getCurrentSession().save(admin);
	}

	@Override
	public void update(Admin admin) {
		sf.getCurrentSession().saveOrUpdate(admin);
	}

	@Override
	public void delete(Admin admin) {
		sf.getCurrentSession().delete(admin);

	}

	@Override
	public List<Admin> getAll() {
		@SuppressWarnings("unchecked")
		TypedQuery<Admin> querys = sf.getCurrentSession().createQuery("From Admin");
		return querys.getResultList();
	}

}
