package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MasterController {
	public String process(HttpServletRequest req, HttpServletResponse resp);
}
