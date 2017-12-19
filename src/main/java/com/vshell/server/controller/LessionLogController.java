package com.vshell.server.controller;

import com.vshell.server.dao.LessionLogMapper;
import com.vshell.server.model.LessionLog;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lessionLog")
public class LessionLogController {

    @Autowired
    private LessionLogMapper lessionLogMapper;

    @RequestMapping("/queryById")
    public LessionLog queryById(Integer id) {
        LessionLog result = null;
        if (id != null && id > 0) {
            result = lessionLogMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(LessionLog record) {
        int result = 0;
        if (record != null) {
            result = lessionLogMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = lessionLogMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(LessionLog record) {
        int result = 0;
        if (record != null) {
            result = lessionLogMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<LessionLog> selectByConditions(LessionLog record, Integer offset, Integer pageSize){
        List<LessionLog> resultList = lessionLogMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
