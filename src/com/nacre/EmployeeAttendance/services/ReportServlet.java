package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.nacre.EmployeeAttendance.factory.DbCon;
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReportServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  ServletOutputStream os = response.getOutputStream();
		  response.setContentType("application/pdf"); 
		  Document doc = new Document();
		  Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0)); 
		  Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, new BaseColor(0, 0, 0)); 
		  Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
		  PreparedStatement pst = null;
		  try{
		   PdfWriter.getInstance(doc, os); 
		   doc.addCreationDate();
		   doc.addProducer();
		   doc.addTitle("Report Pdf");
		   doc.setPageSize(PageSize.LETTER);
		   doc.open();
		   doc.add( new Paragraph("Employee Reports", bfBold18));
		   Connection conn=DbCon.GetConnection();
		   String sql1="  select emp_name,dept_name,emp_sex,emp_job,emp_salary, dept_loc"
		   		+ " from emp,dept where emp.dept_no=dept.dept_no and emp_no=?";
		   pst = conn.prepareStatement(sql1);
		   int empno=Integer.parseInt(request.getParameter("empno"));
		   pst.setInt(1,empno);
		   ResultSet rs = pst.executeQuery();  
		   while(rs.next()){ 
		    Paragraph countryParagraph = new Paragraph();
		    Anchor anchor = new Anchor();
		    countryParagraph.add(anchor);
		    doc.add(countryParagraph);
		    doc.add( new Paragraph("Name: " + rs.getString("emp_name").trim(), bf12));
		    doc.add( new Paragraph("Department: " + rs.getString("dept_name").trim(), bf12));
		    doc.add( new Paragraph("Gender: " + rs.getString("emp_sex").trim(), bf12));
		    doc.add( new Paragraph("Job: " + rs.getString("emp_job").trim(), bf12));
		    doc.add( new Paragraph("Salary: " + rs.getInt("emp_salary"), bf12));
		    doc.add( new Paragraph("Dept.Location: " +rs.getString("dept_loc").trim(), bf12));
		   }
		 
		   rs.close();                                                                
		   pst.close();                                                              
		   pst = null;                                                               
		 
		   conn.close();                                                              
		   conn = null;                                                    
		 
		 
		   doc.close(); 
		 
		  }catch(DocumentException e){
		   e.printStackTrace();
		  }
		  catch(Exception e){
		   e.printStackTrace();
		  }
		 
		 }
		 
		}
