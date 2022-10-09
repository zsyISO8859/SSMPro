package com.itlike_sqllabel.test;

import com.itlike.utils.SqlSessionFactoryUtil;

import com.itlike_params.domain.Customer;
import com.itlike_resvalue.dao.StudentMapper;
import com.itlike_resvalue.domain.Student;
import com.itlike_sqllabel.dao.CustomerMapper;
import com.itlike_sqllabel.domain.QueryVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class sqlLabelTest {
    //findByContent 如果第一个条件为null会报错 可以在where前面加上1=1
    //findByContent1 where标签会删除第一个and 写条件的时候前面可以都写上and
    //findByContent2 可以先定义一个sql片段 然后在其他sql里面引用它
    //findByContent3  用foreach来遍历array且拼接数据
    //findByContent4  用foreach来遍历list且拼接数据
    //findByContent5  用foreach来遍历VO且拼接数据
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //Customer c = customerMapper.findByContent(null, "李白");
        //Customer c = customerMapper.findByContent1(null, "李白");
        //Customer c = customerMapper.findByContent2(2, "李白");
        //List<Customer> c = customerMapper.findByContent3(new Integer[]{1,2});
        //ArrayList<String> arrayList = new ArrayList<>();
        //arrayList.add("1");
        //arrayList.add("2");
        //List<Customer> c = customerMapper.findByContent4(arrayList);
        QueryVo queryVo = new QueryVo();
        //queryVo.setVolist(arrayList);
        queryVo.setVoids(new Integer[]{1,2,3});
        //List<Customer> c = customerMapper.findByContent5(queryVo);
        List<Customer> c = customerMapper.findByContent6(queryVo);
        for (Customer customer : c) {
            System.out.println(customer);
        }
        sqlSession.close();
    }
}
