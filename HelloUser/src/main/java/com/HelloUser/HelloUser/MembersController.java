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
        members.add(new Members("James", 31, "james.j@gmail.com", 1));
        members.add(new Members("Joey", 39, "joey.j@gmail.com", 2));
        members.add(new Members("Chandler", 40, "chandler.c@gmail.com", 3));
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
        //model.addAttribute("members", members);
        model.addAttribute("newMember", new Members(null, 0, null, 0));
        return "addmember";
    }

    @PostMapping("/addperson")
    String newMember(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email) {
        members.add(new Members(name, age , email, members.size() +1));
        return "redirect:/addmember";
    } 
}