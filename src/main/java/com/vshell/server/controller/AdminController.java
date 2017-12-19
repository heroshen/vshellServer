package com.vshell.server.controller;

import com.vshell.server.dao.AdminMapper;
import com.vshell.server.model.Admin;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/queryById")
    public Admin queryById(Integer id) {
        Admin result = null;
        if (id != null && id > 0) {
            result = adminMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Admin record) {
        int result = 0;
        if (record != null) {
            result = adminMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = adminMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Admin record) {
        int result = 0;
        if (record != null) {
            result = adminMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Admin> selectByConditions(Admin record, Integer offset, Integer pageSize){
        List<Admin> resultList = adminMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
