import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from './course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private apiUrl = 'http://localhost:8080/api'; // Set up backend URL later

  constructor(private http: HttpClient) { }

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.apiUrl}/courses`);
  }

  registerForCourse(courseCode: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, { courseCode });
  }

  dropCourse(courseCode: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/drop`, { courseCode });
  }
}
