package Properties;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Properties properties=new Properties();
        Set states;
        String str;

        properties.setProperty("Turkey","Ankara");

        states=properties.keySet();
        Iterator itr=states.iterator();
        while (itr.hasNext()){
            str= (String) itr.next();
            System.out.println(str+" "+properties.getProperty(str));
        }

        str=properties.getProperty("Turkey","Not Found");
        System.out.println(str);

        Properties prop2= (Properties) properties.clone();
        prop2.setProperty("ABD","Washington");
        String str2=prop2.getProperty("ABD");
        System.out.println(str2);
    }
}
