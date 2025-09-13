import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Soldiers} from "../model/soldiers";
import {SoldierDetails} from "../model/soldier-details";
import {SoldierForm} from "../model/soldier-form";

@Injectable()
export class SoldierService {
  constructor(private http: HttpClient) {

  }

  getSoldiers(): Observable<Soldiers>{
    return this.http.get<Soldiers>('/soldier/soldiers');
  }

  getSoldiersCompany(uuid: string): Observable<Soldiers> {
    return this.http.get<Soldiers>('/soldier/soldiersCompany/' + uuid);
  }
  getSoldier(uuid: string): Observable<SoldierDetails> {
    return this.http.get<SoldierDetails>('/soldier/one-soldier/' + uuid);
  }
  deleteSoldier(uuid: string): Observable<any> {
    return this.http.delete('/soldier/delete/' + uuid);
  }
  putSoldier(uuid:string, request: SoldierForm): Observable<any> {
    return this.http.put('/soldier/create/' + uuid, request);
  }
  updateSoldier(uuid: string, request: SoldierForm): Observable<any> {
    return this.http.put('/soldier/update/' + uuid, request);
  }
}
