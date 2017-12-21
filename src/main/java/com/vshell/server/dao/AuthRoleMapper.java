package com.vshell.server.dao;

import com.vshell.server.model.AuthRole;

import java.util.Map;
import java.util.List;

public interface AuthRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);

    List<AuthRole> selectByConditions(Map record);
}
