package org.example.view;

import java.util.List;

public class Printer {
    public static void printList(List<?> list){
        for(Object o: list){
            System.out.println(o.toString());
        }
    }
}
