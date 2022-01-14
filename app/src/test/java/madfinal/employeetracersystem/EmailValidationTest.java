package madfinal.employeetracersystem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertEquals;

import madfinal.employeetracersystem.models.User;
import madfinal.employeetracersystem.models.Users;


public class EmailValidationTest {

    Pattern pattern = Pattern.compile("^.+@.+\\..+$");

    @Test
    public void userIsValid() {

        for (User user : Users.getAllUsers()){
           Matcher matcher = pattern.matcher( user.email);
            assertEquals(matcher.matches(), true);
        }

    }
}
