import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookserviceService } from '../bookservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  book:Book=new Book();
  id!:number;

  constructor(private bookService:BookserviceService,
    private activatedRoute:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
      this.id=this.activatedRoute.snapshot.params['id'];
      this.bookService.getBookById(this.id).subscribe(data=>{
      this.book=data;
    },
    error=>console.log(error));
  }
  
  updateBook(){
      this.bookService.updateBookById(this.id,this.book).subscribe(data=>{
       this.goToBookList();
       }, error=>console.log(error)
    );
  }
    goToBookList()
    {
      this.router.navigate(['books']);
    }
}
