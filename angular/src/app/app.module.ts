import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { SoldierListComponent } from './Soldier/view/soldier-list/soldier.list.component';
import { SoldierService } from './Soldier/service/soldier.service';
import { SoldierViewComponent } from './Soldier/view/soldier-view/soldier-view.component';
import { SoldierEditComponent } from './Soldier/view/soldier-edit/soldier-edit.component';
import { MilitaryCompanyListComponent } from "./MilCompany/view/militaryCompany-list/militaryCompany.list.component";
import { MilitaryCompanyViewComponent } from "./MilCompany/view/militaryCompany-view/militaryCompany-view.component";
import { MilitaryCompanyEditComponent } from "./MilCompany/view/militaryCompany-edit/militaryCompany-edit.component";
import { MilitaryCompanyAdditionComponent } from './MilCompany/view/militaryCompany-create/militaryCompany-create.component';
import { MilitaryCompanyService} from "./MilCompany/service/militaryCompany.service";
import { FormsModule } from "@angular/forms";
import { SoldierAdditionComponent } from './Soldier/view/soldier-create/soldier-create.component';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    SoldierListComponent,
    SoldierViewComponent,
    SoldierEditComponent,
    SoldierAdditionComponent,
    MilitaryCompanyListComponent,
    MilitaryCompanyViewComponent,
    MilitaryCompanyEditComponent,
    MilitaryCompanyAdditionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    SoldierService,
    MilitaryCompanyService
  ],
  exports: [
    HeaderComponent,
    NavComponent,
    MainComponent,
    FooterComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
