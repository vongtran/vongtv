import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PersonListComponent } from "./person-list.component";

const routes: Routes = [
  {
    path: 'persons',
    component: PersonListComponent,
  },
  {
    path: '',
    redirectTo: '/persons',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }