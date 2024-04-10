/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problemamochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author natalia bernardo
 */
public class AlgoritmoGenetico {
    private int tamanhoPopulacao;
    private List<Desenvolvedor> populacao = new ArrayList();
    private Desenvolvedor geracao;
    private Desenvolvedor melhorSolucao;
    
    public AlgoritmoGenetico (int tamanhoPopulacao){
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    public int getTamanhoPopulacao() {
        return tamanhoPopulacao;
    }

    public void setTamanhoPopulacao(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    public List<Desenvolvedor> getPopulacao() {
        return populacao;
    }

    public void setPopulacao(List<Desenvolvedor> populacao) {
        this.populacao = populacao;
    }

    public Desenvolvedor getGeracao() {
        return geracao;
    }

    public void setGeracao(Desenvolvedor geracao) {
        this.geracao = geracao;
    }

    public Desenvolvedor getMelhorSolucao() {
        return melhorSolucao;
    }

    public void setMelhorSolucao(Desenvolvedor melhorSolucao) {
        this.melhorSolucao = melhorSolucao;
    }
    
    public void inicializaPopulacao(List peso, List beneficio, Double limitePeso){
        Random experiencia = new Random();
        for (int i=0; i<tamanhoPopulacao; i++){
            this.populacao.add(new Desenvolvedor(peso, beneficio, limitePeso, (experiencia.nextInt(2)+1)));
        }
        this.melhorSolucao=this.populacao.get(0);
    }
    
    public void melhorIndividuo(Desenvolvedor individuo){
        if (individuo.getExperiencia() > this.melhorSolucao.getExperiencia()){
            this.melhorSolucao = individuo;
        }
    }
    
    public void ordenaPopulacao(){
        Collections.sort(this.populacao);
    }
    
    public Double somaAvaliacoes(){
        Double soma = 0.0;
        for(Desenvolvedor individuo : this.populacao){
            soma+=individuo.getNotaAvaliacao();
        }
        return soma;
    }
    
    public int selecionaPai(Double somaAvaliacao){
        int pai = -1;
        Double valorSorteado = Math.random() * somaAvaliacao;
        Double soma = 0.0;
        int i=0;
        while (i < this.populacao.size() && soma < valorSorteado){
            soma += this.populacao.get(i).getNotaAvaliacao();
            pai += 1;
            i += 1;                 
        }
        return pai;
    }
    
    public void visualizaGeracao(){
        Desenvolvedor melhor = this.populacao.get(0);
        System.out.println("Geração: " + melhor.getGeracao()+
                " Valor: " + melhor.getNotaAvaliacao()+
                " Espaço: " + melhor.getPesoUsado()+
                " Cromossomo: " + melhor.getCromossomo());
    }
    
    public List resolver(Double taxaMutacao, int numeroGeracoes, List pesos, List beneficios, Double limitePeso){
        this.inicializaPopulacao(pesos, beneficios, limitePeso);
        
        for (Desenvolvedor individuo : this.populacao){
            individuo.avaliacao();
        }
        
        this.ordenaPopulacao();
        this.visualizaGeracao();
        
        for (int geracao = 0; geracao < numeroGeracoes; geracao++){
            Double somaAvaliacao = this.somaAvaliacoes();
            List<Desenvolvedor> novaPopulacao = new ArrayList();
            
            for (int i=0; i<this.populacao.size() / 2; i++){
                int pai1 = this.selecionaPai(somaAvaliacao);
                int pai2 = this.selecionaPai(somaAvaliacao);
                
                List <Desenvolvedor> filhos = this.getPopulacao().get(pai1).crossover(this.populacao.get(pai2));
                novaPopulacao.add(filhos.get(0).mutacao(taxaMutacao));
                novaPopulacao.add(filhos.get(1).mutacao(taxaMutacao));
            }
            
            this.setPopulacao(novaPopulacao);
            for(Desenvolvedor individuo : this.populacao){
                individuo.avaliacao();
            }
            
            this.ordenaPopulacao();
            this.visualizaGeracao();
            Desenvolvedor melhor = this.populacao.get(0);
            this.melhorIndividuo(melhor);
        }
        
        System.out.println("Melhor solução: " + this.melhorSolucao.getGeracao()+
                " Valor: " + this.melhorSolucao.getNotaAvaliacao()+
                " Espaço: " + this.melhorSolucao.getPesoUsado() + 
                " Cromossomo: " + this.melhorSolucao.getCromossomo());
        
        return this.melhorSolucao.getCromossomo();
    }
}
