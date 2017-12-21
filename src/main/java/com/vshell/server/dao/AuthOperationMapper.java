package com.vshell.server.dao;

import com.vshell.server.model.AuthOperation;

import java.util.Map;
import java.util.List;

public interface AuthOperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthOperation record);

    int insertSelective(AuthOperation record);

    AuthOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthOperation record);

    int updateByPrimaryKey(AuthOperation record);

    List<AuthOperation> selectByConditions(Map record);
}
