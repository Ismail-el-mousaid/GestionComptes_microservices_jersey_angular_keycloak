import { Component, OnInit } from '@angular/core';
import {ComptesService} from "../services/comptes.service";

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {
  public comptes: any;
  public errorMessage: any;

  constructor(private comptesService: ComptesService) { }

  ngOnInit(): void {
    this.comptesService.getComptes()
      .subscribe(data=>{
        this.comptes=data;
      },error => {
        this.errorMessage=error.error.message;
        console.log(error);
      })
  }

}
