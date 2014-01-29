package com.whoneedhelp.web.session;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whoneedhelp.web.fellows.FellowService;
import com.whoneedhelp.web.fellows.Fellows;
import com.whoneedhelp.web.common.CommonBuilder;

@Controller
@RequestMapping("/session")
public class SessionController {

	@Autowired FellowService fellowService;

	@RequestMapping(value = "/index")
	public String sessionDivider(HttpSession session)
	{
		if (session.getAttribute("id") == null)
			return "redirect:/session/login";
		else
			return "redirect:/session/logout";
	}


	@RequestMapping(value = "/login")
	public String login(@RequestParam(defaultValue="wait")String result, String url, String queryString, HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Login", "", "");
		
		model.addAllAttributes(defaultParam);
		model.addAttribute("result", result);

		String id = (String)session.getAttribute("id");
		if (id != null) return "redirect:/dashboard/view";
		model.addAttribute("url", url);
		model.addAttribute("querystring", queryString);
		return "/session/loginForm"; 
	}

	@RequestMapping(value = "/logout")
	public String logoutProcess(HttpSession session)
	{
		session.invalidate();
		return "redirect:/dashboard/view";
	}	

	@RequestMapping(value = "/start")
	public String start(String url, String queryString, String email, String password, HttpSession session)
	{
		System.out.print("============" + url + "===================\n");
		Boolean loginResult = fellowService.verify(email, password);

		if (loginResult)
		{
			Fellows fellow = fellowService.read(email);
			session.setAttribute("fellowSeq", String.valueOf(fellow.getFellowSeq()));
			session.setAttribute("id", fellow.getId());
			session.setAttribute("nickname", fellow.getNickname());
			session.setMaxInactiveInterval(3600);
			if (url == "")
				return "redirect:/dashboard/view";
			else
				return "redirect:" + url + "?" + queryString;
		} else
			return "redirect:login?result=failure&url=" + url + "&queryString=" + queryString;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register(HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Login", "", "");
		
		model.addAllAttributes(defaultParam);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid Fellows fellows, Errors errors)
	{
		if (errors.hasErrors()) return "/session/register";	
		fellowService.create(fellows); 
		
		return "redirect:login";
	}
}
