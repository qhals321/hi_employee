package com.hi.employee.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hi.employee.shop.ShopVO;
import com.hi.employee.shop.service.ShopService;

@Controller
public class SessionController {
	
	@Autowired
	ShopService shopService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String shopLogin (ShopVO shop,
			HttpSession session,
			ModelMap modelMap) {
		
		
		ShopVO shop2 = shopService.shopSearch(shop);
		
		if(shop2.getShopPw().equals(shop.getShopPw())) {
			
			session.setAttribute("shop", shop);
			
			ShopVO shop3;
			shop3 = (ShopVO)session.getAttribute("shop");
			
		return "/WEB-INF/views/employee_index.jsp";		
		}else {
			System.out.println("비어있어용");
			modelMap.put("error", "Invalid Account");
			return "/WEB-INF/views/employee_login.jsp";
			
		}
		
		
	}
	
	@RequestMapping("/logout")
	public String shopLogout(ShopVO shop, HttpSession session) {
		
		session.invalidate();
		return "/WEB-INF/views/employee_login.jsp";
	}

}
