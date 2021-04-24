import { PagamentoService } from './../pagamento.service';
import { PagamentosService } from './../pagamentos.service';
import { MessageService, ConfirmationService } from 'primeng/api';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout-form',
  templateUrl: './checkout-form.component.html',
  styleUrls: ['./checkout-form.component.css']
})
export class CheckoutFormComponent implements OnInit {

  telaDialog = false;

  checkouts = [];

  checkout = {pagamentoId : '', descricao : ''};

  endereco = {endID: '', cep: '', rua: '', numero: '', bairro: '', cidade: '', UF: '',
  complemento: '', pontoReferencia: '', userID: ''};

  selectedpagamentos = [];

  submitted = false;

  constructor(
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private pagamentoService: PagamentoService,
    ) {


  }

  ngOnInit(){
    this.listAll();
  }


  listAll() {
    this.pagamentoService.listAll().then(pagamentos => {
      this.checkouts = pagamentos;
    });
  }

  // save(checkout: any) {
  //   this.submitted = true;
  //   this.checkoutService.salvar(checkout)
      // .then(0 => {
        // if (checkout.pagamentoId === '') {
        //   this.messageService.add({ severity: 'success', summary: 'Pagamento', detail: ' Cadastrado com sucesso', life: 3000 });
        // } else {
        //   this.messageService.add({ severity: 'success', summary: 'Pagamento', detail: 'Atualizado com sucesso', life: 3000 });
        // }
        // this.hideDialog();
        // this.listAll();
      // });
  // }
}
