package org.example.view;

import org.example.models.Author;

import java.util.List;

public class Printer {
    public static void printList(List<?> list){
        for(Object o: list){
            System.out.println(o);
        }
    }
}
