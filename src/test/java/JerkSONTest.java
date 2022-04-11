import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JerkSONTest {
    String testWord0 = "";
    String testWord1 = "test";
    String testWord2 = "cake";
    String testWord3 = "test cake";
    String testWord4 = "test;cake;";

    String testCrazy1 = "t3st";
    String testCrazy2 = "t3st CAk3";
    String testCrazy3 = "t3st;CAk3;";

    String test1Normal1 = "Name:Milk;Price:3.23;type:food;expiration:1/24/2016";
    String test1Normal2 = "Name:cookies;Price:1.23;type:food;expiration:1/24/2014";
    String test2Double = "Name:Milk;Price:3.23;type:food;expiration:1/24/2016##Name:cookies;Price:1.23;type:food;expiration:1/24/2014##";


    @Test
    void tokenScanTest() {
        JerkSON scanMeth = new JerkSON();
        Assert.assertEquals(1, scanMeth.tokenScan(testWord1));
    }

    @Test
    void tokenScanTest2(){
        JerkSON scanMeth = new JerkSON();
        Assert.assertEquals(2,scanMeth.tokenScan(testWord3));
    }

    @Test
    void tokenScanTest3(){
        JerkSON scanMeth = new JerkSON();
        Assert.assertEquals(1, scanMeth.tokenScan(testWord4));
    }

    @Test
    void tokenScanTest4(){
        JerkSON scanMeth = new JerkSON();
        Assert.assertEquals(0, scanMeth.tokenScan(testWord0));
    }
    @Test
    void parseToListTest1() {
        JerkSON scanMeth = new JerkSON();
        Assert.assertEquals(1, scanMeth.parseToList(testWord1).size());
    }

    @Test
    void parseToListTest2(){
        JerkSON scanMeth = new JerkSON();
        Assert.assertEquals(2, scanMeth.parseToList(testWord3).size());
    }

    @Test
    void splitTest(){
        JerkSON scanMeth = new JerkSON();
        String divider = ";";

        Assert.assertEquals("test cake", scanMeth.replaceWithSpace(testWord2, divider));
    }

    @Test
    void splitAndListTest1(){
        JerkSON splitMeth = new JerkSON();
        String combine = testWord1 + "##" + testWord2 + "##";
        String split = "test";
        splitMeth.splitAndList(combine,split);
        Assert.assertEquals(1, splitMeth.getListItems().size());
        Assert.assertEquals(testWord1, splitMeth.getListItems().get(0));
        //Assert.assertEquals(testWord2, splitMeth.getListItems().get(1));
    }

    //"[^##]"; did not work
    @Test
    void splitAndListTest2(){
        JerkSON splitMeth = new JerkSON();
        String combine = test1Normal1 + "##" + test1Normal2 + "##";
        String split = "[^##]";
        splitMeth.splitAndList(combine,split);
        Assert.assertEquals(2, splitMeth.getListItems().size());
        Assert.assertEquals(test1Normal1, splitMeth.getListItems().get(0));
        Assert.assertEquals(test1Normal2, splitMeth.getListItems().get(1));
    }

}