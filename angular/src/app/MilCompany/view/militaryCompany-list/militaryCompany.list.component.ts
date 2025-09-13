import { Component, OnInit } from '@angular/core';
import { MilitaryCompanyService } from "../../service/militaryCompany.service";
import { MilitaryCompanies } from "../../model/militaryCompanies";
import { MilitaryCompany } from "../../model/militaryCompany";

@Component({
  selector: 'app-militaryCompany-list',
  templateUrl: './militaryCompany.list.component.html',
  styleUrls: ['./militaryCompany.list.component.css']
})
export class MilitaryCompanyListComponent implements OnInit{
  constructor(private service: MilitaryCompanyService) {
  }
  militaryCompanies: MilitaryCompanies | undefined;
  ngOnInit(): void {
    this.service.getCompanies().subscribe(militaryCompanies => this.militaryCompanies = militaryCompanies);
  }

  onDelete(militaryCompany: MilitaryCompany): void {
    this.service.deleteCompany(militaryCompany.id).subscribe(() => this.ngOnInit());
  }

}
