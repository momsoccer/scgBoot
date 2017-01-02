package com.scg.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping(value = "home")
    public String home(Model model,
                       HttpServletRequest request){

        HttpSession session = request.getSession();
        String useremail = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("useremail", useremail);

        return "/member/home";
    }


}
