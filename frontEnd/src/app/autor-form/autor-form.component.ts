import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-autor-form',
  templateUrl: './autor-form.component.html',
  styleUrls: ['./autor-form.component.css']
})
export class AutorFormComponent implements OnInit {

  autorDialog = false;

  autores = [];

  autor = {};

  selectedAutor = [];

  submitted = false;





  constructor(private messageService: MessageService, private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
  }

  openNew() {
    this.autor = {};
    this.submitted = false;
    this.autorDialog = true;
}

deleteSelectedProducts() {
  this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir os produtos selecionados?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        //  this.autor = this.autor.filter(val => !this.selectedAutor.includes(val));
         // this.selectedProducts = null;
          this.messageService.add({severity:'success', summary: 'Successful', detail: 'Products Deleted', life: 3000});
      }
  });
}

editProduct() {
  //this.product = {...product};
  this.autorDialog = true;
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

