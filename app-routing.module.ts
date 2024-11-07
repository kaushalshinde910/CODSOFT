import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseRegistrationComponent } from './course-registration/course-registration.component';
import { RegisteredCoursesComponent } from './registered-courses/registered-courses.component';

const routes: Routes = [
  { path: '', redirectTo: '/course-list', pathMatch: 'full' },
  { path: 'course-list', component: CourseListComponent },
  { path: 'course-registration', component: CourseRegistrationComponent },
  { path: 'registered-courses', component: RegisteredCoursesComponent },
  // Add more routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
