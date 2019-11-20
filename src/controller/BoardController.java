package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardDTO;

public class BoardController implements MasterController {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		BoardDAO dao = new BoardDAO();
		
		int page = 1;
		try {
			page = Integer.parseInt(req.getParameter("p"));
			if(page <= 0) {
				page = 1;
			}
		} catch (Exception e) {
			page = 1;
		}
		
		ArrayList<BoardDTO> userList = dao.selectPosting(page); 
		//Put dao selectPosting result in boardDTO type ArrayList

		req.setAttribute("list", userList);
		return "board"; //board page return
	}
}
