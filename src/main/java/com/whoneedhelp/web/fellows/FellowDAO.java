package com.whoneedhelp.web.fellows;

import java.util.HashMap;
import java.util.List;

public interface FellowDAO {
	Boolean checkIdDuplicate(String id);

	Boolean checkNickNameDuplicate(String nickname);

	void create(Fellows fellows);
	
	void update(Fellows fellows);
	
	Fellows read(String id);

	void active(String id);

	void inactive(String id);
	
	List<Fellows> list(HashMap<String, String> param);
	
	int getListCount(HashMap<String, String> param);

	Boolean verify(String id, String password);
}
