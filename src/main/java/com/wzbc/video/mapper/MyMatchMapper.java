package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzbc.video.entity.UserProduction;
import com.wzbc.video.params.MyMatch;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyMatchMapper extends BaseMapper<UserProduction> {

    int updateMyMatch(UserProduction userProduction);

    List<UserProduction> findByParentId(Long parentId);
}
