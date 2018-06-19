package com.xcty.resolve.dao.mapper;

import com.xcty.resolve.dao.entity.ResolveLog;
import com.xcty.resolve.dao.entity.ResolveLogWithBLOBs;
import com.xcty.resolve.dao.mapper.i.IMapper;

import java.util.List;

public interface ResolveLogMapper extends IMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResolveLogWithBLOBs record);

    int insertResolveLogWithBLOBsBatch(List<ResolveLogWithBLOBs> recordList);

    int insertSelective(ResolveLogWithBLOBs record);

    ResolveLogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResolveLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ResolveLogWithBLOBs record);

    int updateByPrimaryKey(ResolveLog record);
}