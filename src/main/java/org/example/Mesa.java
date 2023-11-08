package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa extends Thread{
    private boolean[] tenedores;

    public Mesa(int numTenedores) {//crea un array con el numero de personas que le indiques
        this.tenedores = new boolean[numTenedores];
    }

    public int tenedorIzquierda(int i){
        return i;
    }

    public int tenedorDerecha(int i){
        if(i == 0){
            return this.tenedores.length - 1;
        }else{
            return i - 1;
        }

    }

    public synchronized void cogerTenedor(int comensal){
        // Comprobar si los tenedores izquierdo o derecho están ocupados por otros filósofos
        while(tenedores[tenedorIzquierda(comensal)] || tenedores[tenedorDerecha(comensal)]){
            try {
                wait();//Si estan los tenedores ocupados espera
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Marcar los tenedores izquierdo y derecho como ocupados
        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
    }

    public synchronized void dejarTenedores(int comensal){
        // Marcar los tenedores izquierdo y derecho como disponibles
        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false ;
        notifyAll();

    }


}
