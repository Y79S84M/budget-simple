package fr.saintmartin.yohan.busi.fixtures;

public class BankAccountFixtures {
    public static final String VALID_CREATION = """
    {
        "alias": "joint account",
        "balance": 342.76,
        "type": "current"
    }
    """;
    public static final String NOT_VALID_CREATION = """
    {
        "alias": "",
        "balance": 0,
        "type": "current"
    }
    """;
}
