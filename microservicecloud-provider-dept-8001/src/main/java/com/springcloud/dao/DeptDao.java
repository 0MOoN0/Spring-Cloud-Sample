package com.springcloud.dao;

import com.priv.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Leon
 */
@Mapper
public interface DeptDao
{
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}