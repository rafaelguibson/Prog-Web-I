import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DatatableComponent} from "./component/datatable/datatable.component";

const routes: Routes = [
  { path: '', component: DatatableComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
