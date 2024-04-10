/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problemamochila;

/**
 *
 * @author natalia bernardo
 */
public class AtividadeScrum {
    private String nome;
    private Double peso;
    private Double beneficio;
    private int dificuldade;
    
    public AtividadeScrum (String nome, Double peso, Double beneficio, int dificuldade){
        super();
        this.nome = nome;
        this.peso = peso;
        this.beneficio = beneficio;
        this.dificuldade = dificuldade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the beneficio
     */
    public Double getBeneficio() {
        return beneficio;
    }

    /**
     * @param beneficio the beneficio to set
     */
    public void setBeneficio(Double beneficio) {
        this.beneficio = beneficio;
    }

    /**
     * @return the dificuldade
     */
    public int getDificuldade() {
        return dificuldade;
    }

    /**
     * @param dificuldade the dificuldade to set
     */
    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    
    
    
}
