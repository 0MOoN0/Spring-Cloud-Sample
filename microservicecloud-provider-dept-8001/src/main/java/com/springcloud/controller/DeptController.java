package com.springcloud.controller;

import com.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    @Autowired
    private DiscoveryClient client;

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

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
