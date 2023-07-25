import { Author } from "./author";

export class Book {
    id!:number;
    name!:string;
    genre!:string;
    description!:string;
    no_of_books!:number;
    page!:number;
    year!:number;
    price!:number;
    author!:Author;
    aid!:number;
}
/*
export interface BookInterface {
    id: number,
    name: string | undefined,
    genre: string | undefined,
    description: string | undefined,
    no_of_books: number | undefined,
    page: number | undefined,
    year: number | undefined,
    price: number | undefined,
    author: Author | undefined,
    aid: number | undefined
}
*/