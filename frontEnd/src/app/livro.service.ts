import { MessageService } from 'primeng/api';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LivroService {

  erro = {mensagemUsuario: '', mensagem: ''};

  readonly apiURL: string;

  readonly urlEstoque: string;

  constructor(private http: HttpClient, private messageService: MessageService) {
    this.apiURL = 'http://localhost:8080/book';

    this.urlEstoque = 'http://localhost:8080/estoque';
  }

  listAll(): Promise<any> {
    return this.http.get<any>(`${this.apiURL}?tudo`)
      .toPromise()
      .then(response => response.content);
  }

  salvar(product: any): Promise<any> {

    return this.http.post<any>(`${this.apiURL}`, product)
      .toPromise()
      .then(response => response.content)
      .catch((err: HttpErrorResponse) => {
        this.messageService.add({ severity: 'error', summary: 'Erro ao salvar', detail: `${err.message}`, life: 10000 });
        console.error('An error occurred:', err.error);
      });



  }

  delete(id: number): Promise<any> {
    return this.http.delete(`${this.apiURL}/${id}`)
      .toPromise()
      .then(() => null);
  }

  update(livro: any): Promise<any> {
    return this.http.put<any>(`${this.apiURL}/${livro.id}`, livro)
      .toPromise()
      .then(response => response.content)
      .catch(erro => {
        return Promise.reject(`Erro ao alterar autor ${livro.id}.`);
      });
  }

  salvarEstoque(estoque: any): Promise<any> {

    return this.http.post<any>(`${this.urlEstoque}`, estoque)
      .toPromise()
      .then(response => response.content)
      .catch((err: HttpErrorResponse) => {
        this.messageService.add({ severity: 'error', summary: 'Erro ao salvar', detail: `${err.message}`, life: 10000 });
        console.error('An error occurred:', err.error);
      });



  }

}
