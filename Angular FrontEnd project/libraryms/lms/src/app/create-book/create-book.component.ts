import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { Author } from '../author';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {
  book: Book = new Book();
  author: Author = new Author();

  constructor(private bookService: BookserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  saveBook() {
    this.book.aid = this.author.aid; 

    this.bookService.createBook(this.book, this.author.aid).subscribe(
      data => {
          console.log(data);
          this.goToBookList();
      },
      error => {
        console.log(error);
      }
    );
  }

  goToBookList() {
    this.router.navigate(['/books']);
  }

  onSubmit() {
    this.saveBook();
  }
}
