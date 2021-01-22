package com.example.springcloudapi.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String dbSource;

    public Dept(String dname) {
        this.dname = dname;
    }
}
