import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSON {

    List<String> listItems;
    String defaultRegex1 = "(?<=^|##).+?(?=##)";

    public JerkSON() {
        this.listItems = new ArrayList<>();
    }
    //String tokens;

    public int tokenScan(String input) {
        int count = 0;
        Scanner scan = new Scanner(input);
        while (scan.hasNext()){
            count++;
            System.out.println(scan.next());
        }
        scan.close();
        return count;
    }

    public List<String> parseToList(String input) {
        List<String> ListItems = new ArrayList<>();
        Scanner scan = new Scanner(input);
        while(scan.hasNext()){
            ListItems.add(scan.next());
        }
        scan.close();
        return ListItems;
    }

    public String replaceWithSpace(String inputString, String regex) { //Cant use due to manipulation
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(inputString);
        mat.replaceAll(" ");
        System.out.println(inputString);

        return inputString;
    }

    public List<String> splitAndList(String inputString, String regex){
        List<String> output = new ArrayList<>();
        //Spoiler! (?<=^|[;@^*%!]).+?(?=[;@^*%!])   [;@^*%!]
        //String divider = "(?<=^|" + regex +").+?(?=" + regex +")";  //Original

        String divider = "(?<=^|" + regex +").+?(?=" + regex +")";
        Matcher mat = Pattern.compile(divider, Pattern.CASE_INSENSITIVE)
                .matcher(inputString);
        while(mat.find()){
            output.add(mat.group() + ";");
            listItems.add(mat.group() + ";");
        }
        iterate(output);
        return output;
    }

    public List<String> getListItems(){
        return this.listItems;
    }

    public void iterate(List<String> item){
        Iterator it = item.iterator();
        System.out.println("List of Matches: \n");
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
