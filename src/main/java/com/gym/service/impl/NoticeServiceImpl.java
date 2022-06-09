package com.gym.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.NoticeMapper;
import com.gym.po.Notice;
import com.gym.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public PageInfo<Notice> queryAllNotice(Notice notice, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);//业务层实现分页
        List<Notice> noticeList = noticeMapper.queryNoticeAll(notice);
        return new PageInfo<>(noticeList);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public Notice queryNoticeById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteNoticeByIds(List<String> ids) {
        for (String id : ids){
            noticeMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}