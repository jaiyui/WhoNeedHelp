package com.whoneedhelp.web.common;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class CommonBuilder {
	
	public static HashMap<String, String> CommonSetter(HttpSession session)
	{
		HashMap<String, String> defaultParam = new HashMap<String, String>();
		defaultParam.put("id", (String)session.getAttribute("id"));
		defaultParam.put("name", (String)session.getAttribute("name"));
		defaultParam.put("topMenu", "1");
		defaultParam.put("middleMenu", "1");
		return defaultParam;
	}

	public static HashMap<String, String> MenuSetter(HashMap<String, String> defaultParam, String topMenu, String middleMenu, String lowMenu)
	{
		defaultParam.put("topMenu", topMenu);
		defaultParam.put("middleMenu", middleMenu);
		defaultParam.put("lowMenu", lowMenu);
		return defaultParam;
	}
}
