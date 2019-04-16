package com.luohao.springboot.mysql;

import com.luohao.springboot.mysql.entiy.UserEntity;
import com.luohao.springboot.mysql.mapper.master.MasterUserMapper;
import com.luohao.springboot.mysql.mapper.slave.SalveUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDao {

    @Autowired
    private MasterUserMapper masterUserMapper;

    @Autowired
    private SalveUserMapper salveUserMapper;

    @Test
    public void testInsert() {
        masterUserMapper.insert(new UserEntity("aa", 1));
        salveUserMapper.insert(new UserEntity("bb", 1));

    }


}
