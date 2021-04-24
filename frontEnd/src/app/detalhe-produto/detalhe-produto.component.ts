import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detalhe-produto',
  templateUrl: './detalhe-produto.component.html',
  styleUrls: ['./detalhe-produto.component.css']
})
export class DetalheProdutoComponent implements OnInit {

  produto = { titulo: 'Educação', price: '100.0',
  autores : 'autor-test',
  edicao : 'Português',
  anoPublicacao: '2020',
  editora : 'Avelino',
  descricao : 'uguogogcuuhaouhcaoushc',
  capa: 'https://images.tcdn.com.br/img/img_prod/492765/pre_venda_do_livro_a_menina_do_sorriso_roubado_209_1_20181001120353.jpg'
}

  quantidade: number = 1;

  constructor() { }


  ngOnInit(): void {
  }

}
