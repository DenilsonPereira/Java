/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carro;
/**
 *
 * @author Denilson
 */


public class Carro {
    private double eficiencia;
    private double quilometragem;
    private double litros;

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public Carro(double efi) {
        setLitros(100);
        setEficiencia(efi);
        System.out.println("Litros :" + getLitros() + " Eficiência: " + getEficiencia());
    }

    public void Andar(double km) {
        this.quilometragem = km / getEficiencia();
        this.litros = getQuilometragem() - litros;
        System.out.println("Litros :" + getLitros());
    }
}
