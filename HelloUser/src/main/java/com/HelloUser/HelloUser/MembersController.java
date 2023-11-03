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

    // Mock-data som jag väljer att ha kvar för visa hur det kan se ut
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
        members.add(new Members(fName, lName, email, stad, members.size() +1*2));     // Jag valde att lägga till '*2' pågrund av ett problem med
        return "redirect:/addmember";                                                 // ta-bort funktionen då 'id' i vissa fall blir lika som en existerande medlem,
    }                                                                                 // vilket medför att båda med samma id tas bort när man väljer att ta bort en medlem. 
                                                                                      // På det här sättet tror jag att jag har löst det problemet.

    @GetMapping("/member/{memberfname}")
    String getMember(@PathVariable String memberfname, Model model){
         
        for (Members member : MembersController.members){
            if(member.getfName().equals(memberfname)) {
                model.addAttribute("member", new Members(member.getfName(), member.getlName(), member.getEmail(), member.getStad(), member.getId()));
                return "member";
            }
        }
        return "member";
    }
}