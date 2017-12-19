package com.vshell.server.controller;

import com.vshell.server.dao.CommentMapper;
import com.vshell.server.model.Comment;
import com.vshell.server.utils.MapUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping("/queryById")
    public Comment queryById(Integer id) {
        Comment result = null;
        if (id != null && id > 0) {
            result = commentMapper.selectByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/insert")
    public int insert(Comment record) {
        int result = 0;
        if (record != null) {
            result = commentMapper.insertSelective(record);
        }
        return result;
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        int result = 0;
        if (id != null) {
            result = commentMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    @RequestMapping("/update")
    public int update(Comment record) {
        int result = 0;
        if (record != null) {
            result = commentMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @RequestMapping("/selectByConditions")
    public List<Comment> selectByConditions(Comment record, Integer offset, Integer pageSize){
        List<Comment> resultList = commentMapper.selectByConditions(MapUtil.bean2Map(record, offset, pageSize));
        return resultList;
    }
}
