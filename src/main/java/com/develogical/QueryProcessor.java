package com.develogical;

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
            Pattern numberCatcher = Pattern.compile("[0-9]+");
            Matcher matcher = numberCatcher.matcher(question);
            int accumulator = 0;

            while(matcher.find()){
                accumulator = accumulator + Integer.valueOf(matcher.group());
            }

            return String.valueOf(accumulator);
        }


        if (question.contains("what is") && question.contains("multiplied")) {
            Pattern numberCatcher = Pattern.compile("[0-9]+");
            Matcher matcher = numberCatcher.matcher(question);
            int accumulator = 1;

            while(matcher.find()){
                accumulator = accumulator * Integer.valueOf(matcher.group());
            }

            return String.valueOf(accumulator);
        }


        if (question.contains("largest")) {
            Pattern numberCatcher = Pattern.compile("[0-9]+");
            Matcher matcher = numberCatcher.matcher(question);
            int maxHolder = 0;

            while(matcher.find()){
                int currentNumber = Integer.valueOf(matcher.group());
                if (currentNumber > maxHolder){
                    maxHolder = currentNumber;
                }
            }

            return String.valueOf(maxHolder);
        }
        return "";
    }
}
