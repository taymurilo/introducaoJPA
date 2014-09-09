package teste.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import teste.Filme;
import teste.util.JpaUtil;

public class FilmeDaoTeste {

	private EntityManager entityManager;
    private FilmeDao dao;
	
    @BeforeClass
	public static void init() {
		JpaUtil.initFactory();

	}

	@AfterClass
	public static void finish() {
		JpaUtil.closeFactory();

	}

	@Before
	public void begin() {
		entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		dao = new FilmeDao(entityManager);
	}

	@After
	public void close() {
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager = null;
        dao = null;
	}
@Test
public void testSalvar(){
	Filme filme= new Filme();
	filme.setTitulo("Todo Mundo em Pânico");
	filme.setSinopse("Comédia");
	
	FilmeDao dao= new FilmeDao(entityManager);
	dao.salvar(filme);
}
@Test
public void buscarFilmePorId(){
	Filme filme= dao.buscarPorId(1L);
	assertNotNull(filme);
	
	
}
@Test
public void testeexcluirFilme(){
	
	dao.excluirFilme(1l);
}
@Test
public void testeListar(){
	List<Filme> filmes= dao.listaTodos();
	for (Filme filme : filmes) {
		System.out.println(filme.getTitulo());
		
	}	
}
@Test	
public void testaEditarFilme(){
		dao.editarFilme(2L, "Ação", "Bradock 3");
	}
}


