import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { MilitaryCompanies } from "../model/militaryCompanies";
import {MilitaryCompanyDetails} from  "../model/militaryCompany-details";
import {MilitaryCompanyForm} from "../model/militaryCompany-form"
import { Soldiers } from '../../Soldier/model/soldiers';

@Injectable({
  providedIn: 'root'
})
export class MilitaryCompanyService {
  constructor(private http: HttpClient) {

  }
  getCompanies(): Observable<MilitaryCompanies> {
    return this.http.get<MilitaryCompanies>('/military-company/companies');
  }

  getSoldiersCompany(uuid: string): Observable<Soldiers> {
    return this.http.get<Soldiers>('/soldier/soldiersCompany/' + uuid);
  }
  deleteSoldier(uuid: string): Observable<any> {
    return this.http.delete('/soldier/delete/' + uuid);
  }
  getCompany(uuid: string): Observable<MilitaryCompanyDetails> {
    return this.http.get<MilitaryCompanyDetails>('/military-company/one-company/'+ uuid)
  }
  deleteCompany(uuid: string): Observable<any> {
    return this.http.delete('/military-company/delete/' + uuid);
  }
  putCompany(uuid:string, request: MilitaryCompanyForm): Observable<any> {
    return this.http.put('/military-company/create/' + uuid, request);
  }
  updateCompany(uuid: string, request: MilitaryCompanyForm): Observable<any> {
    return this.http.put('/military-company/update/' + uuid, request);
  }

}
