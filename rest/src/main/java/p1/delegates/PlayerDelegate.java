package p1.delegates;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p1.services.PlayerService;
import p1.services.PlayerServiceImpl;
import p1.testmodels.Player;

public class PlayerDelegate implements FrontControllerDelegate {
	private ObjectMapper objMapper = new ObjectMapper();
	private PlayerService playerServ = new PlayerServiceImpl();
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getMethod();

		switch (method) {
		case "GET":
			get(req, resp);
			break;
		case "POST":
			post(req, resp);
			break;
		case "PUT":
			put(req, resp);
			break;
		case "DELETE":
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			break;
		default:
		}
	}

	private void put(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		
		
	}

	private void post(HttpServletRequest req, HttpServletResponse resp) throws StreamReadException, DatabindException, IOException {
		Player playerObj = new Player();
		
		String path = (String) req.getAttribute("path");
		if (path==null || "".equals(path)) {
			Player player = objMapper.readValue(req.getInputStream(), Player.class);
			if (player!=null) {
				player = playerServ.addPlayer(playerObj);
				resp.getWriter().write(objMapper.writeValueAsString(playerObj));
			} else {
				resp.sendError(400, "The request body was empty.");
			}
		} else {
			resp.sendError(400, "Cannot POST to this URI. Try sending the request to /pets.");
		}
	}

	private void get(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		// TODO Auto-generated method stub
		Player playerObj = new Player();
		String path = (String) req.getAttribute("path");
		if (path==null || "".equals(path)) {
			resp.getWriter().write(objMapper.writeValueAsString(playerServ.viewAllPlayers(playerObj)));
		} else {
			try {
				int id = Integer.valueOf(path);
				playerObj.setId(id);
				Player player = playerServ.viewPlayerById(playerObj);
				if (player!=null) {
					resp.getWriter().write(objMapper.writeValueAsString(player));
				} else {
					resp.sendError(404, "Player with that ID not found.");
				}
			} catch (NumberFormatException e) {
				resp.sendError(400, e.getMessage());
			}
		}
		
	}

}
