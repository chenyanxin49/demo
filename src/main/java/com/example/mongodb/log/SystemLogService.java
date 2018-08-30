package com.example.mongodb.log;

import com.example.demo.mongodb.model.SystemLog;
import org.springframework.data.domain.Page;

public interface SystemLogService {

    public Page<SystemLog> find(int page, int rows, SystemLog subscribe);

    public SystemLog findone(String sessionId);

    public void insertOne(SystemLog systemLog);

}
