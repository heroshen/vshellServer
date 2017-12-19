package com.vshell.server.dao;

import com.vshell.server.model.Lession;

import java.util.Map;
import java.util.List;

public interface LessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lession record);

    int insertSelective(Lession record);

    Lession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lession record);

    int updateByPrimaryKey(Lession record);

    List<Lession> selectByConditions(Map record);
}
