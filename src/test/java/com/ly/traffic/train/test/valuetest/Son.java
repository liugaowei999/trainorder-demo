package com.ly.traffic.train.test.valuetest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.middleplatform.utils.object.ObjectValue;

/**
 * 描述：儿子
 * Created by Ay on 2016/3/17.
 */
public class Son extends Father {

//身高
private Float height;
//体重
private float weight;

public void play(){
    System.out.println("play play......");
}

public float getHeight() {
    return height;
}

public void setHeight(float height) {
    this.height = height;
}

public float getWeight() {
    return weight;
}

public void setWeight(float weight) {
    this.weight = weight;
}

    @Override
    public String toString() {
        if (this.getClass().getSuperclass() == Father.class) {
            System.out.println("是Father的子类");
        }

        if (this.getClass().getSuperclass() == GrandFather.class) {
            System.out.println("是GrandFather的子类");
        }
        try {
            JSONObject result = ObjectValue.getJSONValue(this.getClass(), this);
            return JSON.toJSONString(result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.toString();
    }



    public static void main(String[] args) {
        Son son = new Son();
        son.setAddress("北京市");
        son.setHeight(1.0f);
        son.setWeight(2.0f);
        String s = son.toString();
        System.out.println(s);
        JSONObject jsonObject = JSON.parseObject(s);
        JSONObject parent = jsonObject.getJSONObject(son.getClass().getSuperclass().getName()).getJSONObject("parent");
        System.out.println(JSON.toJSONString(parent));
        Father father = parent.toJavaObject(Father.class);
        System.out.println(father.getAddress());

    }


}
