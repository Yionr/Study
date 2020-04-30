package cn.yionr;

import cn.yionr.beans.Bean1;
import cn.yionr.beans.ComplexBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ComplexBean bean = ac.getBean("complexBean",ComplexBean.class);
//        System.out.println(Arrays.toString(bean.getArr()));
//        System.out.println(bean.getBean1s());
//        System.out.println(bean.getMap());
//        System.out.println(bean.getProperties());
        System.out.println(ac.getBean("bean1",Bean1.class).getChild().getX());
        Bean1 bean12 = ac.getBean("bean12", Bean1.class);
        System.out.println(bean12.getChild().getX());
    }

}
