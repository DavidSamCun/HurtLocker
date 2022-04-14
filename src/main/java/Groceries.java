import java.time.LocalDate;
import java.util.Date;

public class Groceries {


    private String name;
    private String price;
    private String type;
    private String date;

    public Groceries(String name, String price, String type, String date) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
