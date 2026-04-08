/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author sherr
 */
public class Usuario {

    private String id;
    private String nombre;
    private String rol;

    public Usuario(String id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getRol() { return rol; }

    public String toFile() {
        return id + "," + nombre + "," + rol;
    }

    public static Usuario fromFile(String linea) {
        String[] p = linea.split(",");
        return new Usuario(p[0], p[1], p[2]);
    }
}

