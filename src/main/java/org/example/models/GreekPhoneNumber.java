package org.example.models;

import lombok.Getter;
import lombok.ToString;
import org.example.exceptions.WrongGreekPhoneNumberFormatException;

@Getter
@ToString
public class GreekPhoneNumber extends OutputEntity implements NoSpaceOutput{


    private String number;

    public void setNumber(String number){
        number=removeSpaces(number);
        char[] digits=number.toCharArray();
        String firstDigit=null;
        String firstTwoDigits=null;
        String firstFiveDigits=null;
        String firstSixDigits=null;
        try {
            firstDigit=number.substring(0,1);
            firstTwoDigits=number.substring(0,2);
            firstFiveDigits=number.substring(0,5);
            firstSixDigits=number.substring(0,6);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        if (digits.length!=10 && digits.length!=14){
            throw new WrongGreekPhoneNumberFormatException("INVALID NUMBER. Wrong number of digits.");
        }
        if (digits.length==10){
            if (!firstDigit.equals("2") && !firstTwoDigits.equals("69")){
                throw new WrongGreekPhoneNumberFormatException("INVALID NUMBER. Wrong first/second digit of number.");
            }
        } else if (digits.length == 14) {
            if (!firstFiveDigits.equals("00302") && !firstSixDigits.equals("003069")){
                throw new WrongGreekPhoneNumberFormatException("INVALID NUMBER. Wrong first/second digit of number.");
            }
        }
        this.number=number;
    }

    @Override
    public String removeSpaces(String value)
    {
        return value.replaceAll("\\s+", "");
    }


}
