package com.hi.employee.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hi.employee.shop.ShopVO;
import com.hi.employee.shop.dao.ShopDao;


@Service
public class ShopService implements IShopService{
	
	@Autowired
	ShopDao dao;
	
	
	public ShopService() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public void shopInsert(ShopVO shop) {
		int result=dao.shopInsert(shop);
		
		if(result==0) {
			System.out.println("실패");
		} else {
			System.out.println("성공");
		}
		
		
	}
	
	@Override
	public List<ShopVO> shopSelectAll() {
		List<ShopVO> shops = dao.shopSelectAll();
		return shops;
	}
	
	@Override
	public ShopVO shopSearch(ShopVO shop) {
		System.out.println("service 시작");
		ShopVO shop2 = dao.shopSelect(shop);
		
		
		
		return shop2;
	}
	
	
	@Override
	public int shopPw(String shopPw) {
		 return dao.pwSearch(shopPw);
		
	}

}
