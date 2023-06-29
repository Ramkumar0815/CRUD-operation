package org.jsp.usermvcapp.controller;

import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.jsp.usermvcapp.dao.UserDao;

import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
@Autowired
private UserDao dao;

@RequestMapping("/save")
public ModelAndView saveUser(@ModelAttribute User u,ModelAndView view)
{
	u=dao.saveUser(u);
	view.setViewName("print.jsp");
view.addObject("msg", "User registered with id:"+u.getId());
return view;
}

@RequestMapping("/update")
public ModelAndView updateUser(@ModelAttribute User u,ModelAndView view)
{
	u=dao.updateUser(u);
	view.setViewName("print.jsp");
view.addObject("msg", "User registered");
return view;
}
@RequestMapping("/fetch")
public ModelAndView fetchUser(@RequestParam int id,ModelAndView view)
{
	User u=dao.fetchByid(id);
	if(u!=null)
	{
		view.addObject("u", u);
		view.setViewName("viewuser.jsp");
		return view;
	}
	view.setViewName("print.jsp");
	view.addObject("msg", "invalid User id");
	return view;
}

@RequestMapping("/delete")
public ModelAndView deleteUser(@RequestParam int id,ModelAndView view)
{
	boolean u=dao.deleteUser(id);
	view.setViewName("print.jsp");
	view.addObject("msg", "deleted the candidate details");
	return view;
}

}