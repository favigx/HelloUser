package com.HelloUser.HelloUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MembersController {
    static final List<Members> members = new ArrayList<>();

    static {
        members.add(new Members("Karl", "Karlsson", "karl.karlsson@gmail.com", "Stockholm", 1));
        members.add(new Members("Mats", "Matsson", "mats.matsson@gmail.com", "Malmö", 2));
        members.add(new Members("Per", "Persson", "per.persson@gmail.com", "Göteborg", 3));
    }

    @GetMapping("/members")
    String getMembers(Model model){
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/remove-member/{memberId}")
    String removeMember(@PathVariable int memberId){
        System.out.println("RemovePerson " + memberId);
        members.removeIf(member -> member.getId() == memberId);
        return "redirect:/members";
    }
   
    @GetMapping("/addmember")
    String addMember(Model model){
        model.addAttribute("newMember", new Members(null, null, null, null, 0));
        return "addmember";
    }

    @PostMapping("/addperson")
    String newMember(@RequestParam("fName") String fName, @RequestParam("lName") String lName, @RequestParam("email") String email, @RequestParam("stad") String stad) {
        members.add(new Members(fName, lName, email, stad, members.size() +1));
        return "redirect:/addmember";
    }

    @GetMapping("/member/{memberName}")
    String getMember(@PathVariable String memberName, Model model){
         
        for (Members member : MembersController.members){
            if(member.getfName().equals(memberName)) {
                model.addAttribute("member", new Members(member.getfName(), member.getlName(), member.getEmail(), member.getStad(), member.getId()));
                return "member";
            }
        }
        return "member";
    }
}