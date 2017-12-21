package com.vshell.server.dao;

import com.vshell.server.model.AuthRoleOperation;

import java.util.Map;
import java.util.List;

public interface AuthRoleOperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRoleOperation record);

    int insertSelective(AuthRoleOperation record);

    AuthRoleOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRoleOperation record);

    int updateByPrimaryKey(AuthRoleOperation record);

    List<AuthRoleOperation> selectByConditions(Map record);
}
