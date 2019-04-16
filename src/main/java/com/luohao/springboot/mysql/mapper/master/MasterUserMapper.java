package com.luohao.springboot.mysql.mapper.master;

import com.luohao.springboot.mysql.entiy.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MasterUserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "name",  column = "name"),
            @Result(property = "age", column = "age")
    })
    UserEntity getOne(Long id);


    @Insert("INSERT INTO user(name,age) VALUES(#{name}, #{age})")
    void insert(UserEntity user);

}
