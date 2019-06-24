package com.springcloud.controller;

import com.priv.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * port:8001 Provider
 *
 * @author Leon
 */
@RestController
public class DeptController
{
    @Autowired
    private DeptService service;

    @PutMapping(value="/dept")
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @GetMapping(value="/dept/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @GetMapping(value="/dept")
    public List<Dept> list()
    {
        return service.list();
    }



}
