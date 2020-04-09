package com.zl.geekdesign.demo.mapper;


import com.zl.geekdesign.demo.entity.T2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Create by zhanglong on 2020/4/8
 */
@Mapper
public interface T2Mapper {

    @Insert("insert into t2 values(#{id},#{a},#{b})")
    void insert(T2 t2);
}
