import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseRegistrationComponent } from './course-registration/course-registration.component';
import { RegisteredCoursesComponent } from './registered-courses/registered-courses.component';
import { DropCoursesComponent } from './drop-courses/drop-courses.component';

@NgModule({
  declarations: [
    AppComponent,
    CourseListComponent,
    CourseRegistrationComponent,
    RegisteredCoursesComponent,
    DropCoursesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
