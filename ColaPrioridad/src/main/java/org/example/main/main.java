package org.example.main;

import org.example.models.ColaConPrioridad;

public class main {

    // Creamos la cola de prioridad junto a sus procesos y lo ponemos a correr hasta que no queden procesos en la cola
    public static void main(String[] args) {
        ColaConPrioridad cp = new ColaConPrioridad();
        cp.iniciar();
    }

}
