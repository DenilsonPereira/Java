/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primeiralista;

/**
 *
 * @author Denilson
 */
public class PrimeiraLista {

    public static void main(String[] args) {
        float[] indices = new float[5];
        float d = 0;
        for(int i = 0; i<5;i++){
            indices[i] = d;
            d+= 0.5;
        }
        System.out.println(indices[4]);
    }
}
