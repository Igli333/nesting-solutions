import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import {LoginComponent} from './components/login/login.component';
import {AuthGuard} from './guard/auth.guard';
import {DashboardComponent} from './pages/dashboard/dashboard.component';

// const routes: Routes = [
//   {
//     path:"",
//     redirectTo: "login",
//   },
//   {
//     path: "dashboard",
//     redirectTo: "dashboard",
//   },
//   {
//     path: "",
//     component: AdminLayoutComponent,
//     children: [
//       {
//         path: "",
//         loadChildren: () => import ("./layouts/admin-layout/admin-layout.module").then(m => m.AdminLayoutModule)
//       }
//     ]
//   }, {
//     path: "",
//     component: AuthLayoutComponent,
//     children: [
//       {
//         path: "",
//         loadChildren: () => import ("./layouts/auth-layout/auth-layout.module").then(m => m.AuthLayoutModule)
//       }
//     ]
//   },
//   {
//     path: "**",
//     redirectTo: "login"
//   },
// ];

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent, // Replace with your actual LoginComponent
  },
  {
    path: 'dashboard',
   canActivate: [AuthGuard], // Protect the "dashboard" route
    redirectTo: 'dashboard', // Replace with your actual DashboardComponent
  },
  // {
  //   path: '',
  //   pathMatch: 'full',
  //   redirectTo: 'login', // Redirect empty path to "login"
  // },
    {
    path: "",
      canActivate: [AuthGuard],
    component: AdminLayoutComponent,
    children: [
      {
        path: "",
        loadChildren: () => import ("./layouts/admin-layout/admin-layout.module").then(m => m.AdminLayoutModule)
      }
    ]
  }, {
    path: "",
    canActivate: [AuthGuard],
    component: AuthLayoutComponent,
    children: [
      {
        path: "",
        loadChildren: () => import ("./layouts/auth-layout/auth-layout.module").then(m => m.AuthLayoutModule)
      }
    ]
  },
  {
    path: '**',
    redirectTo: 'login', // Redirect any other unmatched routes to "login"
  },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
