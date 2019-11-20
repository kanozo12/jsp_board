package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

public class RegisterController implements MasterController{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equalsIgnoreCase("POST")) { // If the request is Post
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			
			dto.setId(req.getParameter("id"));
			dto.setPass(req.getParameter("pass"));
			dto.setName(req.getParameter("name"));
			
			dao.insertMember(dto);
			
			return "redirect::/";
		}
		return "register";
	}
}
