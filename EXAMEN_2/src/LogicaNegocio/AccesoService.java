/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;
import AccesoDatos.AccesoDAO;
import Entidades.Acceso;
import java.time.*;
import java.util.*;
/**
 *
 * @author sherr
 */
public class AccesoService {

    private AccesoDAO dao = new AccesoDAO();

    public void registrarEntrada(String idUsuario) throws Exception {
        List<Acceso> lista = dao.listar();

        for (Acceso a : lista) {
            if (a.getIdUsuario().equals(idUsuario) && a.getSalida().equals("null")) {
                throw new Exception("Ya está dentro");
            }
        }

        String ahora = LocalDateTime.now().toString();
        dao.agregar(new Acceso(idUsuario, ahora, "null"));
    }

    public void registrarSalida(String idUsuario) throws Exception {
        List<Acceso> lista = dao.listar();
        boolean encontrado = false;

        for (Acceso a : lista) {
            if (a.getIdUsuario().equals(idUsuario) && a.getSalida().equals("null")) {
                a.setSalida(LocalDateTime.now().toString());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) throw new Exception("No tiene entrada previa");

        dao.guardarTodo(lista);
    }

    public void historial(String idUsuario) throws Exception {
        for (Acceso a : dao.listar()) {
            if (a.getIdUsuario().equals(idUsuario)) {
                System.out.println(a.getEntrada() + " - " + a.getSalida());
            }
        }
    }
    
    public void tiempoTotal(String idUsuario) throws Exception {
        List<Acceso> lista = dao.listar();
        long totalMinutos = 0;

        for (Acceso a : lista) {
            if (a.getIdUsuario().equals(idUsuario) && !a.getSalida().equals("null")) {
                LocalDateTime entrada = LocalDateTime.parse(a.getEntrada());
                LocalDateTime salida = LocalDateTime.parse(a.getSalida());

                Duration duracion = Duration.between(entrada, salida);
                totalMinutos += duracion.toMinutes();
            }
        }

      System.out.println("Tiempo total: " + totalMinutos + " minutos");
    }
}
