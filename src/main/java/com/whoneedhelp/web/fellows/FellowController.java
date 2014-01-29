/**
 * @file	FellowController.java
 * @brief   회원 처리 Controller class 
 * @author  성낙천
 * @date    생성: 2014.01.29
 * @date    최종수정: 2014.01.29 
 */

package com.whoneedhelp.web.fellows;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @brief 	회원 관리 컨트롤러 클래스
 * @author 	성낙천
 * @version 1.0
 * @date    생성: 2014.01.29 
 * @date    최종수정: 2014.01.29 
 * @remark	대시보드 처리 클래스
 */

@Controller
@RequestMapping("/fellow")
public class FellowController {

	@Autowired FellowService fellowService;

	@RequestMapping(value = "/profile")
	public String profile(HttpSession session, Model model)
	{
		return "/fellow/profile";
	}
	
}
