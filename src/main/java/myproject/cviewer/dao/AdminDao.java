package myproject.cviewer.dao;

import java.util.List;

import myproject.cviewer.dto.Admin;

public interface AdminDao {
	Admin getById(int id);
	void create (Admin admin);
	void update (Admin admin);
	void delete (Admin admin);
	List<Admin> getAll();
}
