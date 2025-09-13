import { Component, OnInit } from '@angular/core';
import { SoldierService } from "../../service/soldier.service";
import { Soldiers } from "../../model/soldiers";
import { Soldier } from "../../model/soldier";

@Component({
  selector: 'app-soldier-list',
  templateUrl: './soldier.list.component.html',
  styleUrls: ['./soldier.list.component.css']
})
export class SoldierListComponent implements OnInit{
  constructor(private service: SoldierService) {
  }
  soldiers: Soldiers | undefined;
  ngOnInit(): void {
    this.service.getSoldiers().subscribe(soldiers => this.soldiers = soldiers);
  }

  onDelete(soldier: Soldier): void {
    this.service.deleteSoldier(soldier.id).subscribe(() => this.ngOnInit());
  }

}
