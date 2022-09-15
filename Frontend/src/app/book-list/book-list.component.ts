import { Component, OnInit } from '@angular/core';
import { Book} from '../book'
import { BookService } from '../book.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[];

check =false;
constructor(private bookService: BookService,

private router: Router) {

this.books=[];

}
ngOnInit(): void {

  this.getBooks();
  
  }
  
  private getBooks(){
  
  this.bookService.getBookList()
  
  .subscribe({
  
  next: (data) => {
  
  this.books = data;
  
  if(this.books.length!=0){
  
  this.check=true;
  
  }
  
  },
  
  error: (e) => console.log(e)
  
  });
  
  }
  
  bookDetails(bookCode: string){
  
  this.router.navigate(['book-details', bookCode]);
  
  }
  updateBook(bookCode: string){

    this.router.navigate(['update-book', bookCode]);
    
    }
    
    deleteBook(bookCode: string){
    
    this.bookService.deleteBook(bookCode)
    
    .subscribe({
    
    next: (data) => {
    
    console.log(data);
    
    this.getBooks();
    
    },
    
    error: (e) => console.log(e)
    
    });
    
    }

}
