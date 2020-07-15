package com.lvtaipeng.sc.com.lvtaipeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestProvider {

    @Autowired
    DiscoveryClient discoveryClient;

    
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @RequestMapping("service")
    public List<String>  getServices(){
        List<String> services = discoveryClient.getServices();

        return services;

    }
    //根据服务的名称查询
    @RequestMapping("getService")
    public List<ServiceInstance>  getService(){
        List<ServiceInstance> provider = discoveryClient.getInstances("providerName");

        return provider;

    }

    @RequestMapping("call")
    public String call(){
        //获取实力Id 为providerName服务的实力
        List<ServiceInstance> providerName = discoveryClient.getInstances("providerName");

        if(providerName!=null &&providerName.size()>0){
            RestTemplate template = new RestTemplate();

            ServiceInstance instance = providerName.get(0);

            String forObject = template.getForObject(instance.getUri().toString() + "/test", String.class);

            return forObject;
        }
        return "no service";
    }

   @RequestMapping("bacall")
    public String bacall(){
        
        //随机获取一个五福
       ServiceInstance instance = loadBalancerClient.choose("providerName");
       
       //获取一个服务的资源地址
       String url=instance.getUri().toString()+"test";
       
       RestTemplate template =new RestTemplate();

       //发起调用
       String s = template.getForObject(url, String.class);

       System.out.println("return is s"+s);

       return s;

   }
}
