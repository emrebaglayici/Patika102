package InsuranceMS.Adresses;

import InsuranceMS.User;

import java.util.ArrayList;

public class AdressManager{
    private User user;

    public AdressManager(User user) {
        this.user = user;
    }

    public static void addAddresses(User user,IAdress adress){
        user.getAdressList().add(adress);
    }

    public static void removeAddresses(User user,IAdress adress){
        user.getAdressList().remove(adress);
    }
}
