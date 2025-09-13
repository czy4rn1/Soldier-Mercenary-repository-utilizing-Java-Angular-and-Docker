import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MilitaryCompanyService } from "../../service/militaryCompany.service";
import { Soldiers } from "../../../Soldier/model/soldiers"
import { SoldierService } from "../../../Soldier/service/soldier.service"
import { MilitaryCompanyFormCreate } from '../../model/militaryCompany-formCreate';
import { MilitaryCompanyForm } from '../../model/militaryCompany-form';


@Component({
  selector: 'app-militaryCompany-create',
  templateUrl: './militaryCompany-create.component.html',
  styleUrls: ['./militaryCompany-create.component.css']
})
export class MilitaryCompanyAdditionComponent implements OnInit {
  uuid: string | undefined;
  militaryCompany: MilitaryCompanyForm = new class MilitaryCompanyForm {
    name: string = "";
    foundingYear: number = 0;
  }
  original: MilitaryCompanyForm | undefined;
  constructor(
    private militaryCompanyService: MilitaryCompanyService,
    private route: ActivatedRoute,
    private router: Router,
  ) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.militaryCompanyService.getCompany(params['uuid'])
        .subscribe(militaryCompany => {
          this.militaryCompany = {
            name: militaryCompany.name,
            foundingYear: militaryCompany.foundingYear
          };
          this.original = {...this.militaryCompany};
        });
    });
  }
  onSubmit(): void {
    this.militaryCompanyService.putCompany(this.uuid!, this.militaryCompany!)
      .subscribe(() => this.router.navigate(['/companies']));
  }

}
