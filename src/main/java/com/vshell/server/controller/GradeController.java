package com.vshell.server.controller;

import com.vshell.server.dao.GradeMapper;
import com.vshell.server.model.Grade;
import com.vshell.server.utils.MapUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeMapper gradeMapper;

    @RequestMapping("/queryById")
    public Grade queryById(Integer id) {
        Grade result = null;
        if (id != null && id > 0) {
            result = gradeMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Grade record) {
        int result = 0;
        if (record != null) {
            result = gradeMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = gradeMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Grade record) {
        int result = 0;
        if (record != null) {
            result = gradeMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Grade> selectByConditions(Grade record, Integer offset, Integer pageSize){
        List<Grade> resultList = gradeMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
