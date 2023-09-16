package org.example.models;

import java.util.ArrayList;

public class ColaConPrioridad {
    // Es un tipo de ArrayList bidimensional que guarda los procesos en colas tomando su prioridad como indice
    public ArrayList<ArrayList<Proceso>> procesos = new ArrayList<ArrayList<Proceso>>();
    // Es una variable de control que servirá para llevar el orden de la cola una vez se empiecen a ejecutar los procesos
    public int ordenDeLaCola = 0;

    // Constructor
    public ColaConPrioridad() {
        // Iniciamos los ArrayList de la cola principal
        for (int i = 0; i < 9; i++) {
            procesos.add(new ArrayList<Proceso>());
        }
        // Creamos 50 procesos y los añadimos segun su prioridad a la cola con el metodo anadirProceso()
        for (int i = 0; i < 50; i++) {
            anadirProceso(new Proceso());
        }
    }

    //Añade proceso a la cola segun su prioridad usando esta variable como indice
    public void anadirProceso(Proceso proceso) {
        procesos.get(proceso.getPrioridad()).add(proceso);
    }

    // Inicia la ejecucion de los procesos que estan en la cola y se detendra cuando
    // no hayan más procesos por ejecutarse
    public void iniciar() {
        while (ordenDeLaCola < 9) {
            evaluarProceso();
        }
    }

    // Primero evaluamos que hayan proceso en su cola de prioridad, en caso que hayan procesos lo retiramos de la cola
    // y luego lo ejecutamos y evaluamos si su quantum es mayor a 0 con el metodo correrProceso()
    // en caso de que su quantum sea > 0 y pueda seguirse ejecutando lo añadimos al final de la cola segun su prioridad
    // en caso de que su quantum sea < 0 lo dejamos fuera de la cola y le sumamos +1 al orden general de la cola
    public void evaluarProceso() {
        if(procesos.get(ordenDeLaCola).isEmpty()) {
            ordenDeLaCola++;
        } else {
            Proceso p = procesos.get(ordenDeLaCola).remove(0);
            if (p.correrProceso() != null) {
                anadirProceso(p);
            }
        }
    }
}
