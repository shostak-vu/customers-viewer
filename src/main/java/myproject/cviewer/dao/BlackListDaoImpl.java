package myproject.cviewer.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myproject.cviewer.dto.BlackList;
@Repository
public class BlackListDaoImpl implements BlackListDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public BlackList getById(int id) {
		return sf.getCurrentSession().byId(BlackList.class).getReference(id);
	}	

	@Override
	public void create(BlackList blockedClient) {
		sf.getCurrentSession().saveOrUpdate(blockedClient);
	}

	@Override
	public void delete(BlackList blockedClient) {
		sf.getCurrentSession().delete(blockedClient);
	}

	@Override
	public void update(BlackList blockedClient) {
		sf.getCurrentSession().saveOrUpdate(blockedClient);		
	}
	
	@Override
	public List<BlackList> getAll() {
		@SuppressWarnings("unchecked")
		TypedQuery<BlackList> querys = sf.getCurrentSession().createQuery("from BlackList");
		return querys.getResultList();
	}
}
