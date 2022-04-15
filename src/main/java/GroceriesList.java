import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceriesList {

    private JerkSONver2 jerkson;
    private List<Groceries> groceriesList;
    public HashMap<String, HashMap<String, Integer>> itemPriceAmount;

    public GroceriesList(JerkSONver2 jerkSON){
        this.jerkson = jerkSON;
        this.itemPriceAmount = new HashMap<>();
        this.groceriesList = new ArrayList<>();
    }

    public List<Groceries> getGroceriesList() {
        return groceriesList;
    }

    public HashMap<String, HashMap<String, Integer>> getItemPriceAmount() {
        return itemPriceAmount;
    }

    public void BuildAndTally(String input){
        buildGroceriesList(input);

    }

    public void buildGroceriesList(String input){
        //jerkson.splitAndList(input, "(?<=^|##).+?(?=##)", true);      //Part 1, divie into seperate items and put in list
        for (String a : jerkson.splitAndList(input, "(?<=^|##).+?(?=##)", true)) {
            groceriesList.add(jerkson.buildGrocery(a));
        }
        while(groceriesList.remove(null));
    }

    public void mapItemPrice(String Item, String regexItem) {
        Integer initialize = 0;
        Integer temp;
        HashMap<String, Integer> PriceAmount = new HashMap<>();
        itemPriceAmount.put(Item, PriceAmount);

        for (Groceries a : groceriesList) {
//            if(a != null){
            Matcher mat = Pattern.compile(regexItem)
                    .matcher(a.getName());
            if (mat.find()) {
                if(!itemPriceAmount.get(Item).containsKey(a.getPrice())){
                    itemPriceAmount.get(Item).put(a.getPrice(), initialize);
                }
                temp = itemPriceAmount.get(Item).get(a.getPrice()) + 1;
                itemPriceAmount.get(Item).put(a.getPrice(), temp);
            }
            //Milk = "[mMiIlLkK]{4}"
        }
//        }
    }

    public HashMap<String, Integer> getPriceAmntMap(String key){
        return itemPriceAmount.get(key);
    }

    //public void MapItemFirst(String){}
}
