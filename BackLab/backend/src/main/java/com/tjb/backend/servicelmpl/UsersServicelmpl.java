package com.tjb.backend.servicelmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjb.backend.bean.UsersBean;
import com.tjb.backend.mapper.PersonMapper;
import com.tjb.backend.mapper.UsersMapper;
import com.tjb.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServicelmpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    PersonMapper personMapper;

    @Override
    public int createUserstable() {
        return usersMapper.createUserstable();
    }

    @Override
    public int insertUsers(UsersBean usersBean) {
        return usersMapper.insertUsers(usersBean);
    }

    @Override
    public int deleteUsers(String usersname) {
        if(personMapper.getlikePerson(usersname) != null) personMapper.deletelikePerson(usersname);
        return usersMapper.deletelikeUsers(usersname);
    }

    @Override
    public int deletebeginUsers(String usersname) {
        if(personMapper.getlikePerson(usersname + "%") != null) personMapper.deletelikePerson(usersname + "%");
        return usersMapper.deletelikeUsers(usersname + "%");
    }

    @Override
    public int updateUsers(UsersBean usersBean) {
        return usersMapper.updateUsers(usersBean);
    }

    @Override
    public List<UsersBean> getUsers(String usersname) {
        return usersMapper.getlikeUsers(usersname);
    }

    @Override
    public List<UsersBean> getlikeUsers(String usersname) {
        return usersMapper.getlikeUsers("%" + usersname + "%");
    }

    @Override
    public List<UsersBean> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    @Override
    //分页查询
    public PageInfo<UsersBean> getPageInfo(int page, int limit, String username, String type) {
        PageHelper.startPage(page, limit,true);
        List<UsersBean> users;
        if(username == null || username.equals("") || type == null || type.equals("")) users = usersMapper.getAllUsers();
        else if(type.equals("exact")) users = usersMapper.getlikeUsers(username);
        else users = usersMapper.getlikeUsers("%" + username + "%");
        return new PageInfo<>(users);
    }

    @Override
    public int dropUserstable() {
        return usersMapper.dropUserstable();
    }

}
