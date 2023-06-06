package repository;

import java.util.List;

public interface IGenericDao<E> {
    void salvar(E objeto);

    void remover(E objeto);

    List<E> buscarTodos();

    List<E> buscarPorNome(String nome);
}