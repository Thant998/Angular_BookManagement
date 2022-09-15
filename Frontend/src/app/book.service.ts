import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({
providedIn: 'root'
})

export class BookService {
private baseURL = "http://localhost:8080/api/v1/books";
constructor(private httpClient: HttpClient) { }
  getBookList(): Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}`);
    }
    
    createBook(book: Book): Observable<Object>{
      return this.httpClient.post(`${this.baseURL}`, book);
    }
    
    getBookByBookCode(bookCode: string): Observable<Book>{
     return this.httpClient.get<Book>(`${this.baseURL}/${bookCode}`);
    }
    
    updateBook(bookCode: string, book: Book): Observable<Object>{
      return this.httpClient.put(`${this.baseURL}/${bookCode}`, book);
    }
    
    deleteBook(bookCode: string): Observable<Object>{
      return this.httpClient.delete(`${this.baseURL}/${bookCode}`);
    }
}
