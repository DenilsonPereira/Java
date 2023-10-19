/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz;

import java.util.Scanner;

/**
 *
 * @author Denilson
 */
public class Matriz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] mat = new int[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Main diagonal: ");
        for(int i = 0; i< n; i++){
            System.out.print(mat[i][i] + " ");
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j =0; j < n; j++){
                if(mat[i][j] < 0){
                    count++;
                }
            }
        }
        System.out.println("\nNegative numbers = " + count);
        sc.close();
    }
}
