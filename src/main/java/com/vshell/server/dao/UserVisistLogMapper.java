package com.vshell.server.dao;

import com.vshell.server.model.UserVisistLog;

import java.util.Map;
import java.util.List;

public interface UserVisistLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVisistLog record);

    int insertSelective(UserVisistLog record);

    UserVisistLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVisistLog record);

    int updateByPrimaryKey(UserVisistLog record);

    List<UserVisistLog> selectByConditions(Map record);
}
