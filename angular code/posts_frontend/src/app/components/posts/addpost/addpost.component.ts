import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Posts } from 'src/app/models/posts';
import { PostsService } from 'src/app/services/postsservice.service';

@Component({
  selector: 'app-addpost',
  templateUrl: './addpost.component.html',
  styleUrls: ['./addpost.component.css']
})
export class AddpostComponent {
  post: Posts = {
    id: 0,
    title: '',
    body: '',
    userId: 0
  };

  constructor(private postsService: PostsService, private router: Router){}

  createPost() {
    if(this.post.title == '' || this.post.body == '' || this.post.userId == 0) {
      alert("Fields cannot be empty");
    } else {
      this.postsService.createPost(this.post)
      .subscribe({
        next: data => {
          console.log(data);
          this.newPost();
        },
        error: (e) => console.log(e)
      });
    }
    this.router.navigate(['/posts/list']);
  }

  newPost(): void {
    this.post = {
      id: 0,
      title: '',
      body: '',
      userId: 0
    }
  }

  navigateToHome() {
    this.router.navigate(['/posts/list']);
  }
}
