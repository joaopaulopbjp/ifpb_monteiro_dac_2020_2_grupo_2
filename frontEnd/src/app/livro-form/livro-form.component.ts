import { AutorService } from './../autor.service';
import { LivroService } from './../livro.service';
import { Component, OnInit } from '@angular/core';
import { MessageService, ConfirmationService } from 'primeng/api';

@Component({
  selector: 'app-livro-form',
  templateUrl: './livro-form.component.html',
  styleUrls: ['./livro-form.component.css']
})


export class LivroFormComponent implements OnInit {
  telaDialog = false;

  products = [];

  autors = [];

  categorias = [];

  editoras = [];

  selectedAutores = [];

  product = {
    livroId: '',
    titulo: '',
    descricao: '',
    price: '',
    ISBN: '',
    capa: '',
    edicao: '',
    ano: '',
    anoPublicacao: '',
    categoria: '',
    editora: '',
    estoque: 0,
    autors: [{ autorId: '' }]
  };

  selectedProducts = [];

  submitted = false;

  constructor(
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private livroService: LivroService,
    private autorService: AutorService) {

  }
  ngOnInit() {
    //this.productService.getProducts().then();
    this.listAll();

  }

  openNew() {
    this.product = {
      livroId: '',
      titulo: '',
      descricao: '',
      price: '',
      ISBN: '',
      capa: '',
      edicao: '',
      ano: '',
      anoPublicacao: '',
      categoria: '',
      editora: '',
      estoque: 0,
      autors: [{ autorId: '' }]
    };
    this.listaNomesAutor();
    this.submitted = false;
    this.telaDialog = true;
  }

  listAll() {
    this.livroService.listAll().then(livros => {
      this.products = livros;
    });
  }

  deleteSelected() {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir os produtos selecionados?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter(val => !this.selectedProducts.includes(val));
        this.selectedProducts = [];
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Livros deletados em massa', life: 3000 });
      }
    });
  }

  // tslint:disable-next-line: typedef
  update(product: any) {
    this.product = { ...product };
    this.telaDialog = true;
  }

  delete(id: number, nome: string) {
    this.confirmationService.confirm({
      message: 'Tem certeza de que deseja excluir' + nome + '?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.livroService.delete(id)
          .then(() => {
            this.messageService.add({
              severity: 'success',
              summary: 'Successful',
              detail: 'Livro' + nome + 'Deletado com sucesso',
              life: 3000
            });
            this.listAll();
          });

      }
    });
  }

  hideDialog() {
    this.telaDialog = false;
    this.submitted = false;
  }

  save(prodoct: any) {
    this.submitted = true;
    this.livroService.salvar(prodoct)
      .then(autorSalvo => {
        if (prodoct.id === '') {
          this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Livro Cadastrado com sucesso', life: 3000 });
        } else {
          this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Livro Atualizado com sucesso', life: 3000 });
        }
        this.hideDialog();
        this.listAll();
      });
  }

listaNomesAutor() {
  this.autorService.listAutores().then(autores => {
    this.autors = autores;
  });
  }
}
