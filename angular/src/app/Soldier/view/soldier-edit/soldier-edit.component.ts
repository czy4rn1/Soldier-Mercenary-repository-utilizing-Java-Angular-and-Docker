import { Component, OnInit } from '@angular/core';
import { SoldierService } from '../../service/soldier.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SoldierForm } from '../../model/soldier-form';
import { MilitaryCompanyService } from "../../../MilCompany/service/militaryCompany.service";
import { MilitaryCompanies } from "../../../MilCompany/model/militaryCompanies";

@Component({
  selector: 'app-soldier-edit',
  templateUrl: './soldier-edit.component.html',
  styleUrls: ['./soldier-edit.component.css']
})
export class SoldierEditComponent implements OnInit {
  uuid: string | undefined;
  soldier: SoldierForm = new class implements SoldierForm {
    codename:string  = "";
    specialty: string = "";
    skillRank: number = 0;
    militaryCompany: string = "";
  };
  original: SoldierForm | undefined;
  militaryCompanies: MilitaryCompanies | undefined;
  constructor(
    private soldierService: SoldierService,
    private companyService: MilitaryCompanyService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.companyService.getCompanies()
        .subscribe(militaryCompanies => this.militaryCompanies = militaryCompanies);

      this.soldierService.getSoldier(params['uuid'])
        .subscribe(soldier => {
          this.uuid = soldier.id;
          this.soldier = {
            codename: soldier.codename,
            specialty: soldier.specialty,
            skillRank: soldier.skillRank,
            militaryCompany: soldier.militaryCompany
          };
          this.original = {...this.soldier};
        });
    });
  }
  onSubmit(): void {
    this.soldierService.updateSoldier(this.uuid!, this.soldier!)
      .subscribe(() => this.router.navigate(['/companies', this.soldier.militaryCompany]));
  }

}
