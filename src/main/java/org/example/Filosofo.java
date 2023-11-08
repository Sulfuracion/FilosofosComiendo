package org.example;

public class Filosofo extends Thread{
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;

    public Filosofo(Mesa mesa, int comensal) {
        this.mesa = mesa;
        this.comensal = comensal;
        this.indiceComensal = comensal -1;
    }

    public void run(){
        while (true){
            this.pensando();
            this.mesa.cogerTenedor(this.indiceComensal);
            this.comiendo();
            System.out.println("El filosofo " + comensal + " filosofea, hay " + (this.mesa.tenedorIzquierda(this.indiceComensal) +1) + " , " +(this.mesa.tenedorDerecha(this.indiceComensal) +1) + " tenedores");
            this.mesa.dejarTenedores(this.indiceComensal);
        }
    }


    public void pensando(){
        System.out.println("Filosofo " + comensal + " esta filosofeando");
        try {
            sleep((long) (Math.random() * 4000)); // piensa un tiempo aleatorio
        } catch (InterruptedException e) {
            System.out.println("No piensa :(");
        }
    }

    public void comiendo(){
        System.out.println("Filoso " + comensal + " come");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException e) {
            System.out.println("No come :(");
        }

    }


}
