package com.liuwei.springan.configuration;

import com.liuwei.springan.dao.PersonDao;
import com.liuwei.springan.dao.Tomcat;
import com.liuwei.springan.service.LogNotice;
import org.springframework.context.annotation.*;

/**
 * @author wee
 */

//@ComponentScan("com.liuwei.springan")
/*@ComponentScan( value = "com.liuwei.springan" ,includeFilters =  {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
                Service.class
        })
} ,useDefaultFilters = false)*/
//@Import(value = {OrderBookDao.class, OrderBookImportSelector.class, OrderBookFactoryBean.class})
@Configuration
@EnableAspectJAutoProxy
public class BookConfiguration {

//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    @Scope("prototype")
   /* @Bean
    public Book getBook(){

        return new Book();
    }*/

   /* @Bean
    @Conditional(value = {OrderBookCondition.class})
    public Book getHistory(){
        System.out.println("我被调用了哦");
        return new Book();
    }*/

  /* @Bean
   public BikeBeanPostProcessor getBike(){
       return new BikeBeanPostProcessor();
   }*/

//   @Bean
//   @Primary
 /*  public PersonDao personDao(){
       PersonDao personDao = new PersonDao();
       personDao.setAge(2);
       return personDao;
   }*/

    @Bean
    public Tomcat tomcat() {
        return new Tomcat();
    }

    @Bean
    public LogNotice logNotice() {
        return new LogNotice();
    }
}
