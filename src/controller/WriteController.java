package controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.BoardDAO;
import model.BoardDTO;

public class WriteController implements MasterController {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();

		if (session.getAttribute("id") == null) {
			return "redirect::/board";
		} else {

			if (req.getMethod().equalsIgnoreCase("POST")) { // If the request is Post
				String savePath = req.getServletContext().getRealPath("file");
				System.out.println(savePath);
				int sizeLimit = 10 * 1024 * 1024;
				String fileName1 = "";

				BoardDAO dao = new BoardDAO();
				BoardDTO dto = new BoardDTO();

				try {
					MultipartRequest multi = new MultipartRequest(req, savePath, sizeLimit, "utf-8",
							new DefaultFileRenamePolicy());
					Enumeration files = multi.getFileNames();

					String file1 = (String) files.nextElement();
					fileName1 = multi.getFilesystemName(file1);

					String title = multi.getParameter("title");
					String writer = (String) session.getAttribute("id");
					String content = multi.getParameter("content");

					dto.setTitle(title);
					dto.setWriter(writer);
					dto.setContent(content);
					if (fileName1 == null) {
						dto.setFileName("");
					} else {
						dto.setFileName(fileName1);
					}

					dao.posting(dto);

				} catch (Exception e) {
					e.printStackTrace();
				}
				return "redirect::/board";
			}
			return "write";
		}
	}
}
