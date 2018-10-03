package com.abetterplanner.controller;
import org.apache.commons.rng.RandomSource;


public class Controller {

    public int add(int x, int y){
        return x+y;
    }
    public String hello(){
        String a = "Hello";
        return a;
    }
    
    public void test() {
    	double[] mean = {1,2}
    	double[] cov = {{9,c}, {c, 16}}
    	RealMatrix covariance = MaxrixUtils.createRealMatrix(cov)
    	return covariance;
    }
}
