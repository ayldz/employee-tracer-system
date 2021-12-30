package madfinal.employeetracersystem.models;

import java.sql.Timestamp;
import java.util.UUID;

public  class Request{
    public UUID requestID;
    public int employyeeSSN;
    public RequestType type;
    public boolean isApproved;

    public float amount;
    public String excuse;
    public Timestamp startDate;
    public Timestamp endDate;

    public void request(RequestType type){
        switch (type){
            case ADVANCE_PAYMENT:
                break;
            case PERMIT_DAY:
                break;
            default:
                break;
        }
    }
}
