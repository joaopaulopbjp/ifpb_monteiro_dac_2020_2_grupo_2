package com.atividade.main.view;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.mail.MessagingException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.atividade.main.controller.AutorController;
import com.atividade.main.controller.BookController;
import com.atividade.main.controller.CategoriaController;
import com.atividade.main.controller.EditoraController;
import com.atividade.main.controller.EnderecoController;
import com.atividade.main.controller.EstoqueController;
import com.atividade.main.controller.PagamentoController;
import com.atividade.main.controller.PedidoController;
import com.atividade.main.controller.UsuarioController;
import com.atividade.main.model.Autor;
import com.atividade.main.model.Book;
import com.atividade.main.model.BookPedido;
import com.atividade.main.model.Email;
import com.atividade.main.model.Endereco;
import com.atividade.main.model.Pedido;
import com.atividade.main.model.Usuario;


@Component
public class MenuRetaguarda {
	private int option;
	private int menu = 0;

	@SuppressWarnings("unused")
	private final AutorController autorController;

	@SuppressWarnings("unused")
	private final BookController bookController;
	
	@SuppressWarnings("unused")
	private final Email email;
	
	@SuppressWarnings("unused")
	private final UsuarioController usuarioController;

	@SuppressWarnings("unused")
	private final EditoraController editoraController;
	
	@SuppressWarnings("unused")
	private final EnderecoController enderecoController;
	
	@SuppressWarnings("unused")
	private final EstoqueController estoqueController;
	
	@SuppressWarnings("unused")
	private final PedidoController pedidoController;
	
	@SuppressWarnings("unused")
	private final CategoriaController categoriaController;

	@SuppressWarnings("unused")
	private final PagamentoController pagamentoController;
	
	
	
