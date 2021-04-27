import { Livro } from './livro';
import { MessageService } from 'primeng/api';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  readonly apiURL: string;

  carrinho: Livro[];

  constructor(private http: HttpClient, private messageService: MessageService) {
    this.apiURL = 'http://localhost:8080/pedido';
    this.carrinho = this.getCarrinho();
  }

  addCarrinho(livro: Livro) {
    this.carrinho.push(livro);
    console.log(livro);
    console.log(this.carrinho);


  }

  removeCarrinho() {
    this.carrinho.pop();
  }

  getCarrinho(): Livro[] {
    if (!this.carrinho) {
      return this.carrinho = [];

    } else {
      return this.carrinho;
    }

  }

  listAll(): Promise<any> {
    return this.http.get<any>(`${this.apiURL}`)
      .toPromise()
      .then(response => response.content);
  }

  salvar(pedido: any): Promise<any> {
    return this.http.post<any>(`${this.apiURL}`, pedido)
      .toPromise()
      .then(response => response.content)

  }

  delete(id: number): Promise<any> {
    return this.http.delete(`${this.apiURL}/${id}`)
      .toPromise()
      .then(() => null);
  }

  update(pedido: any): Promise<any> {
    return this.http.put<any>(`${this.apiURL}/${pedido.id}`, pedido)
      .toPromise()
      .then(response => response.content)
      .catch(erro => {
        return Promise.reject(`Erro ao alterar pedido ${pedido.id}.`);
      });
  }

}

