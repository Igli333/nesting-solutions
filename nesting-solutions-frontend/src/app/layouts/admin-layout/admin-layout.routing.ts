import { Routes } from "@angular/router";

import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { IconsComponent } from "../../pages/icons/icons.component";
import { NotificationsComponent } from "../../pages/notifications/notifications.component";
import { UserComponent } from "../../pages/user/user.component";
import { TablesComponent } from "../../pages/tables/tables.component";
import { TypographyComponent } from "../../pages/typography/typography.component";
import {StudentListComponent} from '../../pages/student-list/student-list.component';
import {LoginComponent} from '../../components/login/login.component';
import {DormStructureComponent} from '../../pages/dorm-structure/dorm-structure.component';
import {ContractsComponent} from '../../pages/contracts/contracts.component';
// import { RtlComponent } from "../../pages/rtl/rtl.component";

export const AdminLayoutRoutes: Routes = [
  { path: "dashboard", component: DashboardComponent },
  { path: "icons", component: IconsComponent },
  { path: "notifications", component: NotificationsComponent },
  { path: "user", component: UserComponent },
  { path: "tables", component: TablesComponent },
  { path: "typography", component: TypographyComponent },
  { path: "student-list", component: StudentListComponent },
  { path: "login", component: LoginComponent },
  {path:"structure", component: DormStructureComponent},
  {path:"contracts", component: ContractsComponent}
  // { path: "rtl", component: RtlComponent }
];
