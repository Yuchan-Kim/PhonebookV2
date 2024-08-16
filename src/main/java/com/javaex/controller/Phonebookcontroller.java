package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.phonebookDao;
import com.kavaex.vo.PersonVO;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/pbc")
public class Phonebookcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Action이란? 
		String action = request.getParameter("action");
		System.out.println(action);
		
		phonebookDao phonebookDao = new phonebookDao();
		
		if("list".equals(action)) {
			//db데이터 가져오기 
			System.out.println("List Page");
			
			List<PersonVO> personList = phonebookDao.getPersonList();
			
			//화면그리기 --> 포워드 (request, response 를 jsp로 옮기는 작업)
			//request는 parameter, attribute
			request.setAttribute("personList",personList); //앞 스트링은 이름을 지어주는 역할, 넘어온 주소값에 이름 부여.
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp"); //이쪽으로 리퀘스트에서 얻은값을 보낸다, 밖에서 접속 불가
			rd.forward(request, response);  
		}else if ("registration".equals(action)) {
			//db데이터 가져오기 
			System.out.println("Registration Page");
			
			//Forward
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			rd.forward(request,response);
		}else if ("insert".equals(action)) {
			
			System.out.println("등록 요청 데이터 저장.");
			
			//파라미터 꺼내기
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVO newPerson = new PersonVO(name,hp,company);
			
			
			//Send data to DAO
			phonebookDao.insertPerson(newPerson);
			/*
			//request는 parameter, attribute
			request.setAttribute("personList",personList); //앞 스트링은 이름을 지어주는 역할, 넘어온 주소값에 이름 부여.
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp"); //이쪽으로 리퀘스트에서 얻은값을 보낸다.
			rd.forward(request, response);  
			*/
			
			//redirect
			response.sendRedirect("http://localhost:8080/phonebook/pbc?action=list");
			
		}else if ("editform".equals(action)) {
			int no = Integer.parseInt(request.getParameter("no"));
			PersonVO personVO = phonebookDao.getPerson(no);
			
			request.setAttribute("personVO", personVO);
			
			RequestDispatcher rd  =request.getRequestDispatcher("/WEB-INF/editForm.jsp");
			rd.forward(request, response);
			
		}else if ("update".equals(action)) {
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVO personVO = new PersonVO(no,name,hp,company);
			
			
		}else if("delete".equals(action)){
			System.out.println("delete action");
			int no = Integer.parseInt(request.getParameter("no"));
			
			phonebookDao.deletePerson(no);
			
			
			
		}else
			System.out.println("action 없음");
		}
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
