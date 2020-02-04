package com.clubmanage.ClubDemo.Controller;

import com.clubmanage.ClubDemo.Pojo.Club;
import com.clubmanage.ClubDemo.Pojo.DBRetMsg;
import com.clubmanage.ClubDemo.Service.clubService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
public class ClubController {
    @Autowired
    private clubService clubService;


    @RequestMapping(value = "/index")
    String selectClubAll(Model model) {
        List<Club> list = clubService.selectClubAll();
        model.addAttribute("Club", list);
        model.addAttribute("clubInfo", new Club());

        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/addClub", method = RequestMethod.POST)
    DBRetMsg addClub(@Valid @RequestBody Club club, BindingResult result, Model model) {
        DBRetMsg dbRetMsg = new DBRetMsg();
        HashMap<String, String> map = new HashMap<>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            dbRetMsg.setMsg(map);
            dbRetMsg.setStatus(false);
        } else {
            clubService.addClub(club);
            dbRetMsg.setMsg(map);
            dbRetMsg.setStatus(true);
        }
        return dbRetMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/updateClub", method = RequestMethod.POST)
    DBRetMsg updateClub(@RequestBody Club club) {
        clubService.updateClub(club);
        HashMap<String, String> hashMap = new HashMap<String, String>() {
        };
        hashMap.put("修改成功！", "");
        DBRetMsg dbRetMsg = new DBRetMsg(true, hashMap);
        return dbRetMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteClub", method = RequestMethod.POST)
    DBRetMsg deleteClub(@RequestParam(name = "id") Integer id) {
        clubService.deleteClub(id);
        HashMap<String, String> hashMap = new HashMap<String, String>() {
        };
        hashMap.put("删除成功！", "");
        DBRetMsg dbRetMsg = new DBRetMsg(true, hashMap);
        return dbRetMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/findClubByName", method = RequestMethod.POST)
    List<Club> findClubByName(@RequestParam(name = "name") String name) {
        return clubService.findClubByName(name);
    }

}