	public MenuRetaguarda(AutorController  autorController, BookController bookController,Email email, 
			UsuarioController usuarioController, EditoraController editoraController,EnderecoController enderecoController,
			EstoqueController estoqueController, PedidoController pedidoController, 
			CategoriaController categoriaController, PagamentoController pagamentoController) {
		
		this.autorController=autorController;
		this.bookController=bookController;
		this.email = email;
		this.usuarioController = usuarioController;
		this.editoraController = editoraController;
		this.enderecoController = enderecoController;
		this.estoqueController = estoqueController;
		this.pedidoController = pedidoController;
		this.categoriaController = categoriaController;
		this.pagamentoController = pagamentoController;

		Scanner load = new Scanner(System.in);
		Endereco end;
		List<Endereco> listaEnd;
		Usuario usuario;

		while (menu < 9) {

			System.out.println("\n*----Menu do System Livraria---*"
					+ "\n-----------------------------------\n"
					+ "0.Fechar"
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
					+ "9.Cadastro de usuario\n" 
					+ "10.Editar usuario\n" 
					+ "11.Excluir usuario\n"
					+ "12.Listar usuario\n"
					+ "13.Consulta usuario pelo email\n"
					+ "===============================\n"
					+ "14.Listar os 5 livros mais baratos disponíveis"
					+ "15.Adicionar um livro ao estoque"
					);
			
			System.out.println("Digite um numero do que deseja fazer ?");
			
			option = Integer.parseInt(load.nextLine());
			
			if (option == 0) {
				menu = 0;
				System.err.println("Finalizado...");
				load.close();
				System.exit(0);
			}

			else if (option == 1) {
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

			} else if (option == 5) {
//				instancia do objeto autor
				Book book = new Book();
				System.out.println("Digite o titulo do livro?");
				book.setTitulo(load.nextLine());
				System.out.println("Digite a descrição do livro?");
				book.setDescricao(load.nextLine());
				System.out.println("Digite o preço?");
				book.setPrice(BigDecimal.valueOf(Float.parseFloat(load.nextLine())));

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
						book.setPrice(BigDecimal.valueOf(Float.parseFloat(preco)));
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
				int pag = 0;
				listarLivroPAginado(pag);
				System.out.println(
				"\n*----Nossos Produtos---*"
				+ "\n-----------------------------------\n"
				+ "0. Sair/ "
				+ "1. proximo/ "
				+ "2. Volta/ "
				+ "3. Compra"
				);
				
				int condicao = Integer.parseInt(load.nextLine());
				
				if(condicao == 0 ) {
					menu = 16;
				}
				else if (condicao == 1) {
					pag++;
					listarLivroPAginado(pag);
				}
				else if (condicao == 2) {
					if (pag == 0) {
						listarLivroPAginado(pag);
					}
					else {
						pag--;
						listarLivroPAginado(pag);
					}
				}
				else if (condicao == 3) {
					Pedido pedido = new Pedido();
					pedidoController.save(pedido);
					pedido.setTotal(new BigDecimal(0.00f));
	
					System.out.println("Insira o codigo do livro: ");
					long codLivro = Long.parseLong(load.nextLine());
					Book livro = bookController.getBookPorId(codLivro);
					
					BookPedido bp = new BookPedido();
					bp.setBookId(livro);
					bp.setPedidoId(pedido);
					System.out.println("Infome a quatidade: ");
					
					int quantidade = 1;
					quantidade = Integer.parseInt(load.nextLine());
					
					if (quantidade > 0) {
						bp.setQuantidadeVendida(quantidade);
						List<BookPedido>lista=new ArrayList<>();
						lista.add(bp);
						pedido.setListaPedido(lista);
						pedidoController.save(pedido);
						menu=16;
					}
					
					
				}
				
			}
			else if (option == 9) {
				
				usuario = new Usuario();
				
				System.out.println("Digite o nome?");
				usuario.setNome(load.nextLine());
				
				System.out.println("Digite a Nacionalidade do autor?");
				usuario.setCPF(load.nextLine());
				
				System.out.println("Digite o celular?");
				usuario.setCelular(load.nextLine());
				
				System.out.println("Digite o Email?");
				usuario.setEmail(load.nextLine());
				
				System.out.println("Digite a senha?");
				usuario.setSenha(load.nextLine());

				System.out.println("Digite o F ou M para sexo do autor?");
				usuario.setSexo(load.nextLine());

				end = new Endereco();
				System.out.println("Digitar o Cep?");
				end.setCep(load.nextLine());
				System.out.println("Digitar o rua?");
				end.setRua(load.nextLine());
				System.out.println("Digitar o Bairro?");
				end.setBairro(load.nextLine());
				System.out.println("Digitar o Cidade?");
				end.setCidade(load.nextLine());
				System.out.println("Digitar o Complemento?");
				end.setComplemento(load.nextLine());
				System.out.println("Digitar o Numero?");
				end.setNumero(load.nextInt());
				System.out.println("Digitar o Ponto de referencia?");
				end.setPontoReferencia(load.nextLine());
				System.out.println("Digitar o UF?");
				end.setUF(load.nextLine());
				
				listaEnd = new ArrayList<>() ;

				listaEnd.add(end);

				System.out.println("Deseja adicionar mais um endereco? S/N");
				String condicaoEnd = load.nextLine();				
				
				while (condicaoEnd.equals("S")) {
				
					System.out.println("Deseja adicionar mais um endereco? S/N");
					end = new Endereco();
					listaEnd = new ArrayList<>() ;
					listaEnd.add(end);
					
					
				}
				
				usuarioController.save(usuario);
				System.out.println("Salvo com sucesso!");
			}
			
			else if (option == 10) {
				
				System.out.println("Digite o codigo do usuario para alterar?");
				long cod = Long.parseLong(load.nextLine());
				
//				buscando o autor no banco para auterar
				usuario = usuarioController.findById(cod);
				
				usuario = new Usuario();
				
				System.out.println("Digite o nome?");
				usuario.setNome(load.nextLine());
				
				System.out.println("Digite a cpf?");
				usuario.setCPF(load.nextLine());
				
				System.out.println("Digite o celular?");
				usuario.setCelular(load.nextLine());
				
				System.out.println("Digite o Email?");
				usuario.setEmail(load.nextLine());
				
				System.out.println("Digite a senha?");
				usuario.setSenha(load.nextLine());

				System.out.println("Digite o F ou M para sexo do autor?");
				usuario.setSexo(load.nextLine());
				
//			salvar objeto do usuario no banco
				usuarioController.save(usuario);

			}
			
			else if (option == 11) {
				
				Pageable sortedByAcendente = PageRequest.of(0, 3, Sort.by("nome"));
				
				Page<Usuario> page = usuarioController.getListaOrdenadaAsedente(sortedByAcendente);
				for (Usuario user : page) {
					System.out.println("|Cod: " + user.getUserID() + " |Nome: " + user.getNome() + " |Sexo:" + user.getSexo()
							+ " |CPF: " + user.getCPF() + " |Celular " + user.getCelular() + " |Email: " + user.getEmail()
							+ "\n------------------------------------------------------------------");

				}
				System.out.println("Digite Codigo do usuario a ser excluido?");
				long cod = load.nextLong();
				usuarioController.excluir(cod);

			} 
			
			else if (option == 12) {
				
			Pageable sortedByAcendente = PageRequest.of(0, 3, Sort.by("nome"));
			
			Page<Usuario> page = usuarioController.getListaOrdenadaAsedente(sortedByAcendente);
			for (Usuario user : page) {
				System.out.println("|Cod: " + user.getUserID() + " |Nome: " + user.getNome() + " |Sexo:" + user.getSexo()
						+ " |CPF: " + user.getCPF() + " |Celular " + user.getCelular() + " |Email: " + user.getEmail()
						+ "\n------------------------------------------------------------------");

			}
			}
			else if (option == 13) {
				System.out.println("Digite o email do usuario: ");
				Usuario user = usuarioController.getUsuarioPorEmail(load.nextLine());
				
				System.out.println("|Cod: " + user.getUserID() + " |Nome: " + user.getNome() + " |Sexo:" + user.getSexo()
						+ " |CPF: " + user.getCPF() + " |Celular " + user.getCelular() + " |Email: " + user.getEmail()
						+ "\n------------------------------------------------------------------");
			}
			else if (option == 14) {
				System.out.println("5 livros mais baratos disponíveis no estoque");
				Page<Book> page = bookController.getListaCincoMaisBaratos();
				
				for (Book book : page) {
					System.out.println("|Cod ISBN: " + book.getISBN() + " |Titulo: " + book.getTitulo() + " |Descrição:" + book.getDescricao()
							+ " |Capa: " + book.getCapa() + " |Edição " + book.getEdicao() + " |Categoria: " + book.getCategoria()
							+ " |Ano : "+book.getAnoPublicacao() + " | Cod ID: "+ book.getLivroId() + " |:"+ book.getPrice()
							+ "\n------------------------------------------------------------------");

				}
			}
			
			
			
			
			else {
				System.err.println("Opção inválida digite os numero correto!");
			}
		}
		
	}

	public void listarLivroPAginado(int pag) {
		
		Pageable sortedByAcendente = PageRequest.of(pag, 5, Sort.by(Sort.Direction.ASC));
		Page<Book> page = bookController.getAllBookList(sortedByAcendente);
		for (Book a : page) {
			System.out.println("|Cod: " + a.getLivroId() + " |Titulo: " + a.getTitulo() + " |Descrição:"
					+ a.getDescricao() + " |Preço: " + a.getPrice());
			for (Autor b : a.getListAutor()) {
				System.out.println("|Autores:" + b.getNome());
				
			}
			System.out.print("--------------------------------------------\n");
		}
	}
}
