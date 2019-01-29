package myproject.cviewer.dao;

import java.util.List;

import myproject.cviewer.dto.BlackList;

public interface BlackListDao {
	BlackList getById(int id);
	void create (BlackList blockedClient);
	void update (BlackList blockedClient);
	void delete (BlackList blockedClient);
	List<BlackList> getAll();
}
