package com.example.springcloudproviderdept8002;

import com.example.springcloudproviderdept8002.mapper.DeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTest {
    @Autowired
    private DeptMapper deptMapper;
    @Test
    public void test1(){
        deptMapper.queryAll().stream().forEach(System.out::println);
    }
}
