package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements MasterController {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		req.getSession().removeAttribute("id");
		// Clear id session
		return "redirect::/";
	}
}
