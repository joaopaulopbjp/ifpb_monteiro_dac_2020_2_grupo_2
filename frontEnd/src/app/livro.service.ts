import { MessageService } from 'primeng/api';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LivroService {

  readonly apiURL: string;

  constructor(private http: HttpClient, private messageService: MessageService,) {
    this.apiURL = 'http://localhost:8080/book';
  }

  listAll(): Promise<any> {
    return this.http.get<any>(`${this.apiURL}?tudo`)
      .toPromise()
      .then(response => response.content);
  }

  salvar(livro: any): Promise<any> {
    return this.http.post<any>(`${this.apiURL}`, livro)
      .toPromise()
      .then(response => response.content)

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

}
