package com.southwind.test;

import com.southwind.entity.Account;
import com.southwind.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        //添加对象
//        Account account = new Account(3L,"王五","111111",24);
//        int result = accountRepository.save(account);
//        sqlSession.commit();
        //查询全部对象
//        List<Account> list = accountRepository.findAll();
//        for (Account account:list){
//            System.out.println(account);
//        }
//        sqlSession.close();
        //通过id查询对象
//        Account account = accountRepository.findById(3L);
//        System.out.println(account);
//        sqlSession.close();
        //修改对象
//        Account account = accountRepository.findById(3L);
//        account.setUsername("小明");
//        account.setPassword("000");
//        account.setAge(18);
//        int result = accountRepository.update(account);
//        sqlSession.commit();
//        System.out.println(result);
//        sqlSession.close();
        //通过id删除对象
//        int result = accountRepository.deleteById(3L);
//        System.out.println(result);
//        sqlSession.commit();
//        System.out.println(accountRepository.findByName("张三"));
//        Long id = Long.parseLong("1");
//        System.out.println(accountRepository.findById2(id));
//        System.out.println(accountRepository.findByNameAndAge("张三",22));
//        System.out.println(accountRepository.count());
//        System.out.println(accountRepository.count2());
        System.out.println(accountRepository.findNameById(1L));
        sqlSession.close();
    }
}
