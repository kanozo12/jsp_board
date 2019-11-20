package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardController;
import controller.ContentViewController;
import controller.DeleteController;
import controller.LoginController;
import controller.LogoutController;
import controller.MainController;
import controller.MasterController;
import controller.ModifyController;
import controller.RegisterController;
import controller.UserInfoController;
import controller.WriteController;

public class MainRouter extends HttpServlet {
	// doget, dopost 를 둘다 받아주는 게 서비스
	private Map<String, MasterController> urlMap = new HashMap<>();

	private static String pre = "/WEB-INF/views/";
	// Cut path
	private static String post = ".jsp";
	// Cut extension

	@Override
	public void init() {
		try {
			urlMap.put("/", new MainController());
			urlMap.put("/login", new LoginController());
			urlMap.put("/register", new RegisterController());
			urlMap.put("/board", new BoardController());
			urlMap.put("/logout", new LogoutController());
			urlMap.put("/write", new WriteController());
			urlMap.put("/userinfo", new UserInfoController());
			urlMap.put("/modify", new ModifyController());
			urlMap.put("/contentView", new ContentViewController());
			urlMap.put("/delete", new DeleteController());
			// Sent to the controller at user's request
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		MasterController controller = urlMap.get(uri);
		if (controller == null) {
			goDispatch(req, resp, "notfound");
			// If no controller, go to "notfound"
		} else {
			String view = controller.process(req, resp);
			if (view.startsWith("redirect::")) {
				String target = view.substring("redirect::".length());
				resp.sendRedirect(target);
			} else {
				goDispatch(req, resp, view);
			}
		}
	}

	private void goDispatch(HttpServletRequest req, HttpServletResponse resp, String view)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(pre + view + post);
		rd.forward(req, resp);
	}

}
