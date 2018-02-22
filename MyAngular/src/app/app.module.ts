import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './framework/header/header.component';
import { FooterComponent } from './framework/footer/footer.component';
import { MenuComponent } from './framework/menu/menu.component';
import { DashboardComponent } from './framework/dashboard/dashboard.component';
import { ChevalService} from './service/cheval.service';
import { ChevalListComponent } from './cheval/cheval-list/cheval-list.component';
import { ChevalListChildComponent } from './cheval/cheval-list-child/cheval-list-child.component';
import { ChevalAddComponent } from './cheval/cheval-add/cheval-add.component';
import { ChevalDetailComponent } from './cheval/cheval-detail/cheval-detail.component';
import {Globals} from './framework/globals';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: DashboardComponent},
  {path: 'formtest', component: ChevalAddComponent},
  {path: 'cheval', component: ChevalListComponent},
  {path: 'cheval/:id', component: ChevalDetailComponent},
  {path: 'chevaladd', component: ChevalAddComponent},
  {path: 'cheval-edit/:id', component: ChevalAddComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    DashboardComponent,
    ChevalListComponent,
    ChevalListChildComponent,
    ChevalAddComponent,
    ChevalDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [ChevalService, Globals],
  bootstrap: [AppComponent]
})

export class AppModule { }
