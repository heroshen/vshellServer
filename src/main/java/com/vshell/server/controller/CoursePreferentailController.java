package com.vshell.server.controller;

import com.vshell.server.dao.CoursePreferentailMapper;
import com.vshell.server.model.CoursePreferentail;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coursePreferentail")
public class CoursePreferentailController {

    @Autowired
    private CoursePreferentailMapper coursePreferentailMapper;

    @RequestMapping("/queryById")
    public CoursePreferentail queryById(Integer id) {
        CoursePreferentail result = null;
        if (id != null && id > 0) {
            result = coursePreferentailMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(CoursePreferentail record) {
        int result = 0;
        if (record != null) {
            result = coursePreferentailMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = coursePreferentailMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(CoursePreferentail record) {
        int result = 0;
        if (record != null) {
            result = coursePreferentailMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<CoursePreferentail> selectByConditions(CoursePreferentail record, Integer offset, Integer pageSize){
        List<CoursePreferentail> resultList = coursePreferentailMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
