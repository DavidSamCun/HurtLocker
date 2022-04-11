import java.time.LocalDate;
import java.util.Date;

public class Groceries {


    private String name;
    private double price;
    private String type;
    private String date;

    public Groceries(String name, double price, String type, String date) {
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

    public double getPrice() {
        String test = "test";

        return price;
    }
    String test = "test";

    public void setPrice(double price) {
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
