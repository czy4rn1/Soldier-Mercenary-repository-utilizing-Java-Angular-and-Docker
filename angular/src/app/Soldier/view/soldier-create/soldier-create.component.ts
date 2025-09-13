import { Component, OnInit } from '@angular/core';
import { SoldierService } from '../../service/soldier.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SoldierForm } from '../../model/soldier-form';
import { MilitaryCompanyService } from "../../../MilCompany/service/militaryCompany.service";
import { MilitaryCompanies } from "../../../MilCompany/model/militaryCompanies";

@Component({
  selector: 'app-soldier-create',
  templateUrl: './soldier-create.component.html',
  styleUrls: ['./soldier-create.component.css']
})
export class SoldierAdditionComponent implements OnInit {
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
    this.route.params.subscribe(params => this.soldier.militaryCompany = params['uuid']);
  }
  onSubmit(): void {
    this.soldierService.putSoldier(this.uuid!, this.soldier!)
      .subscribe(() => this.router.navigate(['/companies', this.soldier.militaryCompany]));
  }

}
