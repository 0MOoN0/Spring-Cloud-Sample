package com.springcloud.controller;

import com.priv.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * port:80
 *
 * @author Leon
 */
@RestController
public class DeptControllerConsumer {

    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;


    @PutMapping("/consumer/dept")
    public void add(@RequestBody Dept dept){
        restTemplate.put(REST_URL_PREFIX+"/dept", dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable("id") Long id ){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/"+id, Dept.class);
    }

    @GetMapping("consumer/dept")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept", List.class);
    }

    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    }

}
