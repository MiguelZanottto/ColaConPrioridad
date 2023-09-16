import org.example.models.ColaConPrioridad;
import org.example.models.Proceso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColaPrioridadTest {


    // Comprobamos que al correr un proceso se le resta 1 quantum
    @Test
    public void correrProcesoTest(){
        Proceso p = new Proceso();
        int quantumEsperados = p.getQuantum() - 1;
        p.correrProceso();
        assertEquals(quantumEsperados, p.getQuantum());
    }

    // Comprobamos que al terminar de ejecutar todos los procesos, no quedan ningun proceso en el ArrayList
    @Test
    public void iniciarTest(){
        ColaConPrioridad c = new ColaConPrioridad();
        boolean vacio = true;
        c.iniciar();
        for(int i = 0; i < c.procesos.size(); i++){
            if(!c.procesos.get(i).isEmpty()){
                vacio = false;
            }
        }
        assertEquals(true, vacio);
    }

    //Comprobamos que se han creado 50 procesos en la cola
    @Test
    public void ColaConPrioridadTest2(){
        ColaConPrioridad c = new ColaConPrioridad();
        int contador = 0;
        for(int i = 0; i < c.procesos.size(); i++){
            for(int j = 0; j < c.procesos.get(i).size();j++){
                contador++;
            }
        }
        assertEquals(50, contador);
    }

    // Comprobamos que el al crear el proceso se le asigna una prioridad entre 0 - 8
    @Test
    public void procesoTest(){
      Proceso p = new Proceso();
        assertEquals(true,p.getPrioridad() >= 0 && p.getPrioridad() < 9 );
    }

    // Comprobamos que en el constructor, al crear el array principal tenga un tamano de 9, los cuales corresponden a 1 array por cada prioridad (0-8 prioridades)
    @Test
    public void ColaConPrioridadTest(){
        int tamano = 9;
        ColaConPrioridad c = new ColaConPrioridad();
        assertEquals(9, c.procesos.size());
    }

    // Comprobamos que la variable ordenDeLaCola sea = 9 lo que significa que ha recorrido todo el array principal y que ha salido del bucle while
    @Test
    public void ordenDeLaColaTest(){
        int ordenDeColaEsperado = 9;
        ColaConPrioridad c = new ColaConPrioridad();
        c.iniciar();
        assertEquals(ordenDeColaEsperado, c.ordenDeLaCola);
    }
}
