package madfinal.employeetracersystem.models;

import org.junit.Test;

import java.util.UUID;

public class UserTest {


    @Test
    public void user_add_is_correct(){
        User user1 = new User();
        user1.id = UUID.randomUUID();
        user1.SSN = 5566;
        user1.salary = 50f;
        user1.address = "Nilüfer / Bursa";
        user1.position = PositionName.Employer;
        user1.telephoneNumber = "5315924501";

    }
}