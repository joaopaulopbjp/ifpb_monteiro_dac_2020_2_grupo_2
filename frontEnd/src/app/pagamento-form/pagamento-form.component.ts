import { Component, OnInit } from '@angular/core';
import { MessageService, ConfirmationService } from 'primeng/api';
import { AutorService } from '../autor.service';

@Component({
  selector: 'app-pagamento-form',
  templateUrl: './pagamento-form.component.html',
  styleUrls: ['./pagamento-form.component.css']
})
export class PagamentoFormComponent implements OnInit {

  options: any[];

  pagamentoDialog = false;

  pagamentos = [];

  pagamento = {descricao : ''};

  dataNasc: Date | undefined;

  selectedpagamentos = [];

  submitted = false;

  constructor(
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private autorService: AutorService
  ) {
    this.dataNasc = new Date();
    this.options = [{ label: 'Masculino', value: 'M' }, { label: 'Feminino', value: 'F' }];
  }

  ngOnInit(): void {
    this.listPagamento()
  }
  listPagamento() {

  }

}
