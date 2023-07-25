import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateBookComponent } from './create-book/create-book.component';
import { BooklistComponent } from './booklist/booklist.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { CreateAuthorComponent } from './create-author/create-author.component';
import { AuthorListComponent } from './author-list/author-list.component';
import { BookDetailsComponent } from './book-details/book-details.component';


const routes: Routes = [
  {path:"create-book", component:CreateBookComponent},
  {path:"books",component:BooklistComponent},
  { path: '', redirectTo: '/books', pathMatch: 'full' },
  {path:"update-book/:id",component:UpdateBookComponent},
  {path:"create-author",component:CreateAuthorComponent},
  {path:"authors",component:AuthorListComponent},
  {path:"book-details/:id",component:BookDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
