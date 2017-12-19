package com.vshell.server.dao;

import com.vshell.server.model.Preferential;

import java.util.Map;
import java.util.List;

public interface PreferentialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Preferential record);

    int insertSelective(Preferential record);

    Preferential selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Preferential record);

    int updateByPrimaryKey(Preferential record);

    List<Preferential> selectByConditions(Map record);
}
