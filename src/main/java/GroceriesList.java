import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceriesList {

    private JerkSONver2 jerkson;
    private List<Groceries> groceriesList;
    private HashMap<String, HashMap<String, Integer>> ItemPriceAmount;

    public GroceriesList(JerkSONver2 jerkSON){
        this.jerkson = jerkSON;
        this.groceriesList = new ArrayList<>();
    }

    public List<Groceries> getGroceriesList() {
        return groceriesList;
    }

    public HashMap<String, HashMap<String, Integer>> getItemPrimeAcount() {
        return ItemPriceAmount;
    }

    public void buildGroceriesList(String input){
        //jerkson.splitAndList(input, "(?<=^|##).+?(?=##)", true);      //Part 1, divie into seperate items and put in list
        for (String a : jerkson.splitAndList(input, "(?<=^|##).+?(?=##)", true)) {
            groceriesList.add(jerkson.buildGrocery(a));
        }
    }

    public void MapItemPrice(String regexItem, String Item) {
        Integer initialize = 0;
        Integer temp;
        HashMap<String, Integer> PriceAmount = new HashMap<>();
        ItemPriceAmount.put(Item, PriceAmount);

        for (Groceries a : groceriesList) {
            Matcher mat = Pattern.compile(regexItem)
                    .matcher(a.getName());
            if (mat.find()) {
                if(!ItemPriceAmount.get(Item).containsKey(mat.group())){
                    ItemPriceAmount.get(Item).put(a.getPrice(), initialize);
                }
                temp = ItemPriceAmount.get(Item).get(a.getPrice()) + 1;
                ItemPriceAmount.get(Item).put(a.getPrice(), temp);
            }
            //Milk = "[mMiIlLkK]{4}"
        }
    }

    //public void MapItemFirst(String){}
}
