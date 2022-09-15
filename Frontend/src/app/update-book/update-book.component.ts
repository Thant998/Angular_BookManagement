import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book} from '../book';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  bookCode!: string;

book: Book= new Book();

message ='';
constructor(private bookService: BookService,

  private route: ActivatedRoute,
  
  private router: Router) { }
  
  ngOnInit(): void {
  
  this.bookCode = this.route.snapshot.params['bookCode'];
  
  this.bookService.getBookByBookCode(this.bookCode)
  
  .subscribe({
  
  next: (data) => {
  
  this.book = data;
  
  },
  
  error: (e) => console.log(e)
  
  });
}
onSubmit(){

  this.bookService.updateBook(this.bookCode, this.book)
  
  .subscribe({
  
  next: (data )=>{
  
  this.goToBookList();
  
  },
  
  error: (e) => console.log(e)
  
  });
  
  }
  
  goToBookList(){
  
  this.router.navigate(['/books']);
  
  }

}
