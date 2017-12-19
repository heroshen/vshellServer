package com.vshell.server.controller;

import com.vshell.server.dao.FeedbackMapper;
import com.vshell.server.model.Feedback;
import com.vshell.server.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @RequestMapping("/queryById")
    public Feedback queryById(Integer id) {
        Feedback result = null;
        if (id != null && id > 0) {
            result = feedbackMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Feedback record) {
        int result = 0;
        if (record != null) {
            result = feedbackMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = feedbackMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Feedback record) {
        int result = 0;
        if (record != null) {
            result = feedbackMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Feedback> selectByConditions(Feedback record, Integer offset, Integer pageSize){
        List<Feedback> resultList = feedbackMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
