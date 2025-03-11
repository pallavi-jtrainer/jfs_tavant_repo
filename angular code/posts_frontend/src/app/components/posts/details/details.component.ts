import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Posts } from 'src/app/models/posts';
import { PostsService } from 'src/app/services/postsservice.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {

  id: number = 0;
  title: string = '';
  userId:number = 0;

  post:Posts = {
    id: 0,
    title: '',
    body: '',
    userId: 0
  };

  newTitle: string = '';
  newBody: string = '';

  constructor(private route: ActivatedRoute,
    private router:Router,
    private postService: PostsService) { }

  ngOnInit() {
    this.userId = this.route.snapshot.params['user'];
    this.loadPage();
  }

  loadPage() {
    //console.log(this.router.url);
    let url = this.router.url;
    // let value = url.substring(9, 5);
    let value = url.split("/");
    //console.log(value);
    if(value.includes("title")){
      this.title = this.route.snapshot.params['title'];
      console.log(this.title);
      this.id = 0;
      this.getPostByTitle();
    } else {
      this.id = parseInt(this.route.snapshot.params['id']);
      console.log(this.id);
      this.title = '';
      this.getPostById();
    }
  }

  getPostByTitle() {
    this.postService.getPostDetailsByTitle(this.title)
      .subscribe({
        next: data => {
          console.log(data);
          this.post = data;
        },
        error: (e) => console.log(e)
      })
  }

  getPostById() {
    this.postService.getPostDetails(this.id)
      .subscribe({
        next: data => {
          console.log(data);
          this.post = data;
        },
        error: (e) => console.log(e)
      })
  }

  editPost() {
    if(this.post.title !== this.newTitle) {
      this.post.title = this.newTitle;
      this.newBody = this.post.body;
      console.log(this.post);

      this.postService.updatePostTitle(this.post.id ,this.post)
        .subscribe({
          next: data => {
            console.log(data)
          },
          error: (e) => console.log(e)
        });
    }

    if(this.post.body !== this.newBody) {
      this.post.body = this.newBody;
      this.newTitle = this.post.title;
      //console.log(this.post);

      this.postService.updatePostBody(this.post.id, this.post)
        .subscribe({
          next: data => console.log(data),
          error: (e) => console.log(e)
        });
    }

    this.router.navigate(['/posts/list', this.userId]);
  }

  navigateToHome() {
    this.router.navigate(['/posts/list', this.userId]);
  }
}
