import { PortalAdminComponent } from './portal-admin/portal-admin.component';
import { CategoriaFormComponent } from './categoria-form/categoria-form.component';
import { PagamentoFormComponent } from './pagamento-form/pagamento-form.component';
import { CaroselComponent } from './carosel/carosel.component';
import { RodapeBarComponent } from './rodape-bar/rodape-bar.component';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import { AutorFormComponent } from './autor-form/autor-form.component';
import { NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LivroCardComponent } from './livro-card/livro-card.component';


const routes: Routes = [
  {path: 'autor' , component: AutorFormComponent},
  {path: 'home' , component: LivroCardComponent},
  {path: 'livro' , component: LivroCardComponent},
  {path: 'pagamento' , component: PagamentoFormComponent},
  {path: 'categoria' , component: CategoriaFormComponent},
  {path: 'admin' , component: PortalAdminComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
