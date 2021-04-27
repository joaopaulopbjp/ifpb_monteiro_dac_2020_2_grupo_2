import { PedidoService } from './../pedido.service';
import { LivroService } from './../livro.service';
import { Component, OnInit } from '@angular/core';
import { PrimeNGConfig } from 'primeng/api';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro';

@Component({
  selector: 'app-livro-card',
  templateUrl: './livro-card.component.html',
  styleUrls: ['./livro-card.component.css']
})




export class LivroCardComponent implements OnInit {
  // tipo de consulta
  tipo = 1;

  product = {
    livroId: '',
    titulo: '',
    descricao: '',
    price: '',
    ISBN: '',
    capa: '',
    edicao: '',
    anoPublicacao: '',
    categoria: '',
    editora: '',
    estoque: 0,
  };

  products: [any];

  listCarrinho: [any];

  totalCarrinho: number;

  sortOptions = [{ label: 'Preço alto para baixo', value: '!price' },
  { label: 'Preço baixo para alto', value: 'price' }];

  sortOrder: number;

  sortField: string;


  constructor(private productService: LivroService, private primengConfig: PrimeNGConfig,
              private router: Router,
              private route: ActivatedRoute,
              private pedidoService: PedidoService) {
    this.products = [this.product];
    this.listCarrinho = [{}];
    this.sortField = '';
    this.sortOrder = 5;
    this.totalCarrinho = 0;


  }

  ngOnInit() {
    this.route.params.subscribe(params => this.tipo = + params['id']);

    if (this.tipo === 2) {
      this.listaCinco();
    } else {
      this.productService.listAll()
        .then(data => this.products = data);
    }



    this.sortOptions = [
      { label: 'Preço alto para baixo', value: '!price' },
      { label: 'Preço baixo para alto', value: 'price' }
    ];

    this.primengConfig.ripple = true;
  }

  onSortChange(event: { value: any; }) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    }
    else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  listaCinco() {
    this.productService.listCinco()
      .then(data => this.products = data);
  }

  addCarrinho(product: Livro) {
   this.pedidoService.addCarrinho(product);
   
  }


  option(livro: Livro){
    this.router.navigateByUrl('/detalhe-produto');
    this.productService.setLivro(livro);

  }


}
