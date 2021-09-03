package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class StudentHandler {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/set")
    public void set(@RequestBody Student student){
        redisTemplate.opsForValue().set("student",student);
    }

    @GetMapping("/get/{key}")
    public Student get(@PathVariable("key") String key){
        return (Student) redisTemplate.opsForValue().get(key);
    }

    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable("key") String key){
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }

    @GetMapping("/string")
    public String stringTest(){
        redisTemplate.opsForValue().set("str","Hello World");
        String str = (String) redisTemplate.opsForValue().get("str");
        return str;
    }

    @GetMapping("/list")
    public List<String> listTest(){
        ListOperations<String,String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list","Hello");
        listOperations.leftPush("list","Hello");
        listOperations.leftPush("list","World");
        listOperations.leftPush("list","World");
        listOperations.leftPush("list","Java");
        listOperations.leftPush("list","Java");
        List<String> list = listOperations.range("list",0,5);
        return list;
    }

    @GetMapping("/set")
    public Set<String> setTest(){
        SetOperations<String,String> setOperations = redisTemplate.opsForSet();
        setOperations.add("set","Hello");
        setOperations.add("set","Hello");
        setOperations.add("set","World");
        setOperations.add("set","World");
        setOperations.add("set","Java");
        setOperations.add("set","Java");
        Set<String> set = setOperations.members("set");
        return set;
    }

    @GetMapping("/zset")
    public Set<String> zsetTest(){
        ZSetOperations<String,String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset","Hello",3);
        zSetOperations.add("zset","World",1);
        zSetOperations.add("zset","Java",2);
        Set<String> set = zSetOperations.range("zset",0,2);
        return set;
    }

    @GetMapping("/hash")
    public void hashTest(){
        HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("key","hashkey","hello");
        System.out.println(hashOperations.get("key","hashkey"));
    }
}
