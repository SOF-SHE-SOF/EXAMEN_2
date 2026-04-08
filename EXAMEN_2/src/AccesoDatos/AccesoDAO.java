/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;
import Entidades.Acceso;
import java.io.*;
import java.util.*;
/**
 *
 * @author sherr
 */
public class AccesoDAO {

    private final String archivo = "accesos.txt";

    public List<Acceso> listar() throws Exception {
        List<Acceso> lista = new ArrayList<>();
        File f = new File(archivo);
        if (!f.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String linea;
        while ((linea = br.readLine()) != null) {
            lista.add(Acceso.fromFile(linea));
        }
        br.close();
        return lista;
    }

    public void guardarTodo(List<Acceso> lista) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Acceso a : lista) {
            bw.write(a.toFile());
            bw.newLine();
        }
        bw.close();
    }

    public void agregar(Acceso a) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(a.toFile());
        bw.newLine();
        bw.close();
    }
}

