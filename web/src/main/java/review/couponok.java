package review;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class couponok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
    private boolean check(String mnum, String[] cnum) {
        for(int i=0; i<cnum.length; i++) {
        	if(mnum.equals(cnum[i])) {
        		return true;
        	}
        }
        return false;
    }


    private void errmsg(HttpServletResponse response){
    	try {
    		this.pw = response.getWriter();
	        this.pw.write("<script>"
	                + "alert('유효하지 않은 쿠폰번호입니다.');"
	                + "history.go(-1);"
	                + "</script>");
	        this.pw.flush();
    	} catch (Exception e) {
    		
    	} finally {
    		this.pw.close();    		
    	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String[] cnum = request.getParameterValues("cnum");
        String mid = request.getParameter("mid");
        String mnum = request.getParameter("mnum");
       
        if (!check(mnum, cnum)) {
            errmsg(response);
            return;
        }
        request.setAttribute("mid", mid);
        request.setAttribute("mnum", mnum);
        
        RequestDispatcher rd = request.getRequestDispatcher("/couponok.jsp");
        rd.forward(request, response);
    }
}

