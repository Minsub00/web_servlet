package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig( // 첨부파일 환경설정
		fileSizeThreshold = 1024 * 1024 * 2, // 한 개의 파일 전송크기 : 2MB
		maxFileSize = 1024 * 1024 * 5, // 파일 최대 크기 : 5MB (5MB가 넘어갈 경우 서버가 다운됨)
		maxRequestSize = 1024 * 1024 * 100 // 여러개의 첨부 파일 전체의 용량 : 100MB
		)

// 여러개의 파일을 전송하는 방식
public class multi_file extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter();
			String mname = request.getParameter("mname");
			System.out.println(mname);
			String url = request.getServletContext().getRealPath("/upload/");
			// name을 따로 설정하지 않으며, 배열 클래스를 이용하여 IO값을 핸들링함
			// Collection : 모든 name 다 받을 수 있음
			Collection<Part> p = request.getParts();
			
			for(Part f : p) {
				String filename = f.getSubmittedFileName();
				long size = f.getSize();
				//if(!filename.equals("") && size < 2097152) { // 파일명이 있을경우
				if(filename != null && size < 2097152) {
					f.write(url + filename);
				}
			}
			
		} catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 접근 방법이 아닙니다.');"
					+ "history.go(-1);"
					+ "</script>");
			System.out.println(e);
		} finally {
			this.pw.close();
		}
	}

}
