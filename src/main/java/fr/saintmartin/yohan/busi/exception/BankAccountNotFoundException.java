package fr.saintmartin.yohan.busi.exception;

import fr.saintmartin.yohan.busi.dto.BankAccountDTO;
import jakarta.persistence.EntityNotFoundException;

public class BankAccountNotFoundException extends EntityNotFoundException {

    private BankAccountDTO bkAccData;

    public BankAccountNotFoundException(String message, BankAccountDTO dataSubmitted) {
        super(message);
        bkAccData = dataSubmitted;
    }

    public BankAccountDTO getBkAccData() {
        return bkAccData;
    }

    public void setBkAccData(BankAccountDTO bkAccUpdate) {
        this.bkAccData = bkAccUpdate;
    }
}
