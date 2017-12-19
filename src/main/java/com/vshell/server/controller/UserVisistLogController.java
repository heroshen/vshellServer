package com.vshell.server.controller;

import com.vshell.server.dao.UserVisistLogMapper;
import com.vshell.server.model.UserVisistLog;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userVisistLog")
public class UserVisistLogController {

    @Autowired
    private UserVisistLogMapper userVisistLogMapper;

    @RequestMapping("/queryById")
    public UserVisistLog queryById(Integer id) {
        UserVisistLog result = null;
        if (id != null && id > 0) {
            result = userVisistLogMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(UserVisistLog record) {
        int result = 0;
        if (record != null) {
            result = userVisistLogMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = userVisistLogMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(UserVisistLog record) {
        int result = 0;
        if (record != null) {
            result = userVisistLogMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<UserVisistLog> selectByConditions(UserVisistLog record, Integer offset, Integer pageSize){
        List<UserVisistLog> resultList = userVisistLogMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
