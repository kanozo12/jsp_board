package controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.BoardDAO;
import model.BoardDTO;

public class ModifyController implements MasterController {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();

		if (req.getMethod().equalsIgnoreCase("POST")) { // If the request is Post
			String savePath = req.getServletContext().getRealPath("file"); // Save attachment
			int sizeLimit = 10 * 1024 * 1024; // 10mb capacity limit
			String fileName1 = "";

			try {
				MultipartRequest multi = new MultipartRequest(req, savePath, sizeLimit, "utf-8",
						new DefaultFileRenamePolicy()); // DefaultFileRenamePolicy : Same name automatically changed
				Enumeration files = multi.getFileNames();

				String file1 = (String) files.nextElement(); // Get the value stored in name of the file tag
				fileName1 = multi.getFilesystemName(file1); // File name stored on the server

				int no = Integer.parseInt(multi.getParameter("no"));
				String title = multi.getParameter("title");
				String content = multi.getParameter("content");

				if (fileName1 != null) {
					dao.modify(no, title, content, fileName1); // If a file is attached
				} else {
					dao.modify(no, title, content, ""); // If no file is attached
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect::/board";

		} else {
			// If the request is Get
			int bno = Integer.parseInt(req.getParameter("no"));
			dto = dao.modifyView(bno); // Get information to fix
			req.setAttribute("modify_view", dto);
			return "modify";
		}

	}
}
