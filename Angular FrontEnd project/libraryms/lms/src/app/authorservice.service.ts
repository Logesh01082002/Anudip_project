import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Author } from './author';

@Injectable({
  providedIn: 'root'
})
export class Authorservice {

  private baseurl ="http://localhost:8080/api/Authors";

  constructor(private httpClient:HttpClient) { }

  createAuthor(author:Author):Observable<object> {
    return this.httpClient.post(`${this.baseurl}`,author);
  }

  getAllAuthorList():Observable<Author[] > {
    
    return this.httpClient.get<Author[]>(`${this.baseurl}`);
  }
  
  getAuthorById(aid:number):Observable<Author>
  {
    return this.httpClient.get<Author>(`${this.baseurl}/${aid}`);
  }  
  
  updateDepartmentById(aid:number,author:Author):Observable<object>
  {
      return this.httpClient.put(`${this.baseurl}/${aid}`,author);
  }

}
