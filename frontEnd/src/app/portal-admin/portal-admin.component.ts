import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-portal-admin',
  templateUrl: './portal-admin.component.html',
  styleUrls: ['./portal-admin.component.css']
})
export class PortalAdminComponent implements OnInit {

  boleto = 0;
  playpal = 0;
  ctdebito = 0;
  ctcredito = 0;
  total = 0;

  constructor() { }

  ngOnInit(): void {
  }

}
