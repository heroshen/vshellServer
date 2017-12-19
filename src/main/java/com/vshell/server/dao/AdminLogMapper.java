package com.vshell.server.dao;

import com.vshell.server.model.AdminLog;

import java.util.Map;
import java.util.List;

public interface AdminLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminLog record);

    int insertSelective(AdminLog record);

    AdminLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminLog record);

    int updateByPrimaryKey(AdminLog record);

    List<AdminLog> selectByConditions(Map record);
}
