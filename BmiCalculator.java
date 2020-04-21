package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Student;;

/**
 * Servlet implementation class BmiCalculator
 */
@WebServlet("/BmiCalculator")
public class BmiCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmiCalculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Formula for calculating bmi 
		1. Multiply the weight in pounds by 0.45
		2. Multiply the height in inches by 0.025
		3. Square the answer from step 2
		4. Divide the answer from step 1 by the answer from step 3
		*/
		
		String weightStr = request.getParameter("weight");
		String heightStr = request.getParameter("height");
		
		double weight = Double.parseDouble(weightStr);
		double height = Double.parseDouble(heightStr);
		
		double bmi = weight * height;
	
		
		HttpSession session = request.getSession(true);
		Student student = (Student)session.getAttribute("student");
		
		student.setBmi(bmi);
		
		session.setAttribute("student", student);
		 
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
