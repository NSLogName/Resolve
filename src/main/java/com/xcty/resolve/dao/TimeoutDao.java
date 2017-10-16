package com.xcty.resolve.dao;

import com.xcty.resolve.dao.entity.TimeoutWithBlobs;
import com.xcty.resolve.dao.mapper.TimeoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*******************************
 * @Title: TimeoutDao
 * @package com.xcty.resolve.dao
 * @Description:TODO
 *
 * @author XCTY
 * @date 2017/10/10 15:26
 * @version
 ********************************/

@Repository
public class TimeoutDao {
    @Autowired
    TimeoutMapper timeoutMapper;

    public int insert(TimeoutWithBlobs record) {
        return timeoutMapper.insert(record);
    }

    public int insertTimeoutWithBlobsBatch(List<TimeoutWithBlobs > timeoutWithBlobs) {
        return timeoutMapper.insertTimeoutWithBLOBsBatch(timeoutWithBlobs);
    }
}
