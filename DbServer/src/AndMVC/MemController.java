package AndMVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDTO.MemberDTO;
import jdbc.MemberDAO;

/**
 * Servlet implementation class MemController
 */
@WebServlet("/andController.do")
//MemController 이거는 웹
public class MemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html");

		String category = request.getParameter("category");
		String vUrl = request.getContextPath();
		System.out.println(vUrl);
		PrintWriter out = response.getWriter();
		out.print("/Apple");

		if (category != null) {
			if (category.equals("frmHom")) {
				System.out.println("로그인 진입");
				out.print("Memcontroller Access at  \"frmHom\" approach");
				
				
				
				
			}else if (category.equals("frmLog")) {
				System.out.println("로그인진입");
				out.print("Memcontroller Access at  \"frmLog\" approach");
				

				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();	
				dto.setMem_id(request.getParameter("mem_id"));
				dto.setMem_pwd(request.getParameter("mem_pwd"));
				
				int flag =dao.memLogin(dto);




				if (flag ==1 ) {
					System.out.println("로그인 성공");
					request.setAttribute("msg", dto.getMem_id());
					System.out.println(request.getAttribute("msg"));
					RequestDispatcher rd = request.getRequestDispatcher("indexT.jsp");
					rd.forward(request, response);

				}else {
					System.out.println("로그인 실패");
				}
				
				
				
			}else if(category.equals("frmIns")){ // 회원가입 입력후 넘어옴
				System.out.println("ins진입");
				out.print("Memcontroller Access at  \"frmIns\" approach");				

				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();	
				dto.setMem_name(request.getParameter("mem_name"));
				dto.setMem_id(request.getParameter("mem_id"));
				dto.setMem_pwd(request.getParameter("mem_pwd"));
				dto.setMem_email(request.getParameter("mem_email"));  
				dto.setMem_phone(request.getParameter("mem_phone"));
				dto.setMem_addr(request.getParameter("mem_addr"));

				int flag =dao.memInsert(dto);




				if (flag > 0) {
					System.out.println("회원가입 정상 처리 완료");
					request.setAttribute("msg", dto.getMem_id());
					System.out.println(request.getAttribute("msg"));
					RequestDispatcher rd = request.getRequestDispatcher("indexT.jsp");
					rd.forward(request, response);

				}else {
					System.out.println("회원가입 처리 실패");
				}
				

			}else if(category.equals("frmUpd")){
				System.out.println("update진입");

				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();	
				dto.setMem_name(request.getParameter("mem_name"));
				dto.setMem_id(request.getParameter("mem_id"));
				dto.setMem_pwd(request.getParameter("mem_pwd"));
				dto.setMem_email(request.getParameter("mem_email"));  
				dto.setMem_phone(request.getParameter("mem_phone"));
				dto.setMem_addr(request.getParameter("mem_addr"));

				int flag =dao.memUpdate(dto);




				if (flag > 0) {
					System.out.println("회원수정 처리 완료");
					request.setAttribute("msg", dto.getMem_id());
					System.out.println(request.getAttribute("msg"));
					RequestDispatcher rd = request.getRequestDispatcher("indexT.jsp");
					rd.forward(request, response);

				}else {
					System.out.println("회원수정 처리 실패");
				}
				

			}else if(category.equals("frmDel")){
				System.out.println("delete진입");
				out.print("Memcontroller Access at  \"frmDel\" approach");
				

				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();	
				dto.setMem_id(request.getParameter("mem_id"));
				dto.setMem_pwd(request.getParameter("mem_pwd"));

				int flag =dao.memDelete(dto);
				
				if (flag > 0) {
					System.out.println("회원삭제 처리 완료");
					request.setAttribute("msg", dto.getMem_id());
					System.out.println(request.getAttribute("msg"));
					RequestDispatcher rd = request.getRequestDispatcher("indexT.jsp");
					rd.forward(request, response);

				}else {
					System.out.println("회원삭제 처리 실패");
				}
			}else if(category.equals("mvcSel")){
				MemberDAO dao = new MemberDAO();	
				ArrayList<MemberDTO> dtoL = dao.memSelect();
				System.out.println(dtoL.get(0));
				
				request.setAttribute("dtoL", dtoL);
				RequestDispatcher rd = request.getRequestDispatcher("memSelect.jsp");
				rd.forward(request, response);
			}
		}
	}


	public void move(HttpServletRequest request, HttpServletResponse response, String url){
		RequestDispatcher dis = request.getRequestDispatcher(url);
		try {
			dis.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
