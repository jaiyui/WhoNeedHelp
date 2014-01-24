package com.whoneedhelp.web.fellows;

import java.util.List;

public interface FellowService {

	void create(Fellows fellows);
	
	void update(Fellows fellows);
	
	Fellows read(String id);

	void active(String id);

	void inactive(String id);

	List<Fellows> list(String target, String keyword, int page, int perPage);

	int getListCount(String target, String keyword);
	
	Boolean verify(String id, String password);
}
