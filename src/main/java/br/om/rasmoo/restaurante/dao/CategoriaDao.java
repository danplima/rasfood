package br.om.rasmoo.restaurante.dao;

import br.om.rasmoo.restaurante.entity.Cardapio;
import br.om.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public Categoria consultarPorId(final Integer id) {
        return this.entityManager.find(Categoria.class, id);

    }

    public List<Categoria> consultarTodos() {
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void deletar(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
