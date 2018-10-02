package com.abetterplanner.controller;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;


public class ControllerTest extends TestCase {

    public ControllerTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(ControllerTest.class);
    }

    public void ControllerTest(){
        assertTrue(true);
    }

    @org.junit.Test
    public void testFunction(){
        Controller controller = new Controller();
        Assert.assertNotNull(controller);
        Assert.assertEquals(5+10, controller.add(5,10));
    }
}
