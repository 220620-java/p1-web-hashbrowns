package p1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p1.models.*;

public class CookServlet extends HttpServlet {

	static ObjectMapper objMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cook cook = new Cook();
		
		cook.setName("Chef Ramsay");
		cook.setUsername("hellskitchen76");
		cook.setPassword("secret");
		cook.setId(40);
		cook.setRecipes(null);

		PrintWriter writer = resp.getWriter();

		writer.write(objMapper.writeValueAsString(cook));

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cook exampleCook = objMapper.readValue(req.getInputStream(), Cook.class);
		
		System.out.println("ID=" + exampleCook.getId() + " NAME=" + exampleCook.getName() + " USER=" + exampleCook.getUsername() + " PASS=" + exampleCook.getPassword() + " RECIPES[]=" + exampleCook.getRecipes());
		
		String pretty = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(exampleCook);
		System.out.println(pretty);
	}

}
