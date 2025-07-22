package com.example.boke.Redis.controller;

import com.example.boke.Student.service.DTO.StudentDTO;
import com.example.boke.annotation.OUT;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author bjingban
 * @date 2025-07-14 11:46
 */
@RestController
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @OUT
    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }
    /*
    redis
    * */
    @PostMapping("/redis")
    public void aNewStudent(@RequestBody StudentDTO studentDTO){
        redisTemplate.opsForValue().set("studentDT",studentDTO);
    }

    @GetMapping("/redis")
    public StudentDTO asdgetStudentDTO(@PathParam("key") String key){
        return (StudentDTO) redisTemplate.opsForValue().get(key);
    }

    @DeleteMapping("/redis")
    public boolean deleteRedis(@PathParam("key") String key){
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }

    @GetMapping("/string")
    public String string(){
        redisTemplate.opsForValue().set("hello","hello-world");
        String hello = (String) redisTemplate.opsForValue().get("hello");
        return hello;
    }

    @GetMapping("/list")
    public List<String> listt(){
        ListOperations<String,String> listOperations= redisTemplate.opsForList();
        listOperations.leftPush("list","list1");
        listOperations.leftPush("list","list2");
        listOperations.leftPush("list","list7");
        listOperations.leftPush("list","list4");
        List<String> list1 =listOperations.range("list",0,-1);
        return list1;
    }

    @GetMapping("/set")
    public Set<String> stt(){
        SetOperations<String,String> setOperations = redisTemplate.opsForSet();
        setOperations.add("set","set1");
        setOperations.add("set","set2");
        setOperations.add("set","set2");
        setOperations.add("set","set3");
        setOperations.add("set","set4");
        setOperations.add("set","set5");
        Set<String> list1 =setOperations.members("set");
        return list1;
    }

    @GetMapping("/zset")
    public Set<String> zstt(){
        ZSetOperations<String,String> zsetOperations = redisTemplate.opsForZSet();
        zsetOperations.add("Zset","set1",3);
        zsetOperations.add("Zset","set2",1);
        zsetOperations.add("Zset","set2",2);
        zsetOperations.add("Zset","set3",5);
        zsetOperations.add("Zset","set4",4);
        Set<String> list1 =zsetOperations.range("Zset",0,-1);
        return list1;
    }

    @GetMapping("/hash")
    public void zstth(){
        HashOperations<String,String,String> hashmapOperations = redisTemplate.opsForHash();
        hashmapOperations.put("Zset1","set1","lol");
        hashmapOperations.put("Zset1","set1","lol1");
        hashmapOperations.put("Zset1","set1","lol2");
        hashmapOperations.put("Zset1","set1","lol3");
        String list1 =hashmapOperations.get("Zset1","set1");
        System.out.println(list1);
    }
}
