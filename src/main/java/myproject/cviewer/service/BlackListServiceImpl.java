package myproject.cviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myproject.cviewer.dao.BlackListDao;
import myproject.cviewer.dto.Admin;
import myproject.cviewer.dto.BlackList;
import myproject.cviewer.dto.Client;
@Service
public class BlackListServiceImpl implements BlackListService {
	
	@Autowired
	private BlackListDao blackListDao;
	
	@Override
    @Transactional
	public BlackList getById(int id) {		
		return blackListDao.getById(id);
	}

	@Override
    @Transactional
	public void create(Client blockedClient, Admin admin, String description) {
		BlackList blackListItem = new BlackList(blockedClient, description, admin);
		blackListDao.create(blackListItem);

	}

	@Override
    @Transactional
	public void update(Client blockedClient, Admin admin, String description) {
		BlackList blackListItem = new BlackList(blockedClient, description, admin);
		blackListDao.update(blackListItem);
	}

	@Override
    @Transactional
	public void delete(BlackList blackListItem) {
		blackListDao.delete(blackListItem);
	}

	@Override
    @Transactional(readOnly = true)
	public List<BlackList> getAll() {
		List<BlackList> blackList = blackListDao.getAll();
		return blackList;
	}

}
