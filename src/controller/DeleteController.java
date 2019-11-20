package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;

public class DeleteController implements MasterController {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();

		String user = (String) session.getAttribute("writer");
		// Get the author of the post
		String writer = (String) session.getAttribute("id");
		// Get the id of the current session
		if (user == null) {
			return "redirect::/login";
		}
		if (user.equals(writer)) {
			// Compare two sessions
			// true
			BoardDAO dao = new BoardDAO();
			dao.delete(req.getParameter("no"));
			// Deletion Progress

			return "redirect::/board";
		} else {
			// Two sessions do not match
			// false
			System.out.println("권한이 없음");
			return "redirect::/login";
		}
	}
}
