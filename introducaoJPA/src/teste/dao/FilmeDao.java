package teste.dao;

import java.util.List;

import javax.persistence.EntityManager;

import teste.Filme;

public class FilmeDao {
	private EntityManager entityManager;
	
	public FilmeDao(EntityManager entityManager){
		this.entityManager= entityManager;
				
	}

	public void salvar(Filme filme){
		entityManager.persist(filme);
		
	}

	public Filme buscarPorId(Long id) {
		
		return entityManager.find(Filme.class,id);
	}
	
	public void excluirFilme(Long id){
		
		Filme filme = entityManager.find(Filme.class,id );
		entityManager.remove(filme);
	}

	@SuppressWarnings("unchecked")//so para não aparecer o erro amarelo 
	public List<Filme> listaTodos(){
		return entityManager.createQuery("From Filme").getResultList();
		
		
	}
    
	public void editarFilme(Long id,String sinopse,String titulo){
	    Filme filme= entityManager.find(Filme.class, id);
	    filme.setTitulo(titulo);
	    filme.setSinopse(sinopse);
		
	}
}
