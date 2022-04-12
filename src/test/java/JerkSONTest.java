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

    String theRealDEAL = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";

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
        String combine = testWord1 + ";" + testWord2 + ";";
        String split = ";";
        splitMeth.splitAndList(combine,split);
        Assert.assertEquals(2, splitMeth.getListItems().size());
        Assert.assertEquals(testWord1, splitMeth.getListItems().get(0));
        Assert.assertEquals(testWord2, splitMeth.getListItems().get(1));
    }

    //"[^##]"; did not work
    @Test
    void splitAndListTest2(){
        JerkSON splitMeth = new JerkSON();
        String combine = test1Normal1 + "##" + test1Normal2 + "##";
        //String split = "(?<=^|##).+?(?=##)";
        String split = "##";
        splitMeth.splitAndList(combine,split);
        Assert.assertEquals(2, splitMeth.getListItems().size());
        Assert.assertEquals(test1Normal1, splitMeth.getListItems().get(0));
        Assert.assertEquals(test1Normal2, splitMeth.getListItems().get(1));
    }

    @Test
    void splitAndListTest3(){
        JerkSON splitMeth = new JerkSON();
        String split = "##";
        splitMeth.splitAndList(theRealDEAL,split);
    }
}