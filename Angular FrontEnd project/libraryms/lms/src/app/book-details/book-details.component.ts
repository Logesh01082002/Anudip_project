import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { BookserviceService } from '../bookservice.service';
import { Author } from '../author';
import { Authorservice } from '../authorservice.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
    id!: number;
    book!: Book;
    aid!: number;
    author!: Author;

  constructor(
    private bookService: BookserviceService,
    private authorService: Authorservice,
    private route: ActivatedRoute,
    private router: Router  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.bookService.getBookById(this.id).subscribe(bookData => {
      this.book = bookData;

      this.aid = this.book.author.aid;

      this.authorService.getAuthorById(this.book.author.aid).subscribe(authorData => {
        this.author = authorData;
     
      });
    });
  }

  goToBookList() {
    this.router.navigate(['/books']);
  }
}
