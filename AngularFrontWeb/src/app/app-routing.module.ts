import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CompteComponent} from "./compte/compte.component";

const routes: Routes = [
  {path: "comptes", component: CompteComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
