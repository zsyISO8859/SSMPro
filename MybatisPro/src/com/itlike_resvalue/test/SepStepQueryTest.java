package com.itlike_resvalue.test;

import com.itlike.utils.SqlSessionFactoryUtil;
import com.itlike_resvalue.dao.CustomerMapper;
import com.itlike_resvalue.dao.OrderMapper;
import com.itlike_resvalue.dao.StudentMapper;
import com.itlike_resvalue.dao.TeachMapper;
import com.itlike_resvalue.domain.Customer;
import com.itlike_resvalue.domain.Order;
import com.itlike_resvalue.domain.Student;
import com.itlike_resvalue.domain.Teach;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//分布查询案例
public class SepStepQueryTest {

    //association用于一对一 多对一  collection用于多对一
    //分布查询可以使用懒加载 如果使用到customer属性才会加载出customer
    //在使用maybatis核心配置xml中的setting中可以配置tostring方法触发懒加载 <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode"/>
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrder = orderMapper.getAllOrder();
        for (Order order : allOrder) {
            order.getOrder_id().equals("");
            break;
        }

        for (Order order : allOrder) {
            System.out.println(order);
        }


    }

    //测试左连接查询 用association 需要手动设置映射
    //不能使用懒加载 但是查询效率高
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrder = orderMapper.getAllOrder1();
        allOrder.stream().forEach(System.out::println);

    }
    //多对一新增
    //先新增一的一方Customer 再新增多的一方Order
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setCust_name("zyp");

        Order order = new Order();
        order.setOrder_num("250");

        order.setCustomer(customer);

        customerMapper.saveCustomer(customer);
        orderMapper.insertOrder(order);
        sqlSession.commit();
        sqlSession.close();
    }

    //一对多查询 由于要封装成list所以数据要写映射
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allCustomerContainRelOrder = customerMapper.getAllCustomerContainRelOrder();
        for (Customer customer : allCustomerContainRelOrder) {
            System.out.println(customer);
        }
    }

    //一对多新增 需要在新增完毕再维护2长表的关系
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Customer customer = new Customer();
        customer.setCust_name("一对多新增");
        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrder_note("777");
        order.setOrder_num("888");
        Order order1 = new Order();
        order1.setOrder_note("7");
        order1.setOrder_num("8");
        orders.add(order);
        orders.add(order1);
        customer.setOrderList(orders);
        customerMapper.saveCustomer(customer);
        orderMapper.insertOrder(order);
        orderMapper.insertOrder(order1);
        List<Order> orderList = customer.getOrderList();
        for (Order eachOrder : orderList) {
            customerMapper.updateRelaOrder(customer.cust_id,eachOrder.order_id);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    //一对多删除
    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //清除关系
        customerMapper.deleteRelaOrder(22);
        //删除customer
        customerMapper.deleteCustomer(22);
        sqlSession.commit();
        sqlSession.close();
    }

    //多对多 左连接查询
    @Test
    public void test6(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = studentMapper.getAllStudent();
        allStudent.stream().forEach(s-> System.out.println(s));
        sqlSession.commit();
        sqlSession.close();
    }

    //多对多 分步查询 延迟加载
    @Test
    public void test7(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student allStudent = studentMapper.getStudentWithId(1);
        allStudent.getTeachList();
        System.out.println(allStudent);
        sqlSession.commit();
        sqlSession.close();
    }

    //多对多 新增
    @Test
    public void test8(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        TeachMapper teachMapper = sqlSession.getMapper(TeachMapper.class);
        Student student = new Student();
        student.setStu_name("郑勇鹏");
        Teach teach = new Teach();
        teach.setTeach_name("周世元");
        Teach teach1 = new Teach();
        teach1.setTeach_name("林诗瑾");
        student.getTeachList().add(teach);
        student.getTeachList().add(teach1);

        studentMapper.addStudent(student);
        teachMapper.addTeacher(teach);
        teachMapper.addTeacher(teach1);

        for(Teach eachTeach:student.getTeachList()){
            studentMapper.addRelaWithTeach(student.getStu_id(),eachTeach.getTeach_id());
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
