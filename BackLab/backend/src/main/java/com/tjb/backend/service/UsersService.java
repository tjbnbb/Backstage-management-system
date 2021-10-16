package com.tjb.backend.service;

import com.github.pagehelper.PageInfo;
import com.tjb.backend.bean.UsersBean;

import java.util.List;

public interface UsersService {

    int createUserstable();

    int insertUsers(UsersBean usersBean);

    int deleteUsers(String usersname);

    int deletebeginUsers(String usersname);

    int updateUsers(UsersBean usersBean);

    List<UsersBean> getUsers(String usersname);

    List<UsersBean> getlikeUsers(String usersname);

    List<UsersBean> getAllUsers();

    //分页查询
    PageInfo<UsersBean> getPageInfo(int page, int limit, String username, String type);

    int dropUserstable();

}
