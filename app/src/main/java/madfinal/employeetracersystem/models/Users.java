package madfinal.employeetracersystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public  class Users {
    private static List<User> users = new ArrayList<>();

    private static boolean isInit = false;

    public static void init()    {
        //TODO: firebase integration

        User user = new User();
        user.id = UUID.randomUUID();
        user.SSN = 180709019;
        user.position = PositionName.Employer;
        user.telephoneNumber = "5315924501";
        user.address = "mentese/ mugla";
        user.salary = 3000;
        user.name = "Alperen";
        user.surname = "Ayyıldız";

        users.add(user);

        User user2 = new User();
        user2.id = UUID.randomUUID();
        user2.SSN = 180709029;
        user2.position = PositionName.Employee;
        user2.telephoneNumber = "5315924501";
        user2.address = "mentese/ mugla";
        user2.salary = 3000;
        user2.name = "Zehra";
        user2.surname = "Rıdvanoğulları";

        users.add(user2);

        isInit = true;
    }

    public static void addUser(User user){
        if (!isInit) init();
        users.add(user);
    }

    public static User getUser(int SSN){
        if (!isInit) init();

        for (User item : users){
            if (item.SSN == SSN) return item;
        }
        return null;
    }
}
