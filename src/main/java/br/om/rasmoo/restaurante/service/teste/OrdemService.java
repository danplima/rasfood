package br.om.rasmoo.restaurante.service.teste;

import br.om.rasmoo.restaurante.dao.CardapioDao;
import br.om.rasmoo.restaurante.dao.ClienteDao;
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

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("00000000","av. torquato","apt 304","Manaus","Amazonas");
        Cliente cliente = new Cliente("11111111111","Daniel Lima");
        cliente.addEndereco(endereco);
        Ordem ordem = new Ordem(cliente);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1), 2));
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(2), 3));
        clienteDao.cadastrar(cliente);
        ordemDao.cadastrar(ordem);
        System.out.println(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
