import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  bookCode!:string

book!: Book

constructor(private route: ActivatedRoute, private bookService: BookService) { }
ngOnInit(): void {

  this.bookCode = this.route.snapshot.params['bookCode'];
  
  this.book = new Book();
  
  this.bookService.getBookByBookCode(this.bookCode)
  
  .subscribe({
  
  next: (data)=> {
  
  this.book = data;
  
  },
  
  error: (e) => console.log(e)
  
  });
  
  }

}
