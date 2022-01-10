package madfinal.employeetracersystem.models;

import java.util.ArrayList;
import java.util.List;

public class Checks {
    private List<Check> checks = new ArrayList<>();

    public void addCheck(Check check){
        checks.add(check);
    }

    public Check getCheck(int userSSN){
        for (Check check : checks){
            if (check.userSSN == userSSN) return check;
        }
        return null;
    }

    public List<Check> getAllChecks(){
        return checks;
    }
}
