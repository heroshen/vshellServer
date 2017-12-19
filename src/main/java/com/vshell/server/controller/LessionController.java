package com.vshell.server.controller;

import com.vshell.server.dao.LessionMapper;
import com.vshell.server.model.Lession;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lession")
public class LessionController {

    @Autowired
    private LessionMapper lessionMapper;

    @RequestMapping("/queryById")
    public Lession queryById(Integer id) {
        Lession result = null;
        if (id != null && id > 0) {
            result = lessionMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Lession record) {
        int result = 0;
        if (record != null) {
            result = lessionMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = lessionMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Lession record) {
        int result = 0;
        if (record != null) {
            result = lessionMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Lession> selectByConditions(Lession record, Integer offset, Integer pageSize){
        List<Lession> resultList = lessionMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
