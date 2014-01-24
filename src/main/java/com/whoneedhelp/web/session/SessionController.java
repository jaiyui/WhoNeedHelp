package com.whoneedhelp.web.session;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whoneedhelp.web.common.CommonBuilder;

@Controller
@RequestMapping("/session")
public class SessionController {

	@RequestMapping(value = "/index")
	public String sessionDivider(HttpSession session)
	{
		if (session.getAttribute("id") == null)
			return "redirect:/session/login";
		else
			return "redirect:/session/logout";
	}


	@RequestMapping(value = "/login")
	public String login(HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Login", "", "");
		
		model.addAllAttributes(defaultParam);
		return "/session/loginForm"; 
	}

	@RequestMapping(value = "/logout")
	public String logoutProcess(HttpSession session)
	{
		session.invalidate();
		return "redirect:/dashboard/view";
	}	

	@RequestMapping(value = "/start")
	@ResponseBody
	public Boolean start(String id, String pw, HttpSession session)
	{
		Boolean loginResult = false;
		/*
		Boolean loginResult = certifyService.certify(id, pw);
		if (loginResult)
		{
			Employee employee = employeeService.read(id);
			session.setAttribute("no", String.valueOf(employee.getEmp_no()));
			session.setAttribute("id", employee.getEmp_id());
			session.setAttribute("name", employee.getEmp_nm());
			session.setAttribute("super", String.valueOf(employee.getEmp_super()));
			session.setMaxInactiveInterval(3600);
		}
		*/
		return loginResult;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register(HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Login", "", "");
		
		model.addAllAttributes(defaultParam);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register()
	{
		System.out.print("============" + "register" + "===================\n");
	}
}
