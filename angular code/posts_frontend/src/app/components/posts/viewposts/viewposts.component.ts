import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Posts } from 'src/app/models/posts';
import { PostsService } from 'src/app/services/postsservice.service';

@Component({
  selector: 'app-viewposts',
  templateUrl: './viewposts.component.html',
  styleUrls: ['./viewposts.component.css']
})
export class ViewpostsComponent {

  posts: Posts[] = [];

  constructor(private postsService: PostsService,
    private router: Router
  ) {}

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.postsService.getAllPost()
      .subscribe(data => {
        console.log(data);
        this.posts = data;
      }, error => console.log(error));
  }

  showAddPost(): void {
    this.router.navigate(['/posts/create']);
  }
}
