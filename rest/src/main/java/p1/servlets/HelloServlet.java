package p1.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// our servlets should extend HttpServlet
public class HelloServlet extends HttpServlet {
	// the servlet container (tomcat catalina) will call this method when
	// a GET request comes in to the right path and it will create the objects
	// for the request and response and pass those in
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// gets the response body writer object so that we can write to the response
		// body

		StringBuilder uriString = new StringBuilder(req.getRequestURI()); // /p1/hello/id
		uriString.replace(0, req.getContextPath().length() + 1, "");

		// if there is a slash
		if (uriString.indexOf("/") != -1) {
			uriString.replace(0, uriString.indexOf("/") + 1, ""); // 6
			
			String path = uriString.toString();
			
			if(path.equals("html")) {
				PrintWriter writer = resp.getWriter();
				writer.write(html);
			}else {
				PrintWriter writer = resp.getWriter();
				writer.write("Path: " + path);
			}
		} else {
			// gets the response body writer object so that we can write to the response
			// body
			PrintWriter writer = resp.getWriter();
			writer.write("Hello! :)");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String language = req.getParameter("language");

		// this gets a reader that will read the HTTP request body
		BufferedReader reader = req.getReader();

		String requestBody = "";
		String line = "";
		while ((line = reader.readLine()) != null) {
			requestBody += line;
		}

		PrintWriter writer = resp.getWriter();

		if (language == null)
			language = "";
		switch (language) {
		case "en":
			writer.write("Hello, " + requestBody + "! :)");
			break;
		case "fr":
			writer.write("Bonjour, " + requestBody + "! :)");
			break;
		case "es":
			writer.write("Hola, " + requestBody + "! :)");
			break;
		default:
			writer.write(requestBody + "! :)");
		}

	}

	static String html = "<html>" + "<head>" + "<title>AHHH RECIPES</title>" + "<style>" + "body{"
			+ "background-color: #96bf9e;" + "}" + "</style>" + "</head>" + "<body>"
			+ "<table width=\"960\" cellpadding=\"12\" cellsapcing=\"5\" border=\"1\" align=\"center\">" + "<tr>"
			+ "<td bgcolor=\"#96a6bf\" colspan=\"2\" align=\"center\">"
			+ "<h1>My<font color=\"blue\">Cookbook!</font></h1></td></tr>" + "<tr>"
			+ "<td bgcolor=\"#bfb096\" width=\"25%\"><h4>Hello</4></td>"
			+ "<td bgcolor=\"#2196f3\" width=\"75%\"><b>Test test test</b></td>" + "</tr>" + "</table>" + "</body>"
			+ "</html>";
}