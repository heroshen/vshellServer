package com.vshell.server.controller;

import com.vshell.server.dao.AuthOperationMapper;
import com.vshell.server.model.AuthOperation;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authOperation")
public class AuthOperationController {

    @Autowired
    private AuthOperationMapper authOperationMapper;

    @RequestMapping("/queryById")
    public AuthOperation queryById(Integer id) {
        AuthOperation result = null;
        if (id != null && id > 0) {
            result = authOperationMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(AuthOperation record) {
        int result = 0;
        if (record != null) {
            result = authOperationMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = authOperationMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(AuthOperation record) {
        int result = 0;
        if (record != null) {
            result = authOperationMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<AuthOperation> selectByConditions(AuthOperation record, Integer offset, Integer pageSize){
        List<AuthOperation> resultList = authOperationMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
