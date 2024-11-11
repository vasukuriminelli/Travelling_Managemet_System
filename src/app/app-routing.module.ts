import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BodyComponent } from './components/body/body.component';
import { PagenotfComponent } from './components/pagenotf/pagenotf.component';
import { RegisterComponent } from './components/register/register.component';
import { ReviewsComponent } from './components/reviews/reviews.component';
import { BookingComponent } from './components/booking/booking.component';
import { MybookingsComponent } from './components/mybookings/mybookings.component';
import { Aboutus1Component } from './components/aboutus1/aboutus1.component';
import { PackagesComponent } from './components/packages/packages.component';
import { SignupComponent } from './components/signup/signup.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarcComponent } from './components/navbarc/navbarc.component';


const routes: Routes = [

  {
    path:'',//localhost:4200
    redirectTo:'/home',
    pathMatch:'full'
  },
  {
    path:'home',
    component:BodyComponent 
  },
  // {
  //   path:'register',
  //   component:RegisterComponent
  // },

  {
    path:'aboutus',
    component:Aboutus1Component
  },
  {
    path:'bookTravel',
    component:BookingComponent
  },
  {
    path:'mybookings',
    component:MybookingsComponent
  },
  {
    path:'signup',
    component:SignupComponent
  },
  {
    path:'reviews',
    component:ReviewsComponent
  },

  {
    path:'packages',
    component:PackagesComponent
  },

  {
    path:'navbar',
    component:NavbarcComponent
  },

  {
     path:'footer',
     component:FooterComponent
  },
  {
    path:'**',
    component:PagenotfComponent 
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  center:any;
 }
