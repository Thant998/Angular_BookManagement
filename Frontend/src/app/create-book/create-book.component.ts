import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();

message='';

submitted=false;
constructor(private bookService: BookService,

  private router: Router) { }
  
  ngOnInit(): void {}
  
  saveBook(){
  
  this.bookService.createBook(this.book)
  
  .subscribe({
  
  next: (data) =>{
  
  console.log(data);
  
  this.goToBookList();
  
  //this.message = 'Book was inserted successfully!';
  
  },
  
  error: (e) => console.log(e)
  
  });
}goToBookList(){

  this.router.navigate(['/books']);
  
  }
  
  onSubmit(form: NgForm):void{
  
  if (form.valid) {
  
  this.submitted=false;
  
  console.log(form.value);
  
  this.saveBook();
  
  } else {
  
  this.submitted=true;
  
  console.log('invalid form');
  
  }
  
  }

}
