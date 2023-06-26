package repository;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public static List<Usuario> findUsuariosSistema() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setLogin("admin");
        usuario.setSenha("admin");

        usuarios.add(usuario);

        return usuarios;
    }

    public static Object[] findUsuariosSistemaInArray() {
        List<Usuario> usuarios = findUsuariosSistema();
        List<String> usuariosLogins = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosLogins.add(usuario.getLogin());
        }

        return usuariosLogins.toArray();
    }

    public static Usuario findUsuarioByLogin(String login) {
        List<Usuario> usuariosSistema = findUsuariosSistema();

        for (Usuario usuario : usuariosSistema) {
            if (login.equals(login)) {
                return usuario;
            }
        }
        return null;
    }
}
