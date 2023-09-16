package org.example.models;

import java.time.LocalDateTime;
import java.util.UUID;


public class Proceso {
    UUID pid;
    String nombre;
    LocalDateTime tiempoCreacion;
    LocalDateTime tiempoModificacion;
    int quantum;
    int prioridad;
    // Es una variable estatica que va sumando 1 cada vez que se construya un nuevo proceso para luego ser asignado a su nombre
    static int numeroProceso = 0;

    public Proceso() {
        numeroProceso += 1;
        this.pid = UUID.randomUUID();
        this.nombre = "P" + Integer.toString(numeroProceso);
        this.tiempoCreacion = LocalDateTime.now();
        this.tiempoModificacion = LocalDateTime.now();
        this.quantum = ((int) (Math.random() * 100)) + 1;
        this.prioridad = (int) (Math.random() * 9);
    }

    // Le resta 1 quantum al proceso y evalua si es mayor a 0 (es decir, si puede seguirse ejecutando)
    // en caso de ser mayor  a 0 retorna el proceso, por el contrario retorna null
    public Proceso correrProceso() {
        return --quantum > 0 ? this : null;
    }

    public UUID getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return "Pid = " + pid + ", Prioridad = " + prioridad + ", Quantum = " + quantum +  "]";
    }

    public void setPid(UUID pid) {
        this.pid = pid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getTiempoCreacion() {
        return tiempoCreacion;
    }

    public void setTiempoCreacion(LocalDateTime tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }

    public LocalDateTime getTiempoModificacion() {
        return tiempoModificacion;
    }

    public void setTiempoModificacion(LocalDateTime tiempoModificacion) {
        this.tiempoModificacion = tiempoModificacion;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}