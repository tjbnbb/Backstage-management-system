package com.tjb.backend.controller;

import com.github.pagehelper.PageInfo;
import com.tjb.backend.bean.UsersBean;
import com.tjb.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @CrossOrigin
    @PostMapping("/insertusers")
    public Map insertUsers(@RequestBody UsersBean usersBean) {
        usersService.insertUsers(usersBean);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data","success");
        return responseData;
    }

    @CrossOrigin
    @DeleteMapping("/deleteusers")
    public Map deleteUsers(@RequestParam("username") String username) {
        usersService.deleteUsers(username);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data","success");
        return responseData;
    }

    @DeleteMapping("/deletebeginusers")
    public boolean deletebeginUsers(@RequestParam("username") String username) {
        int tmp = usersService.deletebeginUsers(username);
        return tmp != 0;
    }

    @CrossOrigin
    @PutMapping("/updateusers")
    public Map updateUsers(@RequestBody UsersBean usersBean) {
        usersService.updateUsers(usersBean);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data","success");
        return responseData;
    }

    @GetMapping("/getusers")
    public List<UsersBean> getUsers(@RequestParam("username") String username) {
        return usersService.getUsers(username);
    }

    @GetMapping("/getlikeusers")
    public List<UsersBean> getlikeUsers(@RequestParam("username") String username) {
        return usersService.getlikeUsers(username);
    }

    @CrossOrigin
    @GetMapping("/getallusers")
    public Map getAllUsers() {
        List<UsersBean> usersList = usersService.getAllUsers();
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data",usersList);
        return responseData;
    }

    @CrossOrigin
    @GetMapping("/getPageInfo")
    public Map getPageInfo(@RequestParam("page") int page,@RequestParam("limit") int limit,
                           @RequestParam(value = "username",required = false) String username,
                           @RequestParam(value = "type",required = false) String type) {
        PageInfo<UsersBean> pageInfo = usersService.getPageInfo(page,limit,username,type);
        HashMap<String,Object> responseData = new HashMap<>();
        responseData.put("code",20000);
        responseData.put("data",pageInfo);
        return responseData;
    }

}
