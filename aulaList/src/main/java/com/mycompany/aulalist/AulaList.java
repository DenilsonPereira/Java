/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aulalist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Denilson
 */
public class AulaList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");
        list.add(2, "Marco");
        
        System.out.println(list.size());
        for(String x : list){
            System.out.println(x);
        }
       
//        list.remove(1);
//        for(String x : list){
//            System.out.println(x);
//        }

        System.out.println("------------------------");
        list.removeIf(x -> x.charAt(0) == 'M');
        for(String x : list){
            System.out.println(x);
        }
        
        System.out.println("------------------------");
        System.out.println("Index of Bob: " + list.indexOf("Bob"));
        System.out.println("Index of Marco: " + list.indexOf("Marco"));
        System.out.println("------------------------");
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
        for(String y : result){
            System.out.println(y);
        }
        System.out.println("------------------------");
        String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
        System.out.println(name);
    }
}
