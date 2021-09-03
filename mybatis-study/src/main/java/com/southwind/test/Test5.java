package com.southwind.test;

import com.southwind.entity.Account;
import com.southwind.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account account = new Account();
//        account.setId(1L);
//        account.setUsername("张三");
//        account.setPassword("123123");
//        account.setAge(22);
        List<Long> ids = new ArrayList<Long>();
        ids.add(1L);
        ids.add(4L);
        ids.add(5L);
        account.setIds(ids);
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        System.out.println(accountRepository.findByIds(account));
        sqlSession.commit();
        sqlSession.close();
    }
}
