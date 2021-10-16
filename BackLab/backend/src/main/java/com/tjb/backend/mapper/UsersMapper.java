package com.tjb.backend.mapper;

import com.tjb.backend.bean.UsersBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    int createUserstable();

    int insertUsers(UsersBean usersBean);

    int deletelikeUsers(String username);

    int updateUsers(UsersBean usersBean);

    List<UsersBean> getlikeUsers(String usersname);

    List<UsersBean> getAllUsers();

    int dropUserstable();
}
