package madfinal.employeetracersystem.models;


import com.google.firebase.Timestamp;

public  class Request{
    public long employyeeSSN;
    public RequestType type;
    public boolean isApproved;

    public long amount;
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
