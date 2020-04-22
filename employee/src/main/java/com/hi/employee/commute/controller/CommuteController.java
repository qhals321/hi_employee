package com.hi.employee.commute.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hi.employee.URLReader;
import com.hi.employee.commute.CommuteVO;
import com.hi.employee.commute.service.CommuteService;

import io.swagger.annotations.Api;

/**
 * Handles requests for the application home page.
 */
@RestController
@Api(value="APIs")
public class CommuteController {
	
	@Autowired
	CommuteService commuteService;
	
	private static final Logger logger = LoggerFactory.getLogger(CommuteController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/commute", method = RequestMethod.POST )
	public Map checkIn() throws JSONException, IOException {
		int id =-1;
		
		System.out.println("commute 시작1");
		URLReader url = new URLReader();
		System.out.println("url 생성");
		
		while(id==-1) {JSONObject json = url.getFingerVerify();
			id = (json.getInt("uid"));
			System.out.println("commute 의 아이디 : "+ id);
		}
			commuteService.checkIn(id);
			
			Map result=new HashMap();
			result.put("result", Boolean.TRUE);
			return result;
	}
	
	
	
	@RequestMapping(value = "/commute", method = RequestMethod.PUT)
	public Map checkOut() throws JSONException, IOException {
		int id = -1;
		URLReader url = new URLReader();
		while(id==-1) {JSONObject json = url.getFingerVerify();
		id = (json.getInt("uid"));
		System.out.println("commute 의 아이디 : "+ id);
	}
			
		commuteService.checkOut(id);
			Map result=new HashMap();
			result.put("result", Boolean.TRUE);
			return result;
	}
	
	@RequestMapping(value = "/commute/log", method = RequestMethod.GET)
	public Map commuteLog() {
		List<CommuteVO> logList=commuteService.commuteList();
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", logList);
		return result;
	}
	
	@RequestMapping(value = "/commute/{id}", method=RequestMethod.GET)
	public Map commuteLogById(@PathVariable int id) {
	
		return null;
	}
	
	
}
