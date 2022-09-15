import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { BookDetailsComponent } from './book-details/book-details.component';

const routes: Routes = [

  {path: 'books', component: BookListComponent},
  
  {path: 'create-book', component: CreateBookComponent},
  
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  
  {path: 'update-book/:bookCode', component: UpdateBookComponent},
  
  {path: 'book-details/:bookCode', component: BookDetailsComponent}
  
  ];
  @NgModule({

    imports:
    [RouterModule.forRoot(routes)],
    
    exports: [RouterModule]
    
    })
    
    export class AppRoutingModule { }
