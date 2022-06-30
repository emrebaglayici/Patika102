package InsuranceMS.Insurance;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String name, double price, Date startEndDate) {
        super(name, price, startEndDate);
    }

    @Override
    double calculate() {
        return 0;
    }
}
