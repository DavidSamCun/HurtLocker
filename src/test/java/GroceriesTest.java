import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class GroceriesTest {

    String test1Normal = "Name:Milk;Price:3.23;type:food;expiration:1/24/2016";
    String test2Double = "Name:Milk;Price:3.23;type:food;expiration:1/24/2016##Name:cookies;Price:1.23;type:food;expiration:1/24/2014##";

    @Test
    public void constructorTest(){
        Groceries construct = new Groceries("Milk", "3.23", "Food", "01/21/2020");

    }

}