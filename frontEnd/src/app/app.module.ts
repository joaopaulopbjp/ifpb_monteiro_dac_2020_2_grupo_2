import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LivroCardComponent } from './livro-card/livro-card.component';
import { LivroFormComponent } from './livro-form/livro-form.component';
import {AvatarModule} from 'primeng/avatar';
import {AvatarGroupModule} from 'primeng/avatargroup';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {CalendarModule} from 'primeng/calendar';
import {SliderModule} from 'primeng/slider';
import {MultiSelectModule} from 'primeng/multiselect';
import {ContextMenuModule} from 'primeng/contextmenu';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {ProgressBarModule} from 'primeng/progressbar';
import {InputTextModule} from 'primeng/inputtext';
import {FileUploadModule} from 'primeng/fileupload';
import {ToolbarModule} from 'primeng/toolbar';
import {RatingModule} from 'primeng/rating';
import {RadioButtonModule} from 'primeng/radiobutton';
import {InputNumberModule} from 'primeng/inputnumber';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { TooltipModule } from 'primeng/tooltip';
import {DividerModule} from 'primeng/divider';
import {BadgeModule} from 'primeng/badge';
import {CarouselModule} from 'primeng/carousel';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import { RodapeBarComponent } from './rodape-bar/rodape-bar.component';
import { CaroselComponent } from './carosel/carosel.component';



@NgModule({
  declarations: [
    AppComponent,
    LivroCardComponent,
    LivroFormComponent,
    MenuBarComponent,
    RodapeBarComponent,
    CaroselComponent,
  ],
  imports: [
    CarouselModule,
    BadgeModule,
    BrowserModule,
    AppRoutingModule,
    AvatarModule,
    AvatarGroupModule,
    InputTextModule,
    ButtonModule,
    BrowserAnimationsModule,
    TableModule,
    CalendarModule,
SliderModule,
DialogModule,
MultiSelectModule,
ContextMenuModule,
DropdownModule,
ButtonModule,
ToastModule,
    InputTextModule,
    ProgressBarModule,
    HttpClientModule,
    FileUploadModule,
    ToolbarModule,
    RatingModule,
    FormsModule,
    RadioButtonModule,
    InputNumberModule,
    ConfirmDialogModule,
    InputTextareaModule,
    TooltipModule,
    DividerModule,
    RouterModule.forRoot([
    {path: '', component: AppComponent}


    ])
  ],
  bootstrap:    [ AppComponent ],
  providers: [MessageService, ConfirmationService]
})
export class AppModule { }
