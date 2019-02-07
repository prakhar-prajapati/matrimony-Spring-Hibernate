package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bean.userBean;
import dao.MyDao;

@Controller
@SessionAttributes("uid")
public class MainController {
    @RequestMapping("/")
    public ModelAndView Home()
    {
     ModelAndView mv=new ModelAndView("Home");
     //mv.addObject("msg","Admin login page");
     return mv;
    }

    @RequestMapping("/registration")
    public ModelAndView registration()
    {
     ModelAndView mv=new ModelAndView("registration");
     //mv.addObject("msg","Admin login page");
     return mv;
    }
    
    @RequestMapping("/userHome")
    public ModelAndView userHome()
    {
     ModelAndView mv=new ModelAndView("userHome");
     return mv;
    }
    
    @RequestMapping("/profile")
    public ModelAndView profile(HttpSession session)
    { 
    	 MyDao obj=new MyDao();
    	String email=(String) session.getAttribute("uid");
    	System.out.println( "session= "+email);
    	 String gender=obj.getGender(email);
    			 ModelAndView mv=new ModelAndView("userHome");
    			  mv.addObject("uid",email);
    			  ArrayList<userBean> list=obj.ShowData(gender);
    			 	mv.addObject("LIST",list);
    			  return mv;
    }
    
    
    
    
    @RequestMapping("/login")
    public ModelAndView login()
    {
     ModelAndView mv=new ModelAndView("userLogin");
     //mv.addObject("msg","Admin login page");
     return mv;
    }

        @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(@RequestParam String email,@RequestParam String password)
    {   
        	ModelAndView mv=null;
    MyDao obj=new MyDao();
    	int x=obj.loginCheck(email, password);
	 if(x==1)
	  {   
		// String gender=obj.getGender(email);
		// System.out.println(gender);
		 
		 mv=new ModelAndView("ClientHome");
		  mv.addObject("uid",email);
		//  ArrayList<userBean> list=obj.ShowData(gender);
		 //	mv.addObject("LIST",list);
		 // return mv;
	  }else if(x==0)
	  {
		 mv=new ModelAndView("userLogin");
		  mv.addObject("msg","Login failed , try again...");
		  //return mv;
	  }
	 return mv;
    }
    
    
    @RequestMapping("/insertUserDetails")
    public ModelAndView Insert(@ModelAttribute userBean e)
    {
//    	MyDao obj=new MyDao();
//    	int x=obj.insert(e);
//	 if(x==1)
//	 {
//  ModelAndView mv=new ModelAndView("registration");
//  mv.addObject("msg","Data inserted....");
//  return mv;
//	 }
//	 else
//	 {
//		 ModelAndView mv=new ModelAndView("registration");
//        mv.addObject("msg","Data insert failed");
//        return mv;    
//	 }
    	MyDao obj=new MyDao();
    	ModelAndView mv=new ModelAndView("registration");
   	  int x=obj.Insert(e);
 	   if(x==1) {
 	   //System.out.println("Data Inserted");
 	  mv.addObject("msg","Data inserted....");
 	   }else {
 		//  ModelAndView mv=new ModelAndView("registration");
 	 	  mv.addObject("msg","Data not inserted....");
 	 	 		}
 	  return mv;
 	  }
    
}
