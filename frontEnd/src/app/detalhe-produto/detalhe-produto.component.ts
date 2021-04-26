import { LivroService } from './../livro.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Livro } from '../livro';

@Component({
  selector: 'app-detalhe-produto',
  templateUrl: './detalhe-produto.component.html',
  styleUrls: ['./detalhe-produto.component.css']
})
export class DetalheProdutoComponent implements OnInit {

  livro: Livro;
  quantidade = 1;
  total = 0;

  constructor(private router: Router, private livroService: LivroService) {
    const rota = this.router.getCurrentNavigation();
    this.livro = rota?.extras.state?.Livro;
    console.log(this.livro);
  }

  ngOnInit(): void {
    if (!this.livro) {
      this.livro = this.livroService.getLivro();
    }
  }

  finalizarPedido() {
    this.total = this.quantidade * this.livro.price;
    this.router.navigate(['/check', this.total]);
  }


}
