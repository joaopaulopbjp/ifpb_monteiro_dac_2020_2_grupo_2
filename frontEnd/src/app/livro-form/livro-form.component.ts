import { LivroserviceService } from '../livro.service';
import { Component, OnInit } from '@angular/core';
import { MessageService, ConfirmationService } from 'primeng/api';

@Component({
  selector: 'app-livro-form',
  templateUrl: './livro-form.component.html',
  styleUrls: ['./livro-form.component.css']
})


export class LivroFormComponent implements OnInit {
  productDialog = false;

  products = [];

  product = {};

  selectedProducts = [];

  submitted = false;

  constructor(
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private livroservice: LivrosService) {

     }
  ngOnInit() {
    //this.productService.getProducts().then();

  }

  openNew() {
    this.product = {
      livroId: 0,
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
      estoque: 0
    };
    this.submitted = false;
    this.productDialog = true;
  }

  // tslint:disable-next-line: typedef
  deleteSelectedProducts() {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir os produtos selecionados?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter(val => !this.selectedProducts.includes(val));
        // this.selectedProducts = null;
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Products Deleted', life: 3000 });
      }
    });
  }

  // tslint:disable-next-line: typedef
  editProduct() {
    //this.product = {...product};
    this.productDialog = true;
  }

  deleteProduct() {
    this.confirmationService.confirm({
      message: 'Tem certeza de que deseja excluir' + '?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        //this.products = this.products.filter();
        this.product = {};
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Deleted', life: 3000 });
      }
    });
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    this.submitted = true;

    /*if (this.product.name.trim()) {
        if (this.product.id) {
            this.products[this.findIndexById(this.product.id)] = this.product;
            this.messageService.add({severity:'success', summary: 'Successful', detail: 'Product Updated', life: 3000});
        }
        else {
            this.product.id = this.createId();
            this.product.image = 'product-placeholder.svg';
            this.products.push(this.product);
            this.messageService.add({severity:'success', summary: 'Successful', detail: 'Product Created', life: 3000});
        }

        this.products = [...this.products];
        this.productDialog = false;
        /+this.product = {};
        */
  }
}
