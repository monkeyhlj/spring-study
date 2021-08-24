package com.monkey.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monkey.mybatisplus.entity.User;
import com.monkey.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        User u = new User();
        u.setTitle("孙悟空");
        u.setAge(18);
        userMapper.insert(u);
        System.out.println(u);
    }

    @Test
    void update(){
//        User user = userMapper.selectById(1);
//        user.setTitle("梅西2");
//        userMapper.updateById(user);

//        //update ... version = 3 where version = 2
//        User user = mapper.selectById(1);
//        user.setTitle("一号");
//
//        //update ... version = 3 where version = 2
//        User user1 = mapper.selectById(1);
//        user1.setTitle("二号");
//
//        userMapper.updateById(user1);
//        userMapper.updateById(user);

        User user = userMapper.selectById(1);
        user.setTitle("小红");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",18);
        userMapper.update(user,wrapper);

    }

    @Test
    void delete(){
//        userMapper.deleteById(1);
//        userMapper.deleteBatchIds(Arrays.asList(1,2));

//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("age",14);
//        userMapper.delete(wrapper);

        Map<String,Object> map = new HashMap<>();
        map.put("id",10);
        userMapper.deleteByMap(map);
    }

    @Test
    void select(){
        //不加任何条件直接全部查询
//        userMapper.selectList(null);

        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("name","梅西2");

//        Map<String,Object> map = new HashMap<>();
//        map.put("name","梅西2");
//        map.put("age",18);
//        wrapper.allEq(map);

//        wrapper.lt("age",6);//小于
//        wrapper.gt("age",6);//大于
//        wrapper.ne("name","梅西2");//不等于
//        wrapper.ge("age",5);//大于等于

//        wrapper.like("name","西");//模糊查询
        //like '%西'
//        wrapper.likeLeft("name","西");//模糊查询
        //like '西%'
//        wrapper.likeRight("name","西");//模糊查询

        //inSQL联合查询
//        wrapper.inSql("id","select id from user where id < 10");
//        wrapper.inSql("age","select age from user where age > 3");

//        wrapper.orderByDesc("age");
        wrapper.orderByAsc("age");
        wrapper.having("id > 8");

        System.out.println(userMapper.selectList(wrapper));
    }

    @Test
    void select2(){
//        System.out.println(userMapper.selectById(1));
//        userMapper.selectBatchIds(Arrays.asList(1,2,3).forEach(System.out::println););

        //Map 只能做等值判断，逻辑判断需要使用 Wrapper 来处理
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",1);
//        userMapper.selectByMap(map);

//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.gt("id",1);
//        System.out.println(userMapper.selectCount(wrapper));
        //下面将查询的结果集封装到Map中
//        userMapper.selectMaps(wrapper).forEach(System.out::println);
//        userMapper.selectList(wrapper).forEach(System.out::println);

        //分页
//        Page<User> page = new Page<>(1,5);
//        Page<User> result = userMapper.selectPage(page, null);
//        System.out.println(result.getSize());
//        System.out.println(result.getTotal());
//        System.out.println(result.getRecords().forEach(System.out::println););

        //将结果封装到Map中
//        Page<Map<String,Object>> page = new Page<>(1,2);
//        userMapper.selectMapsPage(page,null).getRecords().forEach(System.out::println);

        //返回ids
//        userMapper.selectObjs(null).forEach(System.out::println);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",1);
        System.out.println(userMapper.selectOne(wrapper));
    }

    @Test
    void product(){
        userMapper.productList(1).forEach(System.out::println);
    }


}