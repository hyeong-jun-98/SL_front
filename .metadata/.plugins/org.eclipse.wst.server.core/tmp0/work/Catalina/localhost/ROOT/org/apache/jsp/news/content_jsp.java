/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-08-25 09:13:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.news;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.aca.web0812.domain.News;
import com.aca.web0812.news.model.NewsDAO;

public final class content_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {



NewsDAO newsDAO = new NewsDAO();


  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.aca.web0812.domain.News");
    _jspx_imports_classes.add("com.aca.web0812.news.model.NewsDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	int news_id = Integer.parseInt(request.getParameter("news_id"));	
	News news = newsDAO.select(news_id);

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<style>\r\n");
      out.write("body {font-family: Arial, Helvetica, sans-serif;}\r\n");
      out.write("* {box-sizing: border-box;}\r\n");
      out.write("\r\n");
      out.write("input[type=text], select, textarea {\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  padding: 12px;\r\n");
      out.write("  border: 1px solid #ccc;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("  box-sizing: border-box;	\r\n");
      out.write("  margin-top: 6px;\r\n");
      out.write("  margin-bottom: 16px;\r\n");
      out.write("  resize: vertical;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=button] {\r\n");
      out.write("  background-color: #04AA6D;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 12px 20px;\r\n");
      out.write("  border: none;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=button]:hover {\r\n");
      out.write("  background-color: #45a049;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container {\r\n");
      out.write("  border-radius: 5px;\r\n");
      out.write("  background-color: #f2f2f2;\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("}\r\n");
      out.write("#comments-list {\r\n");
      out.write("	border:1px solid red;\r\n");
      out.write("	overflow:hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#comments-list * {\r\n");
      out.write("	float:left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".title-style {\r\n");
      out.write("	width:80%;\r\n");
      out.write("}\r\n");
      out.write(".writer-style {\r\n");
      out.write("	width:10%;\r\n");
      out.write("}\r\n");
      out.write(".regdate-style {\r\n");
      out.write("	width:10%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("	// 댓글 목록 출력하기\r\n");
      out.write("function showCommentsListByString(jsonArray) {		// 댓글이 json 형식으로 받아옴\r\n");
      out.write("		console.log(\"넘겨받는 데이터 배열 크기\" , jsonArray.length);\r\n");
      out.write("	\r\n");
      out.write("		// 넘어온 데이터가 문자열이므로 객체처럼 사용할 수 없는 상태  제이슨 형식으로 바꾼다\r\n");
      out.write("		var data = JSON.parse(jsonArray);\r\n");
      out.write("		console.log(\"제이슨 객체 수\", data.length);\r\n");
      out.write("			\r\n");
      out.write("		// div 안의 컨텐츠를 js의 DOM을 이용하여 동적으로 출력해본다.\r\n");
      out.write("			var commentsList = document.getElementById(\"comments-list\");\r\n");
      out.write("		\r\n");
      out.write("		// 문자열로 취급하는 방법\r\n");
      out.write("		var tag=\"\";\r\n");
      out.write("		for(var i =0; i < data.length;i++) {\r\n");
      out.write("			tag += \"<div class=\\\"title-style\\\">짜짜라라짜짜짜 짜파게티~!</div>\";\r\n");
      out.write("			tag += \"<div class = \\\"writer-style\\\">리얼 개미</div>\";\r\n");
      out.write("			tag += \"<div class = \\\"regdate-style\\\">리얼 개미</div>\";\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("	\r\n");
      out.write("		commentsList.innerHTML=tag;\r\n");
      out.write("}\r\n");
      out.write("	\r\n");
      out.write("	// DOM 객체로 처리하는 방법\r\n");
      out.write("function showCommentsListByDom(jsonArray) {\r\n");
      out.write("		\r\n");
      out.write("		var data = JSON.parse(jsonArray);\r\n");
      out.write("		var commentsList = document.getElementById(\"comments-list\");\r\n");
      out.write("		\r\n");
      out.write("		// 출력전에 기존 요소들은 삭제하자\r\n");
      out.write("		commentsList.innerHTML=\"\";\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		for(var i = 0; i < data.length; i++) {\r\n");
      out.write("			var json = data[i];\r\n");
      out.write("			var div1 = document.createElement(\"div\");		// title-style\r\n");
      out.write("			var div2 = document.createElement(\"div\");		// writer-style\r\n");
      out.write("			var div3 = document.createElement(\"div\");		// regdate-style\r\n");
      out.write("			\r\n");
      out.write("			// 생성된 DOM 요소에 클래스 적용\r\n");
      out.write("			div1.className=\"title-style\";\r\n");
      out.write("			div2.className=\"writer-style\";\r\n");
      out.write("			div3.className=\"regdate-style\";\r\n");
      out.write("			\r\n");
      out.write("			// div안의 컨텐츠 구성\r\n");
      out.write("			div1.innerText=json.detail;\r\n");
      out.write("			div2.innerText=json.author;\r\n");
      out.write("			div3.innerText=json.writedate;\r\n");
      out.write("			\r\n");
      out.write("			// 조립\r\n");
      out.write("			commentsList.appendChild(div1);\r\n");
      out.write("			commentsList.appendChild(div2);\r\n");
      out.write("			commentsList.appendChild(div3);\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	// 비동기 요청\r\n");
      out.write("	function regist() {\r\n");
      out.write("		var xhttp = new XMLHttpRequest();\r\n");
      out.write("		var detail = document.getElementsByName(\"detail\")[0];\r\n");
      out.write("		var author = document.getElementsByName(\"author\")[0];\r\n");
      out.write("		xhttp.open(\"POST\",\"/comments/regist\");\r\n");
      out.write("		xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("		xhttp.send(\"detail=\" + detail.value + \"&author=\" + author.value+\"&news_id=");
      out.print(news_id);
      out.write("\");\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		xhttp.onreadystatechange=function() {\r\n");
      out.write("			if(this.readyState ==4 && this.status==200) {\r\n");
      out.write("				console.log(\"서버가 보낸 문자열 : \" + this.responseText);\r\n");
      out.write("				showCommentsListByDom(this.responseText);		// 출력함수로 전달\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	// 비동기 방식으로 댓글 목록 가져오기\r\n");
      out.write("function getComments() {\r\n");
      out.write("		\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url:\"/comments/list?news_id=");
      out.print(news_id);
      out.write("\",\r\n");
      out.write("		success:function(result) {	// result = responseText\r\n");
      out.write("			alert(result);\r\n");
      out.write("			showCommentsListByDom(result);\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("function del() {\r\n");
      out.write("	\r\n");
      out.write("	if(confirm(\"삭제?\")){\r\n");
      out.write("		location.href=\"/news/delete?news_id=");
      out.print(news_id);
      out.write("\";\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("function init() {\r\n");
      out.write("	\r\n");
      out.write("	getComments();\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onLoad=\"init()\">\r\n");
      out.write("\r\n");
      out.write("<h3>뉴스기사 상세보기</h3>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("  <form name =\"form1\">\r\n");
      out.write("    <input type=\"text\"  name=\"title\" value=\"");
      out.print(news.getTitle());
      out.write("\">\r\n");
      out.write("    <input type=\"text\"  name=\"writer\"  value=\"");
      out.print(news.getWriter());
      out.write("\">\r\n");
      out.write("    <textarea  name=\"content\" placeholder=\"내용 작성\" style=\"height:200px\"  >");
      out.print(news.getContent());
      out.write("</textarea>\r\n");
      out.write("\r\n");
      out.write("    <input type=\"button\" value=\"등록\" onClick = \"regist()\">\r\n");
      out.write("    <input type=\"button\" value=\"목록\" onClick = \"location.href = '/news/list.jsp'/\">\r\n");
      out.write("    <input type=\"button\" value=\"수정\" onClick = \"edit()\">\r\n");
      out.write("    <input type=\"button\" value=\"삭제\" onClick = \"del()\">\r\n");
      out.write("  </form>\r\n");
      out.write("  <form name =\"form2\">\r\n");
      out.write("  	<input type = \"text\" name = \"detail\" placeholder=\"댓글내용...\" style=\"width:75%\">\r\n");
      out.write("  	<input type = \"text\" name = \"author\" placeholder=\"작성자...\" style =\"width:10%\">\r\n");
      out.write("  	<input type = \"button\" value = \"댓글등록\" onClick=\"regist()\">\r\n");
      out.write("  \r\n");
      out.write("  </form>\r\n");
      out.write("	<div id=\"comments-list\">\r\n");
      out.write("	\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	</div>  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
