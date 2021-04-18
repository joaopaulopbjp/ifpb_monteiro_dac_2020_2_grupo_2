import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {

  quantCarrinho: number

  livros: [];

  constructor() {
    this.quantCarrinho = 0;
    this.livros = [];
  }

  ngOnInit(): void {
    this.quantCarrinho = 0;
  }

}
