package InsuranceMS.Insurance;

import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance(String name, double price, Date startEndDate) {
        super(name, price, startEndDate);
    }

    @Override
    double calculate() {
        return 0;
    }
}
