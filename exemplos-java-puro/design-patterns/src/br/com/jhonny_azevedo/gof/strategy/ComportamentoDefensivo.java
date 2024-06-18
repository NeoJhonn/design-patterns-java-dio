package br.com.jhonny_azevedo.gof.strategy;

public class ComportamentoDefensivo implements IComportamento {

    @Override
    public void mover() {
        System.out.println("Movendo-se defensivamente...");
    }
}
