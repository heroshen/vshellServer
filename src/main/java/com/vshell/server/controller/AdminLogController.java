package com.vshell.server.controller;

import com.vshell.server.dao.AdminLogMapper;
import com.vshell.server.model.AdminLog;
import com.vshell.server.utils.MapUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adminLog")
public class AdminLogController {

    @Autowired
    private AdminLogMapper adminLogMapper;

    @RequestMapping("/queryById")
    public AdminLog queryById(Integer id) {
        AdminLog result = null;
        if (id != null && id > 0) {
            result = adminLogMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(AdminLog record) {
        int result = 0;
        if (record != null) {
            result = adminLogMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = adminLogMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(AdminLog record) {
        int result = 0;
        if (record != null) {
            result = adminLogMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<AdminLog> selectByConditions(AdminLog record, Integer offset, Integer pageSize){
        List<AdminLog> resultList = adminLogMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
