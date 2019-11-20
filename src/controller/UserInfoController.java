package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoController implements MasterController{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		
		
		
		return "userinfo";
	}
}