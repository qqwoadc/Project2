package com.cskaoyan.controller;



import com.cskaoyan.service.UserService;
import com.cskaoyan.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Mycontroller {

    @Autowired
    UserService service;


    @RequestMapping("login.do")
    public void login(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {


        User userByNameAndWord = service.findUserByNameAndWord(user);
        request.setAttribute("user",userByNameAndWord);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @RequestMapping("registervalid.do")
    public String usernamevalid(Model model,String username){

        boolean userNameValid = service.isUserNameValid(username);

        if (userNameValid){

            model.addAttribute("msg","useful");

        }else {
            model.addAttribute("msg","alreadyExist");

        }
        return "register.jsp";
    }

    @RequestMapping("register.do")
    public String register(Model model,User user){

        int i = service.addUser(user);
        if (i==1){

            model.addAttribute("user",user);
            return "index.jsp";
        }
        else
            return "register.jsp";
    }

    @RequestMapping("update.do")
    public String updateUser(User user){

        int i = service.updateUser(user);

        if (i==1){


            return "index.jsp";
        }else
            return "error.jsp";

    }
}
