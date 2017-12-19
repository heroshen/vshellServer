package com.vshell.server.controller;

import com.vshell.server.dao.SubjectMapper;
import com.vshell.server.model.Subject;
import com.vshell.server.utils.MapUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectMapper subjectMapper;

    @RequestMapping("/queryById")
    public Subject queryById(Integer id) {
        Subject result = null;
        if (id != null && id > 0) {
            result = subjectMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Subject record) {
        int result = 0;
        if (record != null) {
            result = subjectMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = subjectMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Subject record) {
        int result = 0;
        if (record != null) {
            result = subjectMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Subject> selectByConditions(Subject record, Integer offset, Integer pageSize){
        List<Subject> resultList = subjectMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
