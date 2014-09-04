package teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("introducao-jpa");
		EntityManager em = emf.createEntityManager();

		Filme filme = new Filme();
		filme.setTitulo("Conan");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome do Filme");
		filme.setTitulo(scanner.nextLine());

		//System.out.println("Sinopse");
		
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();

		emf.close();

	}

}
