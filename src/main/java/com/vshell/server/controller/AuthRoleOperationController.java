package com.vshell.server.controller;

import com.vshell.server.dao.AuthRoleOperationMapper;
import com.vshell.server.model.AuthRoleOperation;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authRoleOperation")
public class AuthRoleOperationController {

    @Autowired
    private AuthRoleOperationMapper authRoleOperationMapper;

    @RequestMapping("/queryById")
    public AuthRoleOperation queryById(Integer id) {
        AuthRoleOperation result = null;
        if (id != null && id > 0) {
            result = authRoleOperationMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(AuthRoleOperation record) {
        int result = 0;
        if (record != null) {
            result = authRoleOperationMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = authRoleOperationMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(AuthRoleOperation record) {
        int result = 0;
        if (record != null) {
            result = authRoleOperationMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<AuthRoleOperation> selectByConditions(AuthRoleOperation record, Integer offset, Integer pageSize){
        List<AuthRoleOperation> resultList = authRoleOperationMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
