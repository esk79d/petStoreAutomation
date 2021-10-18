package utils;

public class CommonUtils {
    public String RandomNumber(){
        double randomNum = Math.random();
        randomNum=randomNum*(10000000000000L);
        randomNum=Math.floor(randomNum);
        String randomValue = String.format ("%.0f", randomNum);
        randomValue="224455"+randomValue;
        return randomValue;
    }

    public String replaceString(String completeString,String valuePresent,String valueToBeReplaced)
    {
        completeString=completeString.replaceAll(valuePresent,valueToBeReplaced);
        return completeString;
    }
}
