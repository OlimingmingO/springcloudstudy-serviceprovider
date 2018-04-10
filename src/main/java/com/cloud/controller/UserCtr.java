package com.cloud.controller;

import com.cloud.bean.User;
import com.cloud.reponsitory.UserReponsitory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oliverlee on 2018/3/24.
 */
@RestController
/**
 * 一般的java应用，需要通过配置Controller类到配置文件中，使得Tomcat在启动时找到Controller接口，这里通过注解完成
 */
public class UserCtr  {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired

     // 用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法注入所需的外部资源。
    private DiscoveryClient client;

    @Autowired
    UserReponsitory userReponsitory;

    @RequestMapping("/hello")
    public String HelloCloud(){
        return "helloCloud";
    }

    @RequestMapping("/add")
    public Integer  Add(@RequestParam Integer a, @RequestParam Integer b){
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("@@@@@/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }


    @RequestMapping("/UpdateUser")
    @ResponseBody
    public String UpdateUser(@RequestBody User user){
        System.out.println(user.getName());
        userReponsitory.save(user);
        return "Provider UpdateUser Is Called";
    }

}
