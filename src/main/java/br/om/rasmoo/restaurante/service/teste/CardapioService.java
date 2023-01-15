package br.om.rasmoo.restaurante.service.teste;

import br.om.rasmoo.restaurante.dao.CardapioDao;
import br.om.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.om.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de Produtos por valor: " + cardapioDao.consultaPorValor(BigDecimal.valueOf(59.00)));
        System.out.println("O produto Pesquisado foi: " + cardapioDao.consultarPorNome("bife"));
        entityManager.close();
    }

}
