import { Component, OnInit } from '@angular/core';
import { Livro } from '../livro';
import { PedidoService } from '../pedido.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  livro!: Livro;

  carrinho: Livro[] = [];

  constructor( private pedidoService: PedidoService) {

  }

  ngOnInit(): void {
    this.statusCarrinho();
  }

  statusCarrinho(){
    this.carrinho = this.pedidoService.getCarrinho();
    console.log(this.carrinho);

 }

}
