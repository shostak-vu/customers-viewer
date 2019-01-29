package myproject.cviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myproject.cviewer.dao.AdminDao;
import myproject.cviewer.dto.Admin;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	@Transactional
	public Admin getById(int id) {
		return adminDao.getById(id);
	}

	@Override
	@Transactional
	public void create(Admin admin) {
		adminDao.create(admin);
	}

	@Override
	@Transactional
	public void update(Admin admin) {
		adminDao.update(admin);
	}

	@Override
	@Transactional
	public void delete(Admin admin) {
		adminDao.delete(admin);
	}

	@Override
    @Transactional(readOnly = true)
	public List<Admin> getAll() {
		List<Admin> admins = adminDao.getAll();
		return admins;
	}

}
