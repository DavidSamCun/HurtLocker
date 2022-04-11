import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSON {

    List<String> listItems;

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

    public void splitAndList(String inputString, String regex){
//        Pattern pat = Pattern.compile(regex);
//        Matcher mat = pat.matcher(inputString);
        Matcher mat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
                .matcher(inputString);

        while(mat.find()){
            listItems.add(mat.group());
        }
        Iterator it = listItems.iterator();
        System.out.println("List of Matches: \n");
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public List<String> getListItems(){
        return this.listItems;
    }
}
