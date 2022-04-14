import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONver2 {

    List<String> listItems;
    List<Groceries> groceriesList;
    String defaultRegex1 = "(?<=^|##).+?(?=##)";
    Integer exceptionCatches = 0;

    public JerkSONver2() {
        this.listItems = new ArrayList<>();
        this.groceriesList = new ArrayList<>();
    }

    public List<String> getListItems(){
        return this.listItems;
    }

    public List<Groceries> getGroceriesList() {
        return groceriesList;
    }


    public void buildGroceriesList(String input){
        splitAndList(input, "(?<=^|##).+?(?=##)", true);      //Part 1, divie into seperate items and put in list


        for (String a : splitAndList(input, "(?<=^|##).+?(?=##)", true)) {
            buildGrocery(a);
        }




    }




    public List<String> splitAndList(String inputString, String regex, Boolean part1){
        List<String> output = new LinkedList<>();
        //Spoiler! (?<=^|[;@^*%!]).+?(?=[;@^*%!])   [;@^*%!]        divider
        //String divider = "(?<=^|" + regex +").+?(?=" + regex +")";  //Original

        //String split = "(?<=^|##).+?(?=##)";            // part 1, parsing list Correct
        //String divider = "(?<=[:;@^*%!]).+?(?=[:;@^*%!])" // part 2, parsing groceries

        //String divider2 = "(?<=[:]).+?(?=[:;@^*%!])"      // part 2 the better choice This will split it into items

        Matcher mat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
                .matcher(inputString);
        while(mat.find()){
            if(part1){
                output.add(mat.group() + ";");
                listItems.add(mat.group() + ";");
            }
            else{
                output.add(mat.group());
                listItems.add(mat.group());
            }

        }

        iterate(output); //for testing

        return output;
    }

    public Groceries buildGrocery (String input){
        List<String> inputDivided = splitAndList(input, "(?<=[:]).+?(?=[:;@^*%!])" , false);
        Boolean foundError = false;

        for(String a: inputDivided){
            Matcher mat = Pattern.compile("[:;@^*%!]")
                    .matcher(a);
            if(mat.find()){
                exceptionCatches++;
                break;
            }
        }
        Groceries item = new Groceries(inputDivided.get(0), inputDivided.get(1), inputDivided.get(2), inputDivided.get(3));
        return item;
    }




    public void iterate(List<String> item){
        Iterator it = item.iterator();
        System.out.println("List of Matches: \n");
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}