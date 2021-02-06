package com.atividade.main.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.atividade.main.controller.AutorController;
import com.atividade.main.controller.BookController;
import com.atividade.main.model.Autor;
import com.atividade.main.model.Book;


@Component
public class MenuRetaguarda {
	private int option;
	private int tie = 0;

	
	@SuppressWarnings("unused")
	private final AutorController autorController;

	@SuppressWarnings("unused")
	private final BookController bookController;

	public MenuRetaguarda(AutorController  autorController, BookController bookController) {
		this.autorController=autorController;
		this.bookController=bookController;
	

		Scanner load = new Scanner(System.in);

		while (tie < 9) {

			System.out.println("\n*----Menu do System Livraria---*"
					+ "\n-----------------------------------\n"
					+ "1.Cadastro de Autor\n" 
					+ "2.Editar Autor\n" 
					+ "3.Excluir Autor\n"
					+ "4.Listar Altores\n"
					+ "===============================\n"
					+ "5.Cadastrar Livro\n" 
					+ "6.Editar Livro\n"
					+ "7.Excluir Livro\n"
					+ "8.Listar Livros\n" 
					+ "=====================\n" 
					+ "9.Fechar");
			System.out.println("Digite um numero do que deseja fazer ?");
			
			option = Integer.parseInt(load.nextLine());

			if (option == 1) {
				System.out.println("Digite o nome do autor?");

//			instancia do objeto autor
				Autor autor = new Autor();
				autor.setNome(load.nextLine());
				System.out.println("Digite o F ou M para sexo do autor?");
				autor.setSexo(load.nextLine());
				System.out.println("Digite a Nacionalidade do autor?");
				autor.setNacionalidade(load.nextLine());
				System.out.println("Digite a Data de Nascimento do autor?");
				autor.setDtNascimento(load.nextLine());

//			salvar objeto do autor no banco
				autorController.save(autor);
				System.out.println("Salvo com sucesso!");

			} else if (option == 2) {
				System.out.println("Digite o codigo do autor para alterar?");
				long cod = Long.parseLong(load.nextLine());
//				buscando o autor no banco para auterar
				Autor autor = autorController.findById(cod);
				System.out.println("Digite o Novo nome?");
				autor.setNome(load.nextLine());
				System.out.println("Digite o F ou M para sexo do autor?");
				autor.setSexo(load.nextLine());
				System.out.println("Digite a Nacionalidade do autor?");
				autor.setNacionalidade(load.nextLine());
				System.out.println("Digite a Data de Nascimento do autor?");
				autor.setDtNascimento(load.nextLine());

//			salvar objeto do autor no banco
				autorController.save(autor);

			} else if (option == 3) {

				Pageable sortedByAcendente = PageRequest.of(0, 3, Sort.by("AutorId"));
				Page<Autor> page = autorController.getListaOrdenadaAsedente(sortedByAcendente);
				for (Autor a : page) {
					System.out.println("|Cod: " + a.getAutorId() + " |Nome: " + a.getNome() + " |Sexo:" + a.getSexo()
							+ " |Nacionalidade: " + a.getNacionalidade() + "|Data de Nascimento: " + a.getDtNascimento()
							+ "\n------------------------------------------------------------------");

				}
				System.out.println("Digite Codigo do Autor a ser excluido?");
				long cod = load.nextLong();
				autorController.excluir(cod);

			} else if (option == 4) {
				Pageable sortedByAcendente = PageRequest.of(0, 3, Sort.by("nome"));
				Page<Autor> page = autorController.getListaOrdenadaAsedente(sortedByAcendente);
				for (Autor a : page) {
					System.out.println("|Cod: " + a.getAutorId() + " |Nome: " + a.getNome() + " |Sexo:" + a.getSexo()
							+ " |Nacionalidade: " + a.getNacionalidade() + " |Data de Nascimento: " + a.getDtNascimento()
							+ "\n------------------------------------------------------------------");

				}
				System.out.println("Autor Excluido com sucesso!");

			} else if (option == 5) {
//				instancia do objeto autor
				Book book = new Book();
				System.out.println("Digite o titulo do livro?");
				book.setTitulo(load.nextLine());
				System.out.println("Digite a descrição do livro?");
				book.setDescricao(load.nextLine());
				System.out.println("Digite o preço?");
				book.setPrice(Float.parseFloat(load.nextLine()));

				long id = -1;
				List<Autor> lista = new ArrayList<>();
				while (id != 0) {

					System.out.println("Digite o codigo do autor do livro? ou digite zero para finalizar ");
					id = Long.parseLong(load.nextLine());
					Autor autor = null;   
					if(id>0) {
					  autor = autorController.findById(id);
					  System.out.println(autor.getNome());
						if (autor.equals(null)) {
						System.err.println("Autor não cadastrado!");
					   }else {
						lista.add(autor);
					}
					}

				}
//			salvar objeto do book no banco
				book.setListAutor(lista);
				bookController.save(book);
				System.out.println("Salvo com sucesso!");

			} else if (option == 6) {
				
				System.out.println("Digite o id livro para alterar?");
//			instancia do objeto autor
				Book book = null;
				long idBook = Long.parseLong(load.nextLine());
				book = bookController.getBookPorId(idBook);

				if (book.equals(null)) {
					System.out.println("Book não cadastrado!");
				} else {
					System.out.println("Digite o novo titulo do livro?");
					String titulo = load.nextLine();
					if (!titulo.equals("")) {
						book.setTitulo(titulo);
					}
					System.out.println("Digite a nova descrição do livro?");
					String descricao = load.nextLine();
					if (!descricao.equals("")) {
						book.setDescricao(descricao);
					}

					System.out.println("Digite o novo preço?");
					String preco = load.nextLine();
					if (!preco.equals("")) {
						book.setPrice(Float.parseFloat(preco));
					}

					long id = -1;
					List<Autor> lista = new ArrayList<Autor>();
					while (id != 0) {

						System.out.println("Digite o id do novo autor do livro? ou digite zero para ");
						id = Long.parseLong(load.nextLine());
						Autor autor = null;
						if(id>0) {
						autor = autorController.findById(id);
						System.out.println(autor.getNome());
						if (autor.equals(null)) {
							System.err.println("Autor não cadastrado!");
						} else {
							lista.add(autor);
						}
						}

					}

//			salvar objeto do book no banco
					book.setListAutor(lista);
					bookController.save(book);
					System.out.println("Alterado com sucesso!");
				}

			} else if (option == 7) {
				System.out.println("Digite o codigo do livro?");
				
				long idBook = Long.parseLong(load.nextLine());
				
				Book book = bookController.getBookPorId(idBook);
				
				System.out.println("|Cod: " + book.getLivroId() + " |Titulo: " + book.getTitulo() + " |Descrição:"
						+ book.getDescricao() + " |Preço: " + book.getPrice());
				System.out.print("--------------------------------------------\n");
				bookController.excluir(idBook);
				System.out.print("Livro excluindo com sucesso!");

			} else if (option == 8) {
				Page<Book> page = bookController.getListaOrdenadaAsedentePrice();
				for (Book a : page) {
					System.out.println("|Cod: " + a.getLivroId() + " |Titulo: " + a.getTitulo() + " |Descrição:"
							+ a.getDescricao() + " |Preço: " + a.getPrice());
					for (Autor b : a.getListAutor()) {
						System.out.println("|Autores:" + b.getNome());

					}
					System.out.print("--------------------------------------------\n");
				}

			} else if (option == 9) {
				tie = 9;
				load.close();
				System.exit(0);
				System.err.println("Finalizado...");
			} else {
				System.err.println("Opção inválida digite os numero correto!");
			}
		}
	}

}
