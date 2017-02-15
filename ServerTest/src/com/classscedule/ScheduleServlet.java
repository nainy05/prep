package com.classscedule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScheduleServlet
 */
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScheduleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName = request.getParameter("title");
		String[] days = request.getParameterValues("day");
		int starttime = Integer.parseInt(request.getParameter("starttime"));
		int endtime = Integer.parseInt(request.getParameter("endtime"));

		SchoolSchedule schoolSchedule = (SchoolSchedule) request.getSession().getAttribute("schoolSchedule");

		if (schoolSchedule == null)
			schoolSchedule = new SchoolSchedule();

		for (int i = 0; i < days.length; i++) {
			int day;
			switch (days[i]) {
			case "sun":
				day = 0;
				break;
			case "mon":
				day = 1;
				break;
			case "tue":
				day = 2;
				break;
			case "wed":
				day = 3;
				break;
			case "thur":
				day = 4;
				break;
			case "fri":
				day = 5;
				break;
			default:
				day = 6;
			}
			SchoolClass schoolClass = new SchoolClass(courseName, starttime, endtime, day);
			schoolSchedule.addClass(schoolClass);
		}

		/*
		 * When you use request.setAttribute, you store something for the same
		 * request object. You can use this attribute later on when you do a
		 * forward from your current servlet/jsp to some other servlet/jsp.
		 * 
		 * When you use request.getSession().setAttribute(), you store something
		 * for that partiular user session. You can use this attribute whenever
		 * you want if the user session has not expired.
		 */
		request.getSession().setAttribute("schoolSchedule", schoolSchedule);

		/*
		 * RequestDispatcher interface provides the facility of dispatching the
		 * request to another resource it may be html, servlet or jsp
		 */
		getServletContext().getRequestDispatcher("/Schedule.jsp").forward(request, response);

	}

}
