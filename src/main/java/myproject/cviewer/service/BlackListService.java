package myproject.cviewer.service;

import java.util.List;

import myproject.cviewer.dto.Admin;
import myproject.cviewer.dto.BlackList;
import myproject.cviewer.dto.Client;

public interface BlackListService {
	BlackList getById(int id);
	void create (Client blockedClient, Admin admin, String description);
	void update (BlackList blockedClient);
	void delete (BlackList blockedClient);
	List<BlackList> getAll();
}
