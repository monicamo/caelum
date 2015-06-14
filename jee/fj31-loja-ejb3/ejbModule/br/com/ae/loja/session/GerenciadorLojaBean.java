package br.com.ae.loja.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.security.annotation.SecurityDomain;

import br.com.ae.loja.entity.Autor;
import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.interceptor.AuditoriaInterceptor;

@Stateless
@Remote(GerenciadorLoja.class)
@Interceptors(AuditoriaInterceptor.class)
@SecurityDomain("Livraria")
public class GerenciadorLojaBean implements GerenciadorLoja {

	private Map<String, Livro> repositorio;

	@PersistenceContext
	private EntityManager manager;

	public GerenciadorLojaBean() {

		this.repositorio = new HashMap<String, Livro>();

		Livro l1 = new Livro();
		l1.setNome("Bond, James Bond...");
		l1.setPreco(100);

		Livro l2 = new Livro();
		l2.setNome("M16 and Bond");
		l2.setPreco(340);

		this.repositorio.put("1111", l1);
		this.repositorio.put("2222", l2);
	}

	@Override
	public Livro procura(String isbn) {
		return this.repositorio.get(isbn);
	}

	@Override
	public void salva(Livro livro) {
		this.manager.persist(livro);
		System.out.println("Livro salvo! ID: " + livro.getId());
		// throw new RuntimeException();
		// throw new SalvaLivroException();
	}

	@Override
	public Autor salva(Autor autor) {
		this.manager.persist(autor);
		System.out.println("Autor ID: " + autor.getId());
		return autor;
	}

	@Override
	public Livro procura(Long id) {
		return this.manager.find(Livro.class, id);
	}

	@Override
	public List<Autor> getAutoresDoLivro(Livro livro) {

		Livro findLivro = this.manager.find(Livro.class, livro.getId());

		return findLivro.getAutores();
	}

	@Override
	public List<Livro> buscaLivrosPeloNomeDoAutor(String nome) {
		System.out.println("buscando livros pelo nome do autor: ");

		String jpql = "SELECT livro from Livro as livro "
				+ " join fetch livro.autores as autor "
				+ " where autor.nome like :busca ";
		Query query = this.manager.createQuery(jpql);
		query.setParameter("busca", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Livro> buscaTodosOsLivros() {
		Query query = this.manager
				.createQuery("SELECT livro from Livro as livro");
		List<Livro> list = query.getResultList();
		return list;
	}

	@Override
	public List<Autor> buscaAutoresPeloNomeDoLivro(String nome) {
		String jqpl = "select livro.autores from Livro as livro where livro.nome like :busca";
		Query q = this.manager.createQuery(jqpl);
		q.setParameter("busca", "%" + nome + "%");

		return q.getResultList();
	}

	@Override
	public List<Autor> buscaAutorPeloNome(String nome) {

		String jpql = "select autor " + " from Autor as autor "
				+ " where lower(autor.nome) " + " like lower(:busca) "
				+ " order by autor.nome";

		Query q = this.manager.createQuery(jpql);
		q.setParameter("busca", "%" + nome + "%");

		return q.getResultList();
	}

	@Override
	public List<Livro> buscaLivroPaginacao(String nome, int primeira, int maxima) {
		String jpql = "Select livro " + " from Livro as livro "
				+ " where lower(livro.nome) " + " like lower(:busca) "
				+ " order by livro.nome";
		Query q = this.manager.createQuery(jpql);
		q.setParameter("busca", "%" + nome + "%");
		q.setFirstResult(primeira);
		q.setMaxResults(maxima);
		return q.getResultList();
	}

	@Override
	public List<Livro> buscaLivroPeloNomeEPreco(String nomeDoLivro,
			double precoDoLivro) {
		String jpql = "SELECT livro from Livro as livro where livro.nome like :nome "
				+ " and livro.preco = :preco";
		Query q = this.manager.createQuery(jpql);
		q.setParameter("nome", "%" + nomeDoLivro + "%");
		q.setParameter("preco", precoDoLivro);
		return q.getResultList();
	}

	@Override
	@RolesAllowed({ "administrador" })
	public List<Livro> listaLivros() {
		return this.manager.createQuery("select livro from Livro as livro")
				.getResultList();
	}

}
