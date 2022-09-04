package org.example.util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CommonMethodsForList {

    public static List<String> getItemsNamesText(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static void clickOnFirstElementInListOfItems(List<WebElement> list) {
        list.stream().findAny().ifPresent(WebElement::click);
    }

    public static List<Integer> convertElementsIntoInteger(List<WebElement> list) {
        int n = 0;
        int b = 0;
        List<Integer> newList = new ArrayList<>();
        List<String> listOfText = getItemsNamesText(list);
        for (String s : listOfText) {
            do {
                if (s.contains(",")) {
                    String str = s.replace(",", "");
                    b = Integer.parseInt(str);
                    newList.add(b);
                } else {
                    newList.add(b);
                }
                n++;
            } while (n < listOfText.size());
        }
        return newList;
    }

    public static int getRandomIndexInList(List<WebElement> list) {
        Random rnd = new Random();
        return rnd.nextInt(list.size());
    }

    public static boolean isListContainsString(List<String> list, String str) {
        for (String s : list) {
            if (s.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
