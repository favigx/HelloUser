package com.HelloUser.HelloUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberinfoController {

    @GetMapping("/member/{memberName}")
    String getMember(@PathVariable String memberName, Model model){
         
        for (Members member : MembersController.members){
            if(member.getName().equals(memberName)) {
                model.addAttribute("member", new Members(member.getName(), member.getAge(), member.getEmail(), member.getId()));
                return "member";
            }
        }
        return "member";
    }
}