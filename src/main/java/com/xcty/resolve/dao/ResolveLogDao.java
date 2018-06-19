package com.xcty.resolve.dao;

import com.xcty.resolve.dao.entity.ResolveLogWithBLOBs;
import com.xcty.resolve.dao.mapper.ResolveLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/********************************
 * @Title ResolveLogDao
 * @package com.xcty.resolve.dao
 * @Description:TODO
 *
 * @author XCTY
 * @date 2018/6/19 10:44
 * @version
 *********************************/
@Repository
public class ResolveLogDao {
    @Autowired
    private ResolveLogMapper resolveLogMapper;

    public  int insertResolveLogWithBLOBsBatch(List<ResolveLogWithBLOBs> recordList) {
        return resolveLogMapper.insertResolveLogWithBLOBsBatch(recordList);
    }
}
