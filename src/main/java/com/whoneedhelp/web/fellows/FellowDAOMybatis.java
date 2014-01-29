package com.whoneedhelp.web.fellows;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @brief 	Fellow DAO Mybatis 구현 클래스
 * @author 	성낙천
 * @version 1.0
 * @date    생성: 2014.01.24 
 * @date    최종수정: 2014.01.28
 * @remark
 */
@Repository
public class FellowDAOMybatis implements FellowDAO {

	@Autowired SqlSession sqlSession;
	
	@Override
	public Boolean checkIdDuplicate(String id) {
		int foundCount = sqlSession.selectOne("Fellows.checkidduplicate", id);
		return (foundCount > 0) ? true : false;
	}

	@Override
	public Boolean checkNickNameDuplicate(String nickname) {
		int foundCount = sqlSession.selectOne("Fellows.checknicknameduplicate", nickname);
		return (foundCount > 0) ? true : false;
	}

	@Override
	public void create(Fellows fellows) {
		sqlSession.insert("Fellows.add", fellows);
	}

	@Override
	public void update(Fellows fellows) {
		// TODO Auto-generated method stub

	}

	@Override
	public Fellows read(String id) {
		return sqlSession.selectOne("Fellows.read", id);
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
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("password", password);

		int foundCount = sqlSession.selectOne("Fellows.verify", param);
		return (foundCount > 0) ? true : false;
	}

}
