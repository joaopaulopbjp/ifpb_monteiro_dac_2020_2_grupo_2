import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-menu-admin',
  templateUrl: './menu-admin.component.html',
  styleUrls: ['./menu-admin.component.css']
})
export class MenuAdminComponent implements OnInit {

  items: MenuItem[];
  rota = '/autor';
  activeItem: MenuItem;
  constructor() {
    this.items = [];
    this.activeItem = {};
  }



  ngOnInit() {
    this.items = [
      { label: 'Home', icon: 'pi pi-fw pi-home' },
      { label: 'Autor', icon: 'pi pi-user-plus' },
      { label: 'Pedido', icon: 'pi pi-folder-open' },
      { label: 'Livro', icon: 'pi pi-book' },
      { label: 'Estoque', icon: 'pi pi-inbox' },
      { label: 'Categoria', icon: 'pi pi-tags' },
      { label: 'Endereço', icon: 'pi pi-map' },
      { label: 'Pagamento', icon: 'pi pi-money-bill' },
      { label: 'Settings', icon: 'pi pi-fw pi-cog' },
    ];

    this.activeItem = this.items[0];
  }
  testRouts(): string {
    if (this.activeItem.label === 'Home') {
      this.rota = '/admin';
      console.log(this.rota);
    } else if (this.activeItem.label === 'Autor') {
      this.rota = 'autor';

    }
    return this.rota;
  }



}
