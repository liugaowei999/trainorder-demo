package com.ly.traffic.train.infrastructure.test.shape.impl;


import com.ly.traffic.middleplatform.apt.annotation.Factory;
import com.ly.traffic.train.infrastructure.test.shape.interfaces.IShape;

@Factory(id = "Rectangle", type = IShape.class)
public class Rectangle implements IShape {
	@Override
	public void draw() {
		System.out.println("Draw a Rectangle");
	}
}
