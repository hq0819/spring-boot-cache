package com.h.springboot.mapper;

import com.h.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface UserMapper {


    @Select("select * from user where id=#{id}")
    User selByid(Integer id);


    @Update("update user set userName=#{userName},sex=#{sex},age=#{age} where id=#{id}")
    public void updateUser(User user);

}
