import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {

  quantCarrinho: number

  livros: [];

  constructor(private router: Router,) {
    this.quantCarrinho = 0;
    this.livros = [];
  }

  ngOnInit(): void {
    this.quantCarrinho = this.livros.length;
  }

  addCarinho(livro: any){
       this.livros.push();
  }
  listar(id: number){
     this.router.navigate(['/home', id]);
  }

}
