package com.whoneedhelp.web.fellows;

import java.util.HashMap;
import java.util.List;

public class FellowDAOMybatis implements FellowDAO {

	@Override
	public Boolean checkIdDuplicate(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkNickNameDuplicate(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Fellows fellows) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Fellows fellows) {
		// TODO Auto-generated method stub

	}

	@Override
	public Fellows read(String id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Fellows> list(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListCount(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean verify(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
