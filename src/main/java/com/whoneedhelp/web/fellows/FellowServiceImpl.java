package com.whoneedhelp.web.fellows;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whoneedhelp.web.common.Utils;

@Service
public class FellowServiceImpl implements FellowService {

	@Autowired FellowDAO dao;

	@Override
	public void create(Fellows fellows) {
		fellows.password = Utils.encodeMD5(fellows.password);

		dao.create(fellows);
	}

	@Override
	public void update(Fellows fellows) {
		// TODO Auto-generated method stub

	}

	@Override
	public Fellows read(String id) {
		return dao.read(id);
	}

	@Override
	public void active(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inactive(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Fellows> list(String target, String keyword, int page, int perPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListCount(String target, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean verify(String id, String password) {
		password = Utils.encodeMD5(password);

		return dao.verify(id, password);
	}

}
