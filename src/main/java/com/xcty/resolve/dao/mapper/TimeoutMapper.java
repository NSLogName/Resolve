package com.xcty.resolve.dao.mapper;

import com.xcty.resolve.dao.entity.Timeout;
import com.xcty.resolve.dao.entity.TimeoutWithBlobs;
import com.xcty.resolve.dao.mapper.i.IMapper;

import java.util.List;

public interface TimeoutMapper extends IMapper{
    /**
     * 根据主键删除指定记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键插入指定记录
     * @param record
     * @return
     */
    int insert(TimeoutWithBlobs record);

    /**
     * 根据主键插入指定记录
     * @param record
     * @return
     */
    int insertSelective(TimeoutWithBlobs record);

    /**
     * 根据批量插入记录
     * @param timeoutWithBLOBs
     * @return
     */
    int insertTimeoutWithBLOBsBatch(List<TimeoutWithBlobs > timeoutWithBLOBs);

    /**
     * 根据主键更新指定记录
     * @param id
     * @return
     */
    TimeoutWithBlobs selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新指定记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TimeoutWithBlobs record);

    /**
     * 根据主键更新指定记录
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(TimeoutWithBlobs record);

    /**
     * 根据主键更新指定记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Timeout record);
}