import { Component, OnInit } from '@angular/core';
import { MilitaryCompanyService } from "../../service/militaryCompany.service";
import { ActivatedRoute, Router } from "@angular/router";
import { MilitaryCompanyDetails } from "../../model/militaryCompany-details";
import { Soldiers } from "../../../Soldier/model/soldiers";
import { Soldier } from '../../../Soldier/model/soldier';

@Component({
  selector: 'app-militaryCompany-view',
  templateUrl: './militaryCompany-view.component.html',
  styleUrls: ['./militaryCompany-view.component.css']
})
export class MilitaryCompanyViewComponent implements OnInit {
  militaryCompany: MilitaryCompanyDetails = new class implements MilitaryCompanyDetails {
    id:string = "";
    name: string = "";
    foundingYear: number = 0;
  };
  soldiers: Soldiers | undefined;
    constructor(private service: MilitaryCompanyService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getCompany(params['uuid'])
        .subscribe(militaryCompany => this.militaryCompany = militaryCompany)
      this.service.getSoldiersCompany(params['uuid']).subscribe(soldiers => this.soldiers = soldiers)
    });
  }

  onDelete(soldier: Soldier): void {
    this.service.deleteSoldier(soldier.id).subscribe(() => this.ngOnInit());
  }

}
