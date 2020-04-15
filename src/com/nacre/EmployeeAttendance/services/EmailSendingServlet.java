package com.nacre.EmployeeAttendance.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttandance.model.EmailUtility;
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private String host = "smtp.gmail.com";
	private String port = "587";
	private String user = "satyabratedu@gmail.com";
	private String pass = "********";
	private static final long serialVersionUID = 1L;
	public EmailSendingServlet() {
		super();
	}
        public void init() {
            ServletContext context = getServletContext();
            host = context.getInitParameter("host");
            port = context.getInitParameter("port");
            user = context.getInitParameter("user");
            pass = context.getInitParameter("pass");
        }
     
        protected void doPost(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
            // reads form fields
            String recipient = request.getParameter("recipient");
            String subject = request.getParameter("subject");
            String content = request.getParameter("content");
     
            String resultMessage = "";
     
            try {
                EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                        content);
                resultMessage = "The e-mail was sent successfully";
            } catch (Exception ex) {
                ex.printStackTrace();
                resultMessage = "There were an error: " + ex.getMessage();
            } finally {
                request.setAttribute("Message", resultMessage);
                getServletContext().getRequestDispatcher("/Result.jsp").forward(
                        request, response);
            }
        }

}
