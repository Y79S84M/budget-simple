package fr.saintmartin.yohan.busi.enumeration;

public enum Periodicity {
    NONE(0),
    WEEKLY(1),
    MONTHLY(2),
    BIMONTHLY(3),
    QUARTERLY(4),
    BIANNUAL(5),
    YEARLY(6);
    private final int code;
    Periodicity(int code){
        this.code = code;
    }
    public int code() {
        return this.code;
    }
}
