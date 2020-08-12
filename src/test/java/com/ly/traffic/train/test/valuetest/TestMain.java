package com.ly.traffic.train.test.valuetest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author liugw
 * @Package com.ly.traffic.train.test
 * @Description: ${TODO}
 * @date 2020/7/20 15:32
 */
public class TestMain {
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) throws IllegalAccessException {
        Son student = new Son( );
        student.setAddress("北京市");
        student.setHeight(1.0f);
        student.setWeight(2.0f);
        Map<String,Object> mapValues = Maps.newHashMap();
        // 获取属性
        Map<String,Field> map = getClassFields (student.getClass ( ),true);

        for ( Map.Entry<String, Field> entry : map.entrySet ( ) ){
            System.out.println ( "<field=" + entry.getKey().toString ( ) + "> <Type=" + map.get ( entry.getKey() ) + ">" );
            if (entry.getValue().get(student) == null) {
                System.out.println("未设置");
            } else {
                mapValues.put(entry.getKey().toString (), entry.getValue().get(student));
                System.out.println("value:" + entry.getValue().get(student));
            }
        }
        // JSONSTRing
        System.out.println(JSON.toJSONString(mapValues));

        String JSONStr = "{\"address\":\"天津市\",\"weight\":12.0,\"height\":11.0}";
        Son son = JSON.parseObject(JSONStr, Son.class);
        System.out.println(son.getAddress());

        // 获取方法
//        List<Method> methods = getMothds ( student.getClass ( ), true );
//        for ( Method method : methods ){
//            System.out.println ( method.getName ( ) );
//        }
//        System.out.println ( "方法总数：" + methods.size ( ) );
    }



    /**
     * 获取类实例的属性值
     * @param clazz
     *            类名
     * @param includeParentClass
     *            是否包括父类的属性值
     * @return 类名.属性名=属性类型
     */
    public static Map<String,Field> getClassFields(Class clazz,boolean includeParentClass ){
        Map<String,Field> map = new HashMap<String,Field>();
        //返回Class 对象所表示的类或接口的指定已声明字段
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            //将字段名作为key，field作为value
            field.setAccessible(true);
            map.put(field.getName(),field);
        }
        if (includeParentClass){
            //clazz.getSuperclass()
            // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class
            getParentClassFields(map,clazz.getSuperclass());
        }
        return map;
    }

    /**
     * 获取类实例的父类的属性值
     * @param map
     *            类实例的属性值Map
     * @param clazz
     *            类名
     * @return 类名.属性名=属性类型
     */
    private static Map<String,Field> getParentClassFields(Map<String,Field> map, Class clazz){
        Field[] fields = clazz.getDeclaredFields ();
        for(Field field:fields){
            field.setAccessible(true);
            map.put (field.getName(),field);
        }
        if(clazz.getSuperclass() == null){
            return map;
        }
        //不断调用getParentClassFields(),知道没有父类为止
        getParentClassFields(map,clazz.getSuperclass());
        return map;
    }

    /**
     * 获取类实例的方法
     * @param clazz
     *            类名
     * @param includeParentClass
     *            是否包括父类的方法
     * @return List
     */
    public static List<Method>getMothds (Class clazz, boolean includeParentClass )
    {
        List<Method> list = new ArrayList< Method >();
        Method[] methods = clazz.getDeclaredMethods ();
        for (Method method : methods){
            list.add (method);
        }
        if (includeParentClass){
            getParentClassMothds (list,clazz.getSuperclass());
        }
        return list;
    }

    /**
     * 获取类实例的父类的方法
     * @param list
     *            类实例的方法List
     * @param clazz
     *            类名
     * @return List
     */
    private static List<Method> getParentClassMothds(List<Method> list, Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            list.add(method);
        }
        if(clazz.getSuperclass() == Object.class){
            return list;
        }
        getParentClassMothds(list,clazz.getSuperclass());
        return list;
    }

}
