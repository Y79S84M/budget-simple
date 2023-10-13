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

    public static final String VALID_UPDATE = """
            {
                "bank_account_id":"a3f50b32-1ee7-4ff3-a32b-348b35ee6150",
                "alias":"saving account",
                "type":"saving",
                "balance":"235.95",
                "created_on":"13.05.2023"
            }
            """;
}
