package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;

public class LoginController implements MasterController {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		if (session.getAttribute("id") != null) {
			// Already signed in
			return "redirect::/board";
		} else {
			if (req.getMethod().equalsIgnoreCase("POST")) {
				// If you are not logged in
				MemberDAO dao = new MemberDAO();
				String userId = req.getParameter("id");
				String userPass = req.getParameter("pass");

				int result = dao.loginCheck(userId, userPass);
				// id check progress
				if (result != 1) {
					// success
					return "login";
				} else {
					// fail
					session.setAttribute("id", userId);
					return "redirect::/board";
				}
			}
			return "login";
		}
	}
}
