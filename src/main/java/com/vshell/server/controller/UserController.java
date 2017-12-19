package com.vshell.server.controller;

import com.vshell.server.dao.UserMapper;
import com.vshell.server.model.User;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryById")
    public User queryById(Integer id) {
        User result = null;
        if (id != null && id > 0) {
            result = userMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(User record) {
        int result = 0;
        if (record != null) {
            result = userMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = userMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(User record) {
        int result = 0;
        if (record != null) {
            result = userMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<User> selectByConditions(User record, Integer offset, Integer pageSize){
        List<User> resultList = userMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
