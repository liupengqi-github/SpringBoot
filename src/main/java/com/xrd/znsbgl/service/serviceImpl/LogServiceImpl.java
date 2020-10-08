package com.xrd.znsbgl.service.serviceImpl;

import com.xrd.znsbgl.entity.LoginLog;
import com.xrd.znsbgl.mapper.LogMapper;
import com.xrd.znsbgl.service.LogService;
import com.xrd.znsbgl.util.TimestampUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public void addLog(Integer id, String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setAdminid(id);
        loginLog.setIp(ip);
        loginLog.setLogintime(TimestampUtil.getTimestamp());
        logMapper.addLog(loginLog);
    }
}
