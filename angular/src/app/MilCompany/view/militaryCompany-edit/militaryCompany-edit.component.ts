import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MilitaryCompanyForm } from '../../model/militaryCompany-form';
import { MilitaryCompanyService } from "../../service/militaryCompany.service";
import { Soldiers } from "../../../Soldier/model/soldiers"
import { SoldierService } from "../../../Soldier/service/soldier.service"


@Component({
  selector: 'app-militaryCompany-edit',
  templateUrl: './militaryCompany-edit.component.html',
  styleUrls: ['./militaryCompany-edit.component.css']
})
export class MilitaryCompanyEditComponent implements OnInit {
  uuid: string | undefined;
  militaryCompany: MilitaryCompanyForm | undefined;
  original: MilitaryCompanyForm | undefined;
  soldiers: Soldiers | undefined;
  constructor(
    private militaryCompanyService: MilitaryCompanyService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.militaryCompanyService.getCompany(params['uuid'])
        .subscribe(militaryCompany => {
          this.uuid = militaryCompany.id;
          this.militaryCompany = {
            name: militaryCompany.name,
            foundingYear: militaryCompany.foundingYear
          };
          this.original = {...this.militaryCompany};
        });
    });
  }
  onSubmit(): void {
    this.militaryCompanyService.updateCompany(this.uuid!, this.militaryCompany!)
      .subscribe(() => this.router.navigate(['/companies']));
  }

}
