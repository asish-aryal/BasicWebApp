package com.develogical;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        String question = query.toLowerCase();
        if (question.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (question.contains("what is your name")) {
            return "TDD Cow";
        }
        if (question.contains("what is") && question.contains("plus")) {
            return String.valueOf(addAllNumbers(extractNumbersFromString(question)));
        }


        if (question.contains("what is") && question.contains("multiplied")) {
            return String.valueOf(timesNumbers(extractNumbersFromString(question)));
        }


        if (question.contains("largest")) {
            return String.valueOf(largestNumber(extractNumbersFromString(question)));
        }

        if(question.contains("which city is the eiffel tower in")){
            return "Paris";
        }

        if(question.contains("which of the following numbers are primes")){
            return String.valueOf(findPrime(extractNumbersFromString(question)));
        }

        return "";
    }

    private ArrayList<Integer> extractNumbersFromString(String inputText) {
        Pattern numberCatcher = Pattern.compile("[0-9]+");
        Matcher matcher = numberCatcher.matcher(inputText);
        ArrayList<Integer> toReturn = new ArrayList<>();

        while (matcher.find()) {
            toReturn.add(Integer.valueOf(matcher.group()));
        }
        return toReturn;
    }


    private int addAllNumbers(ArrayList<Integer> numberList) {
        int total = 0;
        for (int number : numberList) {
            total = total + number;
        }
        return total;
    }

    private int findPrime(ArrayList<Integer> numberList){
        for(int number: numberList){
            if(isPrime(number)){
                return number;
            }
        }
        return 0;
    }

    public boolean isPrime(int possiblePrime){
        if (possiblePrime < 1)
            return false;
        else if (possiblePrime == 2)
            return true;
        else {
            for(int i = 2; i < (possiblePrime/2 - 1); i++){
                if(possiblePrime % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }








    private int timesNumbers(ArrayList<Integer> numberList) {
        int total = 1;
        for (int number : numberList) {
            total = total * number;
        }
        return total;
    }

    private int largestNumber(ArrayList<Integer> numberList) {
        int total = 0;
        for (int number : numberList) {
            if(number > total){
                total = number;
            }
        }
        return total;
    }




}
