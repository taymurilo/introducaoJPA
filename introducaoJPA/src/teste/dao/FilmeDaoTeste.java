package teste.dao;

import static org.junit.Assert.*;

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
	filme.setTitulo("Avatar");
	filme.setSinopse("Suspence");
	
	FilmeDao dao= new FilmeDao(entityManager);
	dao.salvar(filme);
}
@Test
public void buscarFilmePorId(){
	Filme filme= dao.buscarPorId(1L);
	assertNotNull(filme);
	
	
}
}
