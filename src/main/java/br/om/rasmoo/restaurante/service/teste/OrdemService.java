package br.om.rasmoo.restaurante.service.teste;

import br.om.rasmoo.restaurante.dao.ClienteDao;
import br.om.rasmoo.restaurante.dao.EnderecoDao;
import br.om.rasmoo.restaurante.entity.ClienteId;
import br.om.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.om.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        System.out.println(enderecoDao.consultarClientesCriteria(null,null,"lapa"));

        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.consultarPorId(new ClienteId("tayane@email.com","111111111123")));

        entityManager.getTransaction().commit();
        entityManager.close();



    }
}
