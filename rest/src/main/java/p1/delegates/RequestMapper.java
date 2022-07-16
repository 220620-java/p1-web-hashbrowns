package p1.delegates;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestMapper {
	
	private Map<String, FrontControllerDelegate> delegateMap;
	
	{
		delegateMap = new HashMap<>();
		
		// add each delegate with its path
		delegateMap.put("players", new PlayerDelegate());
	}
	
	public FrontControllerDelegate map(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// if the request is an OPTIONS request, i'll just return
		// an empty delegate
		if ("OPTIONS".equals(req.getMethod())) {
			// this lambda is an implementation of FrontControllerDelegate
			// because it's a functional interface, so it's just an implementation
			// that does nothing when "handle" is called
			return (req1, resp1) -> {};
		}
		
		// if it's NOT an OPTIONS request:
		StringBuilder uriString = new StringBuilder(req.getRequestURI()); // /pet-app1/hello/6
		uriString.replace(0, req.getContextPath().length()+1, ""); // hello/6
		
		// if there is a slash
		if (uriString.indexOf("/") != -1) {
			// before i remove path parameters, i want to save them
			req.setAttribute("path", uriString.substring(uriString.indexOf("/")+1));
			
			// now we can remove the path parameters if they are there
			uriString.replace(uriString.indexOf("/"), uriString.length(), ""); // hello
		}
		
		return delegateMap.get(uriString.toString());
	}
	
}
