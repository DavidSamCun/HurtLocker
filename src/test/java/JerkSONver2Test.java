import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JerkSONver2Test {

    String test1Normal2 = "Name:cookies;Price:1.23;type:food;expiration:1/24/2014;";
    String test2Double = "Name:Milk;Price:3.23;type:food;expiration:1/24/2016##Name:cookies;Price:1.23;type:food;expiration:1/24/2014##";
    String theRealDEAL = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";


    @Test
    void splitAndList() {
        JerkSONver2 testSplit = new JerkSONver2();
        String testme = test1Normal2;

        String expected = "cookies";
        Assert.assertEquals(expected, testSplit.splitAndList(testme, "(?<=[:]).+?(?=[:;@^*%!])", false).get(0));


    }

    @Test
    void buildGrocery() {
    }

    @Test
    void getListItems() {
    }

    @Test
    void iterate() {
    }


    @Test
    void buildGroceriesList() {
        JerkSONver2 testSplitGroceriesList = new JerkSONver2();
        String testme = test2Double;

        testSplitGroceriesList.buildGroceriesList(testme);

    }


}