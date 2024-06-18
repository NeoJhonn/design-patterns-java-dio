package br.com.jhonny_azevedo.singleton;


public class Test {

    public static void main(String[] args) {
        System.out.println("Lazy");
        // Lazy
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        // Tem que imprimir o mesmo endereço de memória
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        System.out.println("\n");

        System.out.println("Eager");
        // Eager
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        // Tem que imprimir o mesmo endereço de memória
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        System.out.println("\n");

        System.out.println("Lazy Holder");
        // LazyHolder
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        // Tem que imprimir o mesmo endereço de memória
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
    }
}
