import { Component, OnInit } from '@angular/core';
import { Authorservice } from '../authorservice.service';
import { Author } from '../author';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {

   authors:Author[] | undefined;
   isDelete=false;
   message!:String;
  
  constructor(private authorservice: Authorservice,private router:Router,
    private route:ActivatedRoute) { }
    
      aid! : number
      author! :Author
      ngOnInit(): void {
      this.getAllauthor();
    }
    private getAllauthor()
    {
      this.authorservice.getAllAuthorList().subscribe(data=>
        {
           this.authors=data;
        })
    }
    reloadPage() {
      let currenturl=this.router.url;
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>
      this.router.navigate([currenturl])
      )};
    
      authorDetail(aid:number)
      {
        this.router.navigate(['author-details',aid]);
      }
     
}
