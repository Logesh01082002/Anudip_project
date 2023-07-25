import { Injectable } from '@angular/core';
import { Book } from './book';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class BookserviceService {
private addBook="http://localhost:8080/api/books";
private getAllBooks="http://localhost:8080/api/books/getAllBooks";
private getbookById="http://localhost:8080/api/books/get";
private updateBook="http://localhost:8080/api/books/update";
private deleteBook="http://localhost:8080/api/books/delete";

  constructor(private httpClient:HttpClient) { }

  createBook(book: Book, aid: number): Observable<Book> {
    return this.httpClient.post<Book>(`${this.addBook}/${aid}`, book);
  }

  getAllBookList():Observable<Book[]>
  {
    return this.httpClient.get<Book[]>(`${this.getAllBooks}`);
  }
  getBookById(id:number):Observable<Book>
  {
    return this.httpClient.get<any>(`${this.getBookById}/${id}`);
  }

  updateBookById(id:number,book:Book):Observable<Object>
  {
    return this.httpClient.put(`${this.updateBook}/${id}`,book);
  }
  deleteBookById(id:number):Observable<Object>
  {
    return this.httpClient.delete(`${this.deleteBook}/${id}`);
  }
  
}
