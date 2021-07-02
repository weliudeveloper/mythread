package com.liuwei.safety;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuwei.mybatis.dao.*;
import com.liuwei.mybatis.entity.User;
import com.liuwei.mybatis.entity.UserSex;
import com.liuwei.mybatis.entity.UserSexGenerator;
import com.liuwei.mybatis.entity.UserSexGeneratorExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wee
 */
public class mybatisTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user = (com.liuwei.mybatis.entity.User)sqlSession.selectOne("org.mybatis.example.userMapper.selectUser", "1");
//        UserDao2 mapper1 = sqlSession.getMapper(UserDao2.class);
//        User user = mapper1.getOne(1);
//        System.out.println(user);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        PageHelper.startPage(3, 3);
        List<User> users = mapper.selectBlog(1, 3);
        System.out.println(users.size());
//        System.out.println(user1);
//        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);
//        Integer integer = mapper.deleteOne(1);
//        User addUser = new User();
//        addUser.setName("liu");
//        addUser.setAge("25");
//        addUser.setId("1");
//        mapper.addOne(addUser);
//        Boolean isDelete = mapper.deleteOne(5);
//        Integer integer = mapper.updateOne(addUser);
//        sqlSession.commit();
//        User liu = mapper.getOne(1, "liu");
//        List<User> userList = mapper.getList("%l%");
//        userList.forEach(System.out::println);
//        Map<Integer, User> map = mapper.getMap("%l%");
//        System.out.println(step.getUserSex().getSex());
//        UserSex userSexPlus = mapper.getUserSexPlus("1");
//        Page<Object> page = PageHelper.startPage(2, 3);
//        List<User> userList = mapper.getUserList("1");
//        PageInfo<User> info = PageInfo.of(userList, 5);
//        userList.stream().forEach(user -> System.out.println(user.getName()));
//        System.out.println("getCountColumn==>" + page.getCountColumn());
//        System.out.println("getTotal==>" + page.getTotal());
//        System.out.println("getPages==>" + page.getPages());
//        System.out.println("getNextPage==>" + info.getNextPage());
//        System.out.println("getSize==>" + info.getSize());
//        System.out.println("getPageNum==>" + info.getPageNum());
//        int[] navigatepageNums = info.getNavigatepageNums();
//        for (int v:navigatepageNums) {
//            System.out.println(v);
//        }
        sqlSession.close();
    }

    @Test
    public void testDynamicSql() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserDynamicSqlDao mapper = sqlSession.getMapper(UserDynamicSqlDao.class);
        try {
            List<User> users = mapper.getList("", "q");
//            User user = new User("qmm","24","2");
////            Boolean isUpdate = mapper.updateUser(user, "1");
//            List<User> listByIds = mapper.getListByIds(Arrays.asList("1", "2", "6"));
            users.forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGenerator() throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("D:\\projects\\mythread\\src\\main\\resources\\mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void testGeneratorSql() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            UserSexGeneratorMapper mapper = sqlSession.getMapper(UserSexGeneratorMapper.class);
            UserSexGeneratorExample example = new UserSexGeneratorExample();
            UserSexGeneratorExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(Arrays.asList(1));

            UserSexGeneratorExample.Criteria criteria1 = example.createCriteria();
            criteria1.andSexLike("%女%");
            example.or(criteria1);
            List<UserSexGenerator> userSexGenerators = mapper.selectByExample(example);
            userSexGenerators.stream().forEach(user -> System.out.println(user.getSex()));
        } finally {
            sqlSession.close();
        }
    }
}
