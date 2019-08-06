package com.example.rp.test.lagomendpoints.impl;

import com.example.rp.test.lagomendpoints.api.StringService;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import akka.NotUsed;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class StringServiceImpl implements StringService {
    /*@Override
    public ServiceCall<NotUsed, String> reverse(String word) {
        return request -> CompletableFuture.completedFuture(word + " in reverse is: " + reverseString(word));
    }*/

    List<String> list = new ArrayList<String>();    

    private String reverseString(String word)
    {
        char[] array = word.toCharArray();

        for(int i = 0; i < array.length / 2; i++)
        {
            swap(array, array.length - 1 - i, i);
        }
        System.out.println(new String(array));
        return new String(array);

    }

    private void swap(char[] array, int a, int b)
    {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


   /* public String reverseStr(String word)
    {
        char[] array = word.toCharArray();

        int i = 0, j = 0;

        for(j = 0; j < array.length; j++)
        {
            if(j == array.length || array[j] == ' ')
            {
                swapReverse(array, i, j-1);
                i = j + 1;
            }
        }
        swapReverse(array,0,array.length-1);
        return new String(array);
    }

    public void swapReverse(char[] array, int a, int b)
    {
        char temp = array[a];
        array[a++] = array[b];
        array[b--] = temp;
    }*/

    /*@Override
    public ServiceCall<NotUsed, String> upper(String word) {
        return request -> CompletableFuture.completedFuture(word + " in upper case is: " + word.toUpperCase());
    }

    @Override
    public ServiceCall<NotUsed, String> lower(String word) {
        return request -> CompletableFuture.completedFuture(word + " in lower case is: " + word.toLowerCase());
    }*/

    @Override
    public ServiceCall<NotUsed, String> action(String actionName, String word) {
        actionName = actionName.toLowerCase();
        switch(actionName)
        {
            case "reverse":
            return request -> CompletableFuture.completedFuture(word + " in reverse is: " + reverseString(word));

            case "lower":
            System.out.println(word.toLowerCase());
            return request -> CompletableFuture.completedFuture(word + " in lower case is: " + (word.toLowerCase()));

            case "upper":
            System.out.println(word.toUpperCase());
            return request -> CompletableFuture.completedFuture(word + " in upper case is: " + (word.toUpperCase()));
            
            case "add":
            addToList(list, word);
            System.out.println(showList());
            return request -> CompletableFuture.completedFuture(word + " added to the list. Here is the current list: " + showList());

            case "clear":
            list.clear();
            System.out.println("List has been cleared");
            return request -> CompletableFuture.completedFuture("list has been cleared");


            default:
            //return request -> CompletableFuture.completedFuture(word + " in reverse default is: " + reverseString(word));
            String instruction1 = "Invalid Command. Please Try Again\n\nWelcome to the String Java Lagom App!\n\n";
            String instruction2 = "Here are the functions available to use:";
            String instruction3 = "Reverse a String:\nCURRENT URL + /api/stringservice/reverse/:word" + "\n\t- Set the word to the word of your choice." + "\n\t The result of the page would show: *WORD* in reverse is: *REVERSE OF WORD*";
            String instruction4 = "Convert string to lower case:\nCURRENT URL + /api/stringservice/lower/:word" + "\n\t- Set the word of your choice." + "\n\t The result of the page would show: *WORD* in lower case is: *WORD IN LOWERCASE*";
            String instruction5 = "Convert string to upper case:\nCURRENT URL + /api/stringservice/upper/:word" + "\n\t- Set the word of your choice." + "\n\t The result of the page would show: *WORD* in upper case is: *WORD IN UPPERCASE*";
            String instruction6 = "Add string to a list:\nCURRENT URL + /api/stringservice/add/:word" + "\n\t- Set the word of your choice." + "\n\t The result of the page would show: *WORD* added to the list. Here is the current list: [*WORD1*]";
            String instruction7 = "Clear the list:\n<b>CURRENT URL + /api/stringservice/clear/list</b>" + "\n\t- The result of the page would show: List has been cleared";
            
            return request -> CompletableFuture.completedFuture(instruction1 + "\n\n\n" + instruction2 + "\n\n\n" + instruction3 + "\n\n\n" + instruction4 + "\n\n\n" + instruction5 + "\n\n\n" + instruction6 + "\n\n\n" + instruction7);
        }
    }

    public List<String> addToList(List<String> list, String word)
    {
        list.add(word);
        return list;
    }

    public String showList()
    {
        return list.toString();
    }

    public void clearList(List<String> list)
    {
        list.clear();
    }

    @Override
    public ServiceCall<NotUsed, String> main() {
        String instruction1 = "Welcome to the String Java Lagom App!\n\n";
        String instruction2 = "Here are the functions available to use:";
        String instruction3 = "Reverse a String:\nCURRENT URL + /api/stringservice/reverse/:word" + "\n\t- Set the word to the word of your choice." + "\n\t The result of the page would show: *WORD* in reverse is: *REVERSE OF WORD*";
        String instruction4 = "Convert string to lower case:\nCURRENT URL + /api/stringservice/lower/:word" + "\n\t- Set the word of your choice." + "\n\n The result of the page would show: *WORD* in lower case is: *WORD IN LOWERCASE*";
        String instruction5 = "Convert string to upper case:\nCURRENT URL + /api/stringservice/upper/:word" + "\n\t- Set the word of your choice." + "\n\n The result of the page would show: *WORD* in upper case is: *WORD IN UPPERCASE*";
        String instruction6 = "Add string to a list:\nCURRENT URL + /api/stringservice/add/:word" + "\n\t- Set the word of your choice." + "\n\n The result of the page would show: *WORD* added to the list. Here is the current list: [*WORD1*]";
        String instruction7 = "Clear the list:\nCURRENT URL + /api/stringservice/clear/list" + "\n\t- The result of the page would show: List has been cleared";
        
        return request -> CompletableFuture.completedFuture(instruction1 + "\n\n" + instruction2 + "\n\n" + instruction3 + "\n\n" + instruction4 + "\n\n" + instruction5 + "\n\n" + instruction6 + "\n\n" + instruction7);
    }
   
}

