package com.vshell.server.controller;

import com.vshell.server.dao.PreferentialMapper;
import com.vshell.server.model.Preferential;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/preferential")
public class PreferentialController {

    @Autowired
    private PreferentialMapper preferentialMapper;

    @RequestMapping("/queryById")
    public Preferential queryById(Integer id) {
        Preferential result = null;
        if (id != null && id > 0) {
            result = preferentialMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Preferential record) {
        int result = 0;
        if (record != null) {
            result = preferentialMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = preferentialMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Preferential record) {
        int result = 0;
        if (record != null) {
            result = preferentialMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Preferential> selectByConditions(Preferential record, Integer offset, Integer pageSize){
        List<Preferential> resultList = preferentialMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
