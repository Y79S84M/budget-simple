package fr.saintmartin.yohan.busi.exception;

import fr.saintmartin.yohan.busi.dto.BankAccountInfo;
import jakarta.persistence.EntityNotFoundException;

public class BankAccountNotFoundException extends EntityNotFoundException {

    private BankAccountInfo bkAccInfo;

    public BankAccountNotFoundException(String message, BankAccountInfo dataSubmitted) {
        super(message);
        bkAccInfo = dataSubmitted;
    }

    public BankAccountInfo getBkAccInfo() {
        return bkAccInfo;
    }

    public void setBkAccInfo(BankAccountInfo bkAccInfo) {
        this.bkAccInfo = bkAccInfo;
    }
}
