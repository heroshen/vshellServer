package com.vshell.server.controller;

import com.vshell.server.dao.CourseMapper;
import com.vshell.server.model.Course;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;

    @RequestMapping("/queryById")
    public Course queryById(Integer id) {
        Course result = null;
        if (id != null && id > 0) {
            result = courseMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Course record) {
        int result = 0;
        if (record != null) {
            result = courseMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = courseMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Course record) {
        int result = 0;
        if (record != null) {
            result = courseMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Course> selectByConditions(Course record, Integer offset, Integer pageSize){
        List<Course> resultList = courseMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
