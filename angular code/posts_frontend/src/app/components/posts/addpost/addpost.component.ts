import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Posts } from 'src/app/models/posts';
import { PostsService } from 'src/app/services/postsservice.service';

@Component({
  selector: 'app-addpost',
  templateUrl: './addpost.component.html',
  styleUrls: ['./addpost.component.css']
})
export class AddpostComponent {
  id: number = 0;

  post: Posts = {
    id: 0,
    title: '',
    body: '',
    userId: 0
  };

  route: ActivatedRoute = inject(ActivatedRoute);

  constructor(private postsService: PostsService, private router: Router){}

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
  }
  createPost() {
    if(this.post.title == '' || this.post.body == '') {
      alert("Fields cannot be empty");
    } else {
      this.post.userId = this.id;
      this.postsService.createPost(this.post);
      // this.postsService.createPost(this.post)
      // .subscribe({
      //   next: data => {
      //     console.log(data);
      //     this.newPost();
      //   },
      //   error: (e) => console.log(e)
      // });
    }
    this.router.navigate(['/posts/list', this.id]);
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
    this.router.navigate(['/posts/list', this.id]);
  }
}
