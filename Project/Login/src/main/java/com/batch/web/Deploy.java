package com.batch.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.batch.model.GetMember;
import com.batch.model.PostMember;

public class Deploy extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = req.getParameter("name");
		String usn = req.getParameter("usn");
		String sem = req.getParameter("sem");
		String sub1 = req.getParameter("subject1");
		String credits1 = req.getParameter("credits1");
		String sub2 = req.getParameter("subject2");
		String credits2 = req.getParameter("credits2");
		String sub3 = req.getParameter("subject3");
		String credits3 = req.getParameter("credits3");
		String sub4 = req.getParameter("subject4");
		String credits4 = req.getParameter("credits4");
		
		int credit1 = Integer.parseInt(credits1);
		int credit2 = Integer.parseInt(credits2);
		int credit3 = Integer.parseInt(credits3);
		int credit4 = Integer.parseInt(credits4);
		
		int sub1m = Integer.parseInt(sub1);
		int sub2m = Integer.parseInt(sub2);
		int sub3m = Integer.parseInt(sub3);
		int sub4m = Integer.parseInt(sub4);
		
		int creditSum = credit1 + credit2 + credit3 + credit4;
		float creditSUmTotal = credit1*sub1m + credit2*sub2m + credit3*sub3m + credit4*sub4m;
		float sgpa = creditSUmTotal/creditSum;
		System.out.println(sgpa);
		
		PostMember member = new PostMember(name, usn, sem, sgpa);
		PostDao la = new PostDao();
		int out = la.post(member);
		if(out == 1) {
			resp.getWriter().print("Data sent to db");
		}
		else if(out == 0){
			resp.getWriter().print("Error db");
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usn = req.getParameter("usn");
		String sem = req.getParameter("sem");
		
		GetMember gm = new GetMember(usn, sem);
		PostDao la = new PostDao();
		PostMember po = la.get(gm);
				if(po != null) {
					usn = po.getUsn();
					String name = po.getName();
					float sgpa = po.getSgpa();
					
					resp.getWriter().println("<table border=1><tr>" + "<td><b>Name</b></td>" + "<td><b>USN</b></td>" + "<td><b>SGPA</b></td></tr>"); 
					resp.getWriter().println("<tr>" + "<td>" + name + "</td>" + "<td>" + usn + "</td>" + "<td>" + sgpa +  "</td></tr>");la.get(gm);
				}
				else {
					resp.getWriter().println("DATA NOT FOUND");
				}
				
	}
	
}