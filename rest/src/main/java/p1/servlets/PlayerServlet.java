package p1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p1.services.PlayerService;
import p1.services.PlayerServiceImpl;
import p1.testmodels.*;

public class PlayerServlet extends HttpServlet {

	private PlayerService playerServ = new PlayerServiceImpl();
	private ObjectMapper objMapper = new ObjectMapper();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get available pets
		
		Player testObj = new Player();
		
		Player players = playerServ.viewAllPlayers(testObj);
		
		PrintWriter writer = resp.getWriter();
		
		// the object mapper writes the pets list as a JSON string to the response body
		writer.write(objMapper.writeValueAsString(players));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// add pet
		// reading the request body and parsing it into a Pet object from the JSON string
		Player players  = objMapper.readValue(req.getInputStream(), Player.class);
		
		playerServ.addPlayer(players);
		System.out.println(players);
	}
}
