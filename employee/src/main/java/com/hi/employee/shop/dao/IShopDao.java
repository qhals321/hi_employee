package com.hi.employee.shop.dao;

import java.util.List;

import com.hi.employee.shop.ShopVO;

public interface IShopDao {
	int shopInsert(ShopVO shop);
	ShopVO shopSelectByID(String ID);
	List<ShopVO> shopSelectAll();

	int shopUpdate(ShopVO shop);
	
	int shopLogIn(String ID, String name);
	
	int shopLogOut();
	
	ShopVO shopSelect(ShopVO shop);
	int pwSearch(String pw);
}


/*  /shop/login -> /employee -> / */