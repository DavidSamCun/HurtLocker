import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class GroceriesListTest {

    String test1Normal2 = "Name:cookies;Price:1.23;type:food;expiration:1/24/2014;";
    String test2Double = "Name:Milk;Price:3.23;type:food;expiration:1/24/2016##Name:cookies;Price:1.23;type:food;expiration:1/24/2014##Name:Milk;Price:3.10;type:food;expiration:1/25/2016##";
    String test3Double = "Name:;Price:3.23;type:food;expiration:1/24/2016##Name:cookies;Price:1.23;type:food;expiration:1/24/2014##Name:Milk;Price:3.10;type:food;expiration:1/25/2016##";

    String theRealDEAL = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
    JerkSONver2 jerksonV2 = new JerkSONver2();

    @Test
    void getGroceriesList() {

        GroceriesList groceriesList = new GroceriesList(jerksonV2);

        groceriesList.buildGroceriesList(test3Double);
        int expected = 2;

        Assert.assertEquals(expected, groceriesList.getGroceriesList().size());
    }

    @Test
    void getItemPriceAmount() {

        GroceriesList groceriesList = new GroceriesList(jerksonV2);

        groceriesList.buildGroceriesList(test2Double);

        groceriesList.mapItemPrice("milk", "[mMiIlLkK]{4}");
        int expected = 2;


        Assert.assertEquals(expected, groceriesList.getItemPriceAmount().get("milk").size());


    }

    @Test
    void getItemPriceAmountCookies() {

        GroceriesList groceriesList = new GroceriesList(jerksonV2);

        groceriesList.buildGroceriesList(theRealDEAL);

        groceriesList.mapItemPrice("Cookies", "[cCoO0kKIieEsS]{7}");
        int expected = 8;

        int total = 0;

                for (HashMap.Entry<String, Integer> a: groceriesList.getItemPriceAmount().get("Cookies").entrySet()){
                    total += a.getValue();
        }

        Assert.assertEquals(expected, total);


    }

    @Test
    void getItemPriceAmountMilk() {

        GroceriesList groceriesList = new GroceriesList(jerksonV2);

        groceriesList.buildGroceriesList(theRealDEAL);

        groceriesList.mapItemPrice("Milk", "[mMiIlLkK]{4}");
        int expected = 6;

        int total = 0;

        for (HashMap.Entry<String, Integer> a: groceriesList.getItemPriceAmount().get("Milk").entrySet()){
            total += a.getValue();
        }

        Assert.assertEquals(expected, total);


    }

    @Test
    void getItemPriceAmountBread() {

        GroceriesList groceriesList = new GroceriesList(jerksonV2);

        groceriesList.buildGroceriesList(theRealDEAL);

        groceriesList.mapItemPrice("Bread", "[BbrReEaAdD]{5}");
        int expected = 6;

        int total = 0;

        for (HashMap.Entry<String, Integer> a: groceriesList.getItemPriceAmount().get("Bread").entrySet()){
            total += a.getValue();
        }

        Assert.assertEquals(expected, total);


    }

    @Test
    void getItemPriceAmountApples() {

        GroceriesList groceriesList = new GroceriesList(jerksonV2);

        groceriesList.buildGroceriesList(theRealDEAL);

        groceriesList.mapItemPrice("Apples", "[aApPpPlLeEsS]{6}");
        int expected = 4;

        int total = 0;

        for (HashMap.Entry<String, Integer> a: groceriesList.getItemPriceAmount().get("Apples").entrySet()){
            total += a.getValue();
        }

        Assert.assertEquals(expected, total);


    }

    @Test
    void mapItemPrice() {
    }
}