<%@page import="java.util.List"%>
<%@page import="com.academy.web0829.emp.repository.EmpDAO"%>
<%@page import="com.academy.web0829.domain.Emp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%! EmpDAO empDAO = new EmpDAO(); %>
    <%
    List <Emp>empList = empDAO.selectAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1px">
	
		<tr>
		<td>empno</td>
		<td>ename</td>
		<td>job</td>
		<td>mgr</td>
		<td>hiredate</td>
		<td>sal</td>
		<td>comm</td>
		<td>deptno</td>
		<td>dname</td>
		<td>loc</td>

		</tr>
		<%for(int i = 0; i < empList.size(); i++) { %>
		
		<% Emp emp = empList.get(i);%>
		
		<tr>
		<td><%=emp.getEmpno() %></td>
		<td><%=emp.getEname() %></td>
		<td><%=emp.getJob() %></td>
		<td><%=emp.getMgr() %></td>
		<td><%=emp.getHiredate() %></td>
		<td><%=emp.getSal() %></td>
		<td><%=emp.getComm() %></td>
		<td><%=emp.getDept().getDeptno() %></td>
		<td><%=emp.getDept().getDname() %></td>
		<td><%=emp.getDept().getLoc() %></td>
		</tr>
		
		<%} %>
		
		
		
	
	</table>

</body>
</html>