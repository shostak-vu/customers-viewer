package myproject.cviewer.service;

import java.util.List;

import myproject.cviewer.dto.Admin;

public interface AdminService {
	Admin getById(int id);
	Admin getByEmail(String email);
	void create (Admin admin);
	void update (Admin admin);
	void delete (Admin admin);
	List<Admin> getAll();
}
