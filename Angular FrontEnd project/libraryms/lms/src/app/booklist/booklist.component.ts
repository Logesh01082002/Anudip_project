import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookserviceService } from '../bookservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {
  books!: Book[];
  isDelete=false;
  message!:string;

  constructor(private bookService:BookserviceService,
    private router:Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
     this.getBooks();
  }
  private getBooks()
  {
      this.bookService.getAllBookList().subscribe(data=>
      {
        this.books=data;
      })
  }

  bookDetails(id:number){
     this.router.navigate(['book-details',id]);
  }
 
  deleteBook(id:number)
  {
     if(confirm('Are youi sure to delete book information')){
        this.bookService.deleteBookById(id).subscribe(data=>{
        console.log(data);
        alert('book deleted successfully')

        this.getBooks();
        this.reloadPage();
      });
    }
  }

  reloadPage() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
    this.router.navigate([currentUrl]) 
  });
}
updateBook(id:number)
{
   this.router.navigate(['update-book',id]);
}

}