package spring.aop;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import spring.aop.bean.Car;
import spring.aop.bean.Wheel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 简单IOC的demo
 * @author: yifan
 * @date: 2019/8/20 11:48
 */
public class MyIOCDemo {
    private Map<String, Object> beanMap = new HashMap<String, Object>();

    public MyIOCDemo(String xmlPath) {
        loadBeans(xmlPath);
    }

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("There is no bean with name" + name);
        }
        return bean;
    }


    private void loadBeans(String xmlPath) {
        try (InputStream input = new FileInputStream(xmlPath);) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(input);
            Element root = doc.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            //循环每个结点
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node instanceof Element) {
                    Element ele = (Element) node;
                    String id = ele.getAttribute("id");
                    String className = ele.getAttribute("class");

                    //加载 beanClass
                    Class beanClass = null;
                    beanClass = Class.forName(className);

                    //创建 bean
                    Object bean = beanClass.newInstance();

                    //遍历<property>标签
                    NodeList propertyNodes = root.getElementsByTagName("property");
                    for (int j = 0; j < propertyNodes.getLength(); j++) {
                        Node properthNode = propertyNodes.item(j);
                        if (properthNode instanceof Element) {
                            Element propertyElement = (Element) properthNode;
                            String name = propertyElement.getAttribute("name");
                            String value = propertyElement.getAttribute("value");

                            //反射将bean相关字段的访问权限设置为可访问
                            Field declareField = bean.getClass().getDeclaredField(name);
                            declareField.setAccessible(true);
                            //属性填充
                            if (value != null && value.length() > 0) {
                                declareField.set(bean, value);
                            } else {
                                String ref = propertyElement.getAttribute("ref");
                                if (ref == null || ref.length() == 0) {
                                    throw new IllegalArgumentException("ref config error");
                                }
                                //将引用填充到相关字段中
                                declareField.set(bean, getBean(ref));
                            }
                            //将引用填充到相关字段中
                            beanMap.put(id, bean);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args){
        String location = MyIOCDemo.class.getClassLoader()
                .getResource("ioc/ioc-test.xml")
                .getFile();
        System.out.println(location);
        MyIOCDemo demo = new MyIOCDemo(location);
        Wheel wheel = (Wheel) demo.getBean("wheel");
        System.out.println(wheel.toString());
        Car car = (Car) demo.getBean("car");
        System.out.println(car.toString());
    }
}
