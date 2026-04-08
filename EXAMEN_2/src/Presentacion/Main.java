/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;
import LogicaNegocio.*;
import Entidades.Usuario;
import java.util.Scanner;
/**
 *
 * @author sherr
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        UsuarioService us = new UsuarioService();
        AccesoService as = new AccesoService();

        while (true) {
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Entrada");
            System.out.println("4. Salida");
            System.out.println("5. Historial");
            System.out.println("6. Tiempo total dentro");
            System.out.println("0. Salir");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Rol: ");
                    String rol = sc.nextLine();

                    us.registrar(new Usuario(id, nombre, rol));
                    break;

                case 2:
                    for (Usuario u : us.listar()) {
                        System.out.println(u.getId() + " - " + u.getNombre());
                    }
                    break;

                case 3:
                    System.out.print("ID usuario: ");
                    as.registrarEntrada(sc.nextLine());
                    break;

                case 4:
                    System.out.print("ID usuario: ");
                    as.registrarSalida(sc.nextLine());
                    break;

                case 5:
                    System.out.print("ID usuario: ");
                    as.historial(sc.nextLine());
                    break;
                    
                case 6:
                    System.out.print("ID usuario: ");
                    as.tiempoTotal(sc.nextLine());
                    break;
            }
        }
    }
}

