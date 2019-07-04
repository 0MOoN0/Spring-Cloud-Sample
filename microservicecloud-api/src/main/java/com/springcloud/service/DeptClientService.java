package com.springcloud.service;

import com.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Leon
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value = "/dept/{id}",method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept",method = RequestMethod.GET)
    List<Dept> list();

    @RequestMapping(value = "/dept",method = RequestMethod.PUT)
    boolean add(Dept dept);

}
