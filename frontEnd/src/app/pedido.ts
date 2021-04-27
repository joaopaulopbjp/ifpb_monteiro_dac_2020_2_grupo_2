import { Data } from "@angular/router";

export interface Pedido {

pedidoID: number;
user: {};
total: number;
dataCriacao: Data;
status: string;
enderecoEntrega: {};
pagamento: {};
dataFechamento: Data;
listaPedido: [];
}
