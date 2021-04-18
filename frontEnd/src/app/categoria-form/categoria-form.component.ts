import { CategoriaService } from './../categoria.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Component, OnInit } from '@angular/core';




@Component({
  selector: 'app-categoria-form',
  templateUrl: './categoria-form.component.html',
  styleUrls: ['./categoria-form.component.css']
})

// tslint:disable-next-line: component-class-suffix
class Categoria {
  id: number;
  descricao: string;

  constructor() {
    this.id = 0;
    this.descricao = '';
  }
}


export class CategoriaFormComponent implements OnInit {

  categoria = new Categoria();

  telaDialog = false;

  submitted = false;

  categorias = [];

  selectedCategorias = [];


  constructor(

    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private categoriaService: CategoriaService) {
  }



  ngOnInit() {
    this.listAll();

  }

  openNew() {
    this.categoria = new Categoria();
    this.submitted = false;
    this.telaDialog = true;
  }

  listAll() {
    this.categoriaService.listAll().then(categoria => {
      this.categorias = categoria;
    });
  }


  deleteSelected() {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir os produtos selecionados?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        //    this.categoria = this.categoria.filter(val => !this.selectedEnderecos.includes(val));
        //   this.selectedProducts = null;
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Products Deleted', life: 3000 });
      }
    });
  }


  delete(id: number) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir categoria ?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.categoriaService.delete(id)
          .then(() => {
            this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Categoria Deletado com sucesso', life: 3000 });
            this.listAll();
          });

      }
    });
  }


  update(categoria: any) {
    this.categoria = { ...categoria };
    this.telaDialog = true;

  }


  save(categoria: any) {
    this.submitted = true;
    this.categoriaService.salvar(categoria)
      .then(enderecoSalvo => {
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Categoria Cadastrado com sucesso', life: 3000 });
        this.telaDialog = false;
        this.listAll();
      });
  }

  hideDialog() {
    this.telaDialog = false;
    this.submitted = false;
  }
}

