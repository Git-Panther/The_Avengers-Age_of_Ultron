package ein.mono.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import ein.mono.board.model.service.AttachmentService;
import ein.mono.board.model.service.PostService;
import ein.mono.board.model.vo.AttachmentVo;
import ein.mono.board.model.vo.PostVo;

@WebServlet("/updatePost.do")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePostServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드/다운로드 -> cos.jar 이용해야 함.
		// 1. 파일 사이즈 설정
		int maxSize = 1024 * 1024 * 10; // 10mb
		// 2. 파일 전송 시 enctype 정상적으로 설정되었는지 확인
		RequestDispatcher view = null;
		if(! ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "전송 데이터의 타입을 확인하십시오!!");
			view.forward(request, response);
		}
		// 3. 파일 저장 경로 설정
		String root = request.getServletContext().getRealPath("/");
		String path = root + "upload";
		
		// 4. request -> multipartrequest 객체로 변환
		MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "UTF-8");
		
		// 변수에 값 저장
		String post_code = mRequest.getParameter("post_code");
		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");
		String writer = mRequest.getParameter("writer");
		
		ArrayList<AttachmentVo> oldFiles = new AttachmentService().selectAttachmentList(post_code);
		Enumeration<String> fileNameEnum = mRequest.getFileNames();

		ArrayList<String> originNames = new ArrayList<String>();
		ArrayList<String> newNames = new ArrayList<String>();
		
		for(int i=0; fileNameEnum.hasMoreElements(); i++) {
			fileNameEnum.nextElement();
			
			newNames.add(mRequest.getFilesystemName("galleryImage" + (i + 1)));
			originNames.add(mRequest.getOriginalFileName("galleryImage" + (i + 1)));
		}
		
		// attachment 객체를 담은 리스트
		ArrayList<AttachmentVo> list = new ArrayList<AttachmentVo>();
		AttachmentVo temp = null;
		for(int i=0; i < newNames.size(); i++) {
			temp = new AttachmentVo();
			temp.setNew_name(newNames.get(i));
			temp.setOrigin_name(originNames.get(i));
			temp.setFile_path(path);
			
			list.add(temp);
		}
		
		int result_updateAttachment = new AttachmentService().updateAttachment(post_code, list);
		
		//기존 파일 삭제
		if(null != oldFiles) {
			for(AttachmentVo av : oldFiles) {
				File file = new File(path + "/" + av.getNew_name());
				//System.out.println(file);
				file.delete();
			}
		}
		
		PostVo post = new PostVo();
//		post.setNo(boardNo);
//		post.setTitle(title);
//		post.setContent(content);
//		post.setAttatchFile(null != fileName ? fileName : oldFile);
		
		int result = new PostService().updatePost(post);

		if(0 < result && 0 < result_updateAttachment) {
			// 해당 게시글 상세 페이지로 이동
		} else {
			// 에러 페이지
		}
		
	}

}
