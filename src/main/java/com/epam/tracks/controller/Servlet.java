package com.epam.tracks.controller;


import com.epam.tracks.builder.UserBuilder;
import com.epam.tracks.command.Command;
import com.epam.tracks.command.CommandFactory;
import com.epam.tracks.entity.User;
import com.epam.tracks.exception.CommandException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

       process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException{

        String command = request.getParameter("command");
        String page = null;

        try {
            if (command != null) {
                Command action = CommandFactory.create(command);
                page = action.execute(request, response);
               response.sendRedirect(request.getContextPath() + page);
            }
        }catch (CommandException | IOException ex){

        }

        if(command == null) {
            dispatch(request, response, page);
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException{
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }catch(IOException exception){
            request.setAttribute("ErrorMessage", exception.getMessage());
            page = "/errorPage.jsp";
        }
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
