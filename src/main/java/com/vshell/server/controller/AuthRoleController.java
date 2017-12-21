package com.vshell.server.controller;

import com.vshell.server.dao.AuthRoleMapper;
import com.vshell.server.model.AuthRole;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authRole")
public class AuthRoleController {

    @Autowired
    private AuthRoleMapper authRoleMapper;

    @RequestMapping("/queryById")
    public AuthRole queryById(Integer id) {
        AuthRole result = null;
        if (id != null && id > 0) {
            result = authRoleMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(AuthRole record) {
        int result = 0;
        if (record != null) {
            result = authRoleMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = authRoleMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(AuthRole record) {
        int result = 0;
        if (record != null) {
            result = authRoleMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<AuthRole> selectByConditions(AuthRole record, Integer offset, Integer pageSize){
        List<AuthRole> resultList = authRoleMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
