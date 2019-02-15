package com.qa.account.util.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.qa.account.util.constants.Constants;

public abstract class AbstractAccountGen {

    private List<String> accountNumList = new ArrayList<>();

    public abstract String getGeneratedNumber();

    protected String generateRoomNumber(int accountLength){
        String generatedRoomNumber = constructString(accountLength);
        while(accountNumList.contains(generatedRoomNumber)){
            generatedRoomNumber = constructString(accountLength);
        }
        accountNumList.add(generatedRoomNumber);
        return generatedRoomNumber;
    }

    private String constructString(int length){
        StringBuilder rmNum = new StringBuilder();
        int typeSelector = new Random().nextInt(Constants.FLOOR_OF_ROOMS);

        switch(typeSelector){
            case 0:
                rmNum.append(Constants.ROOM_FLOOR_A);
                break;
            case 1:
                rmNum.append(Constants.ROOM_FLOOR_B);
                break;
            case 2:
                rmNum.append(Constants.ROOM_FLOOR_C);
                break;
            case 3:
                rmNum.append(Constants.ROOM_FLOOR_D);
                break;
            case 4:
                rmNum.append(Constants.ROOM_FLOOR_E);
                break;
        }

        for (int j = 0; j < length; j++) {
            rmNum.append(generateDigit());
        }
        return rmNum.toString();
    }

    private String generateDigit(){
        return new Random().nextInt(10)+"";
    }
    
    public void setAccountNumList(List<String> accountNumList) {
    	this.accountNumList = accountNumList;
    }
}