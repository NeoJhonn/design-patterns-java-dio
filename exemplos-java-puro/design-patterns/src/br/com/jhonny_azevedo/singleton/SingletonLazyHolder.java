package br.com.jhonny_azevedo.singleton;

/**
 * Singleton "SingletonLazyHolder" - Padrão de projeto criacional
 *
 * @author neojhonn
 *
 * @see <a href="https://stackoverflow.com/a/24018148">Referência</a>
 *
 * Encapsula a instância em uma classe estática interna.
 */

public class SingletonLazyHolder {

    // classe interna Encapsula a instância
    private static class IntanceHolder {
    // Intância de si mesmo
    public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    // Construtor privado para evitar que outras classes instanciem
    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstancia() {
        return IntanceHolder.instancia;
    }

}
