package org.example.models;

import org.example.exceptions.WrongGreekPhoneNumberFormatException;

public class GreekPhoneNumber extends NumberEntity implements NoSpace {


    public void setNumber(String number){
        number=removeSpaces(number);
        if (number.length()!=10 && number.length()!=14){
            throw new WrongGreekPhoneNumberFormatException("INVALID NUMBER. Wrong number of digits.");
        }
        String firstDigit=number.substring(0,1);
        String firstTwoDigits=number.substring(0,2);
        String firstFiveDigits=number.substring(0,5);
        String firstSixDigits=number.substring(0,6);
        if (number.length()==10){
            if (!firstDigit.equals("2") && !firstTwoDigits.equals("69")){
                throw new WrongGreekPhoneNumberFormatException("INVALID NUMBER. Wrong first/second digit of number.");
            }
        } else if (number.length()== 14) {
            if (!firstFiveDigits.equals("00302") && !firstSixDigits.equals("003069")){
                throw new WrongGreekPhoneNumberFormatException("INVALID NUMBER. Wrong first/second digit of number.");
            }
        }
        super.setNumber(number);
    }

    @Override
    public String removeSpaces(String value)
    {
        return value.replaceAll("\\s+", "");
    }


}
