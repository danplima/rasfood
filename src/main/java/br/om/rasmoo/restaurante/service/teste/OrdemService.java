package br.om.rasmoo.restaurante.service.teste;

import br.om.rasmoo.restaurante.dao.CardapioDao;
import br.om.rasmoo.restaurante.dao.ClienteDao;
import br.om.rasmoo.restaurante.dao.EnderecoDao;
import br.om.rasmoo.restaurante.dao.OrdemDao;
import br.om.rasmoo.restaurante.entity.Cliente;
import br.om.rasmoo.restaurante.entity.Endereco;
import br.om.rasmoo.restaurante.entity.Ordem;
import br.om.rasmoo.restaurante.entity.OrdensCardapio;
import br.om.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.om.rasmoo.restaurante.util.JPAUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

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

        System.out.println(enderecoDao.consultarClientes("SP","Sao Paulo","augusta"));
        entityManager.getTransaction().commit();
        entityManager.close();



    }
}
