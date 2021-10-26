package com.example.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.User;
import com.example.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SignUpController {
	
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);

	public static void signUp(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//To read in stringified JSON data from a POST request is a little more complicated than reading form data
				StringBuilder buffer = new StringBuilder();
				
				System.out.println("hello from signup controller");
				
				//The buffered reader will read the json data line by line
				BufferedReader reader = req.getReader();
				
				String line;
				while((line = reader.readLine()) != null) {
					buffer.append(line);
					buffer.append(System.lineSeparator());
				}
				
				String data = buffer.toString();
				System.out.println(data);
				
				ObjectMapper mapper = new ObjectMapper();
				JsonNode parsedObj = mapper.readTree(data);
				System.out.println(parsedObj);
				String username = parsedObj.get("username").asText();
				String password = parsedObj.get("password").asText();
				String firstname = parsedObj.get("firstName").asText();
				String lastname = parsedObj.get("lastName").asText();
				String email=parsedObj.get("email").asText();
				int roleId=parsedObj.get("rollid").asInt();
				
				
				
					
					try {
						System.out.println("In the post handler");
						User u = uServ.signUp(username, password,firstname,lastname,email,roleId);
						System.out.println(u);
						//We will keep track of if a user is signed in by storing their id in the session
						req.getSession().setAttribute("id", u.getUserId());
						res.setStatus(200);
						res.getWriter().write(new ObjectMapper().writeValueAsString(u));
					} catch(Exception e) {
						res.setStatus(403);
						res.getWriter().println("Username or password incorrect");
					}
				
			}
		
	}

			
