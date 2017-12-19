package com.vshell.server.dao;

import com.vshell.server.model.LessionLog;

import java.util.Map;
import java.util.List;

public interface LessionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LessionLog record);

    int insertSelective(LessionLog record);

    LessionLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LessionLog record);

    int updateByPrimaryKey(LessionLog record);

    List<LessionLog> selectByConditions(Map record);
}
