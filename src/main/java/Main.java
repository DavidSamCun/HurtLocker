import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        JerkSONver2 jerkSONver2 = new JerkSONver2();
        GroceriesList groceriesList = new GroceriesList(jerkSONver2);

        String output = (new Main()).readRawDataToString();

        System.out.println(output);

        groceriesList.buildGroceriesList(output); //Step 1
        groceriesList.mapItemPrice("Milk", "[mMiIlLkK]{4}");
        groceriesList.mapItemPrice("Cookies", "[cCoO0kKIieEsS]{7}");


    }
}
