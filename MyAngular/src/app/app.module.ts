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
import { ChevalListComponent } from './cheval/cheval-list/cheval-list.component';
import { ChevalListChildComponent } from './cheval/cheval-list-child/cheval-list-child.component';
import { ChevalAddComponent } from './cheval/cheval-add/cheval-add.component';
import { ChevalDetailComponent } from './cheval/cheval-detail/cheval-detail.component';
import {Globals} from './framework/globals';
import {ChevalService} from './service/cheval.service';
import {CentreEquestreService} from './service/centreequestre.service';
import {UserTestService} from './service/usertest.service';
import {UserTestListComponent} from './usertest/usertest-list/usertest-list.component';
import {UserTestListChildComponent} from './usertest/usertest-list-child/usertest-list-child.component';
import {UserTestAddComponent} from './usertest/usertest-add/usertest-add.component';
import {UserTestDetailComponent} from './usertest/usertest-detail/usertest-detail.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: DashboardComponent},
  {path: 'cheval', component: ChevalListComponent},
  {path: 'cheval/:id', component: ChevalDetailComponent},
  {path: 'cheval-add', component: ChevalAddComponent},
  {path: 'cheval-edit/:id', component: ChevalAddComponent},
  {path: 'usertest', component: UserTestListComponent},
  {path: 'usertest/:id', component: UserTestDetailComponent},
  {path: 'usertest-add', component: UserTestAddComponent},
  {path: 'usertest-edit/:id', component: UserTestAddComponent}
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
    ChevalDetailComponent,
    UserTestListComponent,
    UserTestListChildComponent,
    UserTestAddComponent,
    UserTestDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [Globals, ChevalService, CentreEquestreService, UserTestService],
  bootstrap: [AppComponent]
})

export class AppModule { }
