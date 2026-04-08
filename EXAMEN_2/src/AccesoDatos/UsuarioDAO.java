/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;
import Entidades.Usuario;
import java.io.*;
import java.util.*;
/**
 *
 * @author sherr
 */
public class UsuarioDAO {

    private final String archivo = "usuarios.txt";

    public List<Usuario> listar() throws Exception {
        List<Usuario> lista = new ArrayList<>();
        File f = new File(archivo);
        if (!f.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String linea;
        while ((linea = br.readLine()) != null) {
            lista.add(Usuario.fromFile(linea));
        }
        br.close();
        return lista;
    }

    public void guardar(Usuario u) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(u.toFile());
        bw.newLine();
        bw.close();
    }

    public void eliminar(String id) throws Exception {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (Usuario u : lista) {
            if (!u.getId().equals(id)) {
                bw.write(u.toFile());
                bw.newLine();
            }
        }
        bw.close();
    }
}

