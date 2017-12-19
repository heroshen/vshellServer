package com.vshell.server.dao;

import com.vshell.server.model.CoursePreferentail;

import java.util.Map;
import java.util.List;

public interface CoursePreferentailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoursePreferentail record);

    int insertSelective(CoursePreferentail record);

    CoursePreferentail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoursePreferentail record);

    int updateByPrimaryKey(CoursePreferentail record);

    List<CoursePreferentail> selectByConditions(Map record);
}
