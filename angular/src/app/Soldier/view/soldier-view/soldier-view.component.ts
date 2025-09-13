import { Component, OnInit } from '@angular/core';
import { SoldierService } from "../../service/soldier.service";
import { ActivatedRoute, Router } from "@angular/router";
import { SoldierDetails } from "../../model/soldier-details";

@Component({
  selector: 'app-soldier-view',
  templateUrl: './soldier-view.component.html',
  styleUrls: ['./soldier-view.component.css']
})
export class SoldierViewComponent implements OnInit {
  soldier: SoldierDetails | undefined;
    constructor(private service: SoldierService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getSoldier(params['uuid'])
        .subscribe(soldier => this.soldier = soldier)
    });
  }

}
