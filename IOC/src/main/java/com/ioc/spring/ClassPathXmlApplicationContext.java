package com.ioc.spring;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hengluwen on 16/8/5.
 */
public class ClassPathXmlApplicationContext implements BeanFactory{

    private Map<String , Object> beans = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext() throws JDOMException,IOException,InstantiationException,IllegalAccessException,
            ClassNotFoundException,SecurityException,NoSuchMethodException,IllegalArgumentException,InvocationTargetException{
        SAXBuilder sb = new SAXBuilder();

        //构造文档对象
        Document doc = sb.build(ClassPathXmlApplicationContext.class.getClassLoader().getResourceAsStream("beans.xml"));
        //获取根元素 beans
        Element root = doc.getRootElement();
        //取到根元素所以子元素 bean
        List list = root.getChildren();

        for(int i=0; i<list.size(); i++){
            Element element = (Element)list.get(i);
            //获取id子元素
            String beanId = element.getAttributeValue("id");
            //获取class子元素
            String clzss = element.getAttributeValue("class");
            //实例化
            Object o = Class.forName(clzss).newInstance();
            //将所有bean放入到map中。
            beans.put(beanId,o);

            //获取property 进行依赖注入
            for(Element propertyElement : (List<Element>) element.getChildren()){
                String name = propertyElement.getAttributeValue("name");

                String bean = propertyElement.getAttributeValue("bean");

                Object beanObj = this.getBean(bean);
                // 形成setXXX方法名
                String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
                // 反射机制对方法进行调用，将对象在加载bean时就注入到环境上下文中

                Method m = o.getClass().getMethod(methodName,beanObj.getClass().getInterfaces()[0]);

                // 执行注入,相当于执行了一个setXXX(args..)的方法
                m.invoke(o,beanObj);
            }
        }

    }


    public Object getBean(String name) {
        return this.beans.get(name);
    }
}
