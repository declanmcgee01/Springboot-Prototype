package com.qa.account.util.generators;

import com.qa.account.util.constants.Constants;

public class EightAccountGen extends AbstractAccountGen {

    @Override
    public String getGeneratedNumber() { return generateRoomNumber(Constants.THREE_DIGIT_ACCOUNT); }

}
