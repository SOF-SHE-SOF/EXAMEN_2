/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;
import AccesoDatos.UsuarioDAO;
import Entidades.Usuario;
import java.util.*;
/**
 *
 * @author sherr
 */
public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public void registrar(Usuario u) throws Exception {
        if (u.getId().isEmpty() || u.getNombre().isEmpty()) {
            throw new Exception("Datos incompletos");
        }

        for (Usuario x : dao.listar()) {
            if (x.getId().equals(u.getId())) {
                throw new Exception("ID duplicado");
            }
        }

        dao.guardar(u);
    }

    public List<Usuario> listar() throws Exception {
        return dao.listar();
    }

    public void eliminar(String id) throws Exception {
        dao.eliminar(id);
    }
}

