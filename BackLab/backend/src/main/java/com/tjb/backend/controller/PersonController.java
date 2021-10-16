package com.tjb.backend.controller;

import com.github.pagehelper.PageInfo;
import com.tjb.backend.bean.PersonBean;
import com.tjb.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @CrossOrigin
    @PostMapping("/insertperson")
    public Map insertPerson(@RequestBody PersonBean personBean) {
        personService.insertPerson(personBean);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data","success");
        return responseData;
    }

    @CrossOrigin
    @DeleteMapping("/deleteperson")
    public Map deletePerson(@RequestParam("username") String username) {
        personService.deletePerson(username);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data","success");
        return responseData;
    }

    @DeleteMapping("/deletebeginperson")
    public boolean deletebeginPerson(@RequestParam("username") String username) {
        int tmp = personService.deletebeginPerson(username);
        return tmp != 0;
    }

    @CrossOrigin
    @PutMapping("/updateperson")
    public Map updatePerson(@RequestBody PersonBean personBean) {
        personService.updatePerson(personBean);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data","success");
        return responseData;
    }

    @GetMapping("/getperson")
    public List<PersonBean> getPerson(@RequestParam("username") String username) {
        return personService.getPerson(username);
    }

    @GetMapping("/getlikeperson")
    public List<PersonBean> getlikeUsers(@RequestParam("username") String username) {
        return personService.getlikePerson(username);
    }

    @GetMapping("/getallperson")
    public List<PersonBean> getAllPerson() {
        return personService.getAllPerson();
    }

    @CrossOrigin
    @GetMapping("/getPageInfo")
    public Map getPageInfo(@RequestParam("page") int page,@RequestParam("limit") int limit,
                                            @RequestParam(value = "username",required = false) String username,
                                            @RequestParam(value = "type",required = false) String type) {
        PageInfo<PersonBean> pageInfo = personService.getPageInfo(page,limit,username,type);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data",pageInfo);
        return responseData;
    }

}
