import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SoldierListComponent } from "./Soldier/view/soldier-list/soldier.list.component";
import { SoldierViewComponent } from "./Soldier/view/soldier-view/soldier-view.component";
import { SoldierEditComponent } from "./Soldier/view/soldier-edit/soldier-edit.component";
import { MilitaryCompanyListComponent } from "./MilCompany/view/militaryCompany-list/militaryCompany.list.component";
import { MilitaryCompanyViewComponent } from "./MilCompany/view/militaryCompany-view/militaryCompany-view.component";
import { MilitaryCompanyEditComponent } from "./MilCompany/view/militaryCompany-edit/militaryCompany-edit.component";
import { MilitaryCompanyAdditionComponent } from './MilCompany/view/militaryCompany-create/militaryCompany-create.component';
import { SoldierAdditionComponent } from './Soldier/view/soldier-create/soldier-create.component';

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: MilitaryCompanyAdditionComponent,
    path: "companies/add"
  },
  {
    component: SoldierAdditionComponent,
    path: "companies/:uuid/soldiers/add"
  },
  {
    component: SoldierListComponent,
    path: "soldiers"
  },
  {
    component: SoldierViewComponent,
    path: "companies/:id/soldiers/:uuid"
  }
  ,
  {
    component: SoldierEditComponent,
    path: "companies/:id/soldiers/:uuid/edit"
  },
  {
    component: MilitaryCompanyListComponent,
    path: "companies"
  },
  {
    component: MilitaryCompanyViewComponent,
    path: "companies/:uuid"
  }
  ,
  {
    component: MilitaryCompanyEditComponent,
    path: "companies/:uuid/edit"
  },
  {
    component: SoldierEditComponent,
    path: "soldiers/:uuid/edit"
  },
  {
    component: SoldierViewComponent,
    path: "soldiers/:uuid"
  },

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
