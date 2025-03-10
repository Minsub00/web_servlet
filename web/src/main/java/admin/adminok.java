package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.encry_model;

public class adminok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String adm_id = req.getParameter("adm_id");
		String adm_pw = req.getParameter("adm_pw");
		String adm_no = req.getParameter("adm_no");
				
		encry_model em = new encry_model();
		String id = em.datadecode(adm_id);
		String pw = em.datadecode(adm_pw);
		String no = em.datadecode(adm_no);
						
	}

}
