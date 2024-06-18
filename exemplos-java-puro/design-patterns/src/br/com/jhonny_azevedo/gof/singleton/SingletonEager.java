package br.com.jhonny_azevedo.gof.singleton;

/**
 * Singleton "Eager" - Padrão de projeto criacional
 *
 * @author neojhonn
 *
 * Apressado pois já disponibiliza a instância para o usuário
 */

public class SingletonEager {

    // Intância de si mesmo
    private static SingletonEager instancia = new SingletonEager();

    //Construtor privado para evitar que outras classes instanciem
    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstancia() {
        return instancia;
    }

}

