package InsuranceMS.Insurance;

import java.util.Date;

public abstract class Insurance {
    private String name;
    private double price;
    private Date startEndDate;

    public Insurance(String name, double price, Date startEndDate) {
        this.name = name;
        this.price = price;
        this.startEndDate = startEndDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartEndDate() {
        return startEndDate;
    }

    public void setStartEndDate(Date startEndDate) {
        this.startEndDate = startEndDate;
    }

    abstract double calculate();
}
