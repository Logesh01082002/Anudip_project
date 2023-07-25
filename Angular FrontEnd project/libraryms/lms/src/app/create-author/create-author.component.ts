import { Component, OnInit } from '@angular/core';
import { Author } from '../author';
import { Router } from '@angular/router';
import { Authorservice } from '../authorservice.service';

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.css']
})
export class CreateAuthorComponent implements OnInit {
  author: Author = new Author();

  constructor(private authorservice: Authorservice, private router: Router) {}

  ngOnInit(): void {}

  saveAuthor() {
    this.authorservice.createAuthor(this.author).subscribe(
      (data) => {
        console.log(data);
        this.goToAuthorList();
      },
      (error) => console.log(error)
    );
  }

  goToAuthorList() {
    this.router.navigate(['/authors']);
  }

  onSubmit() {
    console.log(this.author);
    this.saveAuthor();
  }
  
}
