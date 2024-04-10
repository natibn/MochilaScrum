/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.problemamochila;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author natalia bernardo
 */
public class MochilaScrum {

    public static void main(String[] args) {
        List <AtividadeScrum> listaItens = new ArrayList();
        listaItens.add(new AtividadeScrum("Atividade1", 5.0,  3.0, 2));
        listaItens.add(new AtividadeScrum("Atividade2", 4.0,  3.0, 3));
        listaItens.add(new AtividadeScrum("Atividade3", 7.0,  2.0, 1));
        listaItens.add(new AtividadeScrum("Atividade4", 8.0,  4.0, 1));
        listaItens.add(new AtividadeScrum("Atividade5", 4.0,  2.0, 2));
        listaItens.add(new AtividadeScrum("Atividade6", 4.0,  3.0, 1));
        listaItens.add(new AtividadeScrum("Atividade7", 6.0,  4.0, 3));
        listaItens.add(new AtividadeScrum("Atividade8", 8.0,  2.0, 2));
        
        List pesos = new ArrayList();
        List beneficios = new ArrayList();
        List nomes = new ArrayList();
        
        for (AtividadeScrum item : listaItens){
            pesos.add(item.getPeso());
            beneficios.add(item.getBeneficio());
            nomes.add(item.getNome());
        }
        
        Double limite = 3.0;
        int tamanhopopulacao = 20;
        Double taxaMutacao = 0.01;
        int numeroGeracoes = 100;
        int experiencia = 0;
        
        AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhopopulacao);
        List resultado = ag.resolver(taxaMutacao, numeroGeracoes, pesos, beneficios, limite);
        for (int i=0; i<listaItens.size(); i++){
            if(resultado.get(i).equals("1")){
                System.out.println("Nome: " + listaItens.get(i).getNome());
            }
        }
    }
}
