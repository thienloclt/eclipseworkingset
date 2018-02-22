import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { ChevalListComponent } from './cheval/chevallist/chevallist.component';
import { ChevalListChildComponent } from './cheval/chevallist-child/chevallist-child.component';
import { ChevalService} from './cheval.service';
import { ChevalAddComponent } from './cheval/cheval-add/cheval-add.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChevalDetailComponent } from './cheval/cheval-detail/cheval-detail.component';

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
  providers: [ChevalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
