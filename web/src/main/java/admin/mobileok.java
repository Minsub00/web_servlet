package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 100
		)
public class mobileok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String se = req.getParameter("security");
		if(!se.equals("m")) {
			PrintWriter pw = res.getWriter();
			pw.write("<script>"
					+ "alert('error!');"
					+ "history.go(-1);"
					+ "</script>");
			
			pw.close();
		} else {
			try {
				new reviews(req, res);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}

class reviews{
	PrintWriter pw = null;
	public reviews(HttpServletRequest req, HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		String ori = req.getServletContext().getRealPath("");
		System.out.println(ori);
		
		String mname = req.getParameter("mname");
		String pname = req.getParameter("pname");
		String star = req.getParameter("star");
		String mtext = req.getParameter("mtext");
		Part p = req.getPart("mfile");
		String filename = p.getSubmittedFileName();
		if(filename != "") { // 이미지가 첨부 되었을 경우
			String url = req.getServletContext().getRealPath("/review/");
			p.write(url + filename);
			
			this.pw.write("<script>"
					+ "alert('정살적으로 리뷰가 등록 되었습니다');"
					+ "location.herf = './mobile.html';"
					+ "</script>");
		}		
	}
}