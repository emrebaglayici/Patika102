package InsuranceMS.Insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String name, double price, Date startEndDate) {
        super(name, price, startEndDate);
    }

    @Override
    double calculate() {
        return 0;
    }
}
