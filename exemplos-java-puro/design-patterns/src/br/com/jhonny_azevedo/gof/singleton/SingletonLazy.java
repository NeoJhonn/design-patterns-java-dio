package br.com.jhonny_azevedo.gof.singleton;

/**
 * Singleton "Lazy" - Padrão de projeto criacional
 *
 * @author neojhonn
 *
 * Preguiçoso onde num primeiro momento não disponibiliza a instância para o usuário
 */

public class SingletonLazy {

    // Intância de si mesmo
    private static SingletonLazy instancia;

    //Construtor privado para evitar que outras classes instanciem
    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstancia() {
        // Se não tiver uma intância crie uma
        if (instancia == null) {
            instancia = new SingletonLazy();
        }
        return instancia;
    }

}
