package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// cos 사용없이 자체 라이브러리를 이용하여 설정
@MultipartConfig( // 첨부파일 환경설정
		fileSizeThreshold = 1024 * 1024 * 2, // 한 개의 파일 전송크기 : 2MB
		maxFileSize = 1024 * 1024 * 5, // 파일 최대 크기 : 5MB
		maxRequestSize = 1024 * 1024 * 100 // 여러개의 첨부 파일 전체의 용량 : 100MB
		)

public class fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			// Front-end에서 전송된 name 값에 I/O 처리 방식
			Part mfile = request.getPart("mfile");
			// 파일명을 확인하는 코드
			String filename = mfile.getSubmittedFileName();
			// 파일 용량 크기(byte)
			long filesize = mfile.getSize();
//			System.out.println(filesize);
			if (filesize > 2097152) {
				pw.write("<script>"
						+ "alert('파일 최대 용량은 2MB 입니다');"
						+ "history.go(-1);"
						+ "</script>");
			} else {
				/*
				 * WEB I/O는 웹 전용 이미지 디렉토리를 별도로 구성해야만 
				 * 정상적으로 웹에서 이미지를 확인할 수 있음
				 * getServketContext(웹경로) + getRealPath(저장디렉토리)
				 * Part(클라이언트) <=> MultiPart(서버)
				 * APP I/O => File => InputStream => OutputStream
				 */
				// WEB Server 에서 적용된 디렉토리에 저장되도록합니다. (src 경로X)
				String url = request.getServletContext().getRealPath("/upload/");
				mfile.write(url + filename);
				this.pw.write("<script>"
						+ "alert('정상적으로 업로드되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		} catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 접근 방식이 아닙니다');"
					+ "history.go(-1);"
					+ "</script>");
		} finally {
			this.pw.close();
		}
	}

}
