import br.com.jhonny_azevedo.gof.singleton.SingletonEager;
import br.com.jhonny_azevedo.gof.singleton.SingletonLazy;
import br.com.jhonny_azevedo.gof.singleton.SingletonLazyHolder;
import br.com.jhonny_azevedo.gof.strategy.ComportamentoAgressivo;
import br.com.jhonny_azevedo.gof.strategy.ComportamentoDefensivo;
import br.com.jhonny_azevedo.gof.strategy.ComportamentoNormal;
import br.com.jhonny_azevedo.gof.strategy.Robo;

public class Main {
    public static void main(String[] args) {
        /////////// Singleton /////////////
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

        /////////// Strategy /////////////
        System.out.println("\n");
        System.out.println("Strategy");
        Robo robo = new Robo();
        // Comportamento normal
        robo.setComportamento(new ComportamentoNormal());
        robo.mover();

        // Comportamento defesivo
        robo.setComportamento(new ComportamentoDefensivo());
        robo.mover();

        // Corportamento agressivo
        robo.setComportamento(new ComportamentoAgressivo());
        robo.mover();

    }
}