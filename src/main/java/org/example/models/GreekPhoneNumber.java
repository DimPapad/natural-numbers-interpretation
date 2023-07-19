package org.example.models;

import lombok.Setter;
import org.example.exceptions.WrongGreekPhoneNumberFormatException;

@Setter
public class GreekPhoneNumber {

    private String number;

    public void setNumber(String number){
        char[] digits=number.toCharArray();
        String firstDigit=number.substring(0,1);
        String firstTwoDigits=number.substring(0,2);
        String firstFiveDigits=number.substring(0,5);
        String firstSixDigits=number.substring(0,6);
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
    public String toString() {
        return "GreekPhoneNumber{" +
                "number='" + number + '\'' +
                '}';
    }


}
