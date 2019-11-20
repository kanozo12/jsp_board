package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardDTO;

public class ContentViewController implements MasterController {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contentView(Integer.parseInt(req.getParameter("no")));
		// Put 'no' value passed as parameter in DAO ContentView method and put the
		// result value in DTO.

		req.setAttribute("content_view", dto);
		// To use the value of dto, we put dto with the name "content_view".

		HttpSession session = req.getSession();
		session.setAttribute("writer", dto.getWriter());
		//Registered the writer in session
		
		return "contentView"; //contentView page return
	}
}
