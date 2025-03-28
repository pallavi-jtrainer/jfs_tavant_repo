import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Posts } from 'src/app/models/posts';
import { PostsService } from 'src/app/services/postsservice.service';

@Component({
  selector: 'app-viewposts',
  templateUrl: './viewposts.component.html',
  styleUrls: ['./viewposts.component.css']
})
export class ViewpostsComponent {

  posts: Posts[] = [];
  id: number = 0;
  searchTerm: string = '';

  constructor(private postsService: PostsService,
    private router: Router, private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = parseInt(this.route.snapshot.params['id']);

    if(this.id === 0) {
      this.getData();
    } else {
      this.getDataByUserId();
    }

  }

  getData() {
    this.postsService.getAllPost()
      .subscribe({
        next: data => {
          console.log(data);
          this.posts = data;
        },
        error: (e) => console.log(e)
      })
  }

  getDataByUserId() {
    this.postsService.getPostsForUser(this.id)
      .subscribe({
        next: data => {
          console.log(data);
          this.posts = data;
        },
        error: (e) => console.log(e)
      })
  }

  showAddPost(): void {
    this.router.navigate(['/posts/create/', this.id]);
  }

  navigateToDetailsPage(postId: number) {
    this.router.navigate(['/posts', postId, this.id]);
  }

  showDetails() {
    this.router.navigate(['/posts/title', this.searchTerm, this.id]);
  }
  // navigateToNewPostPage() {
  //   this.router.navigate(['/posts/create/', this.id]);
  // }
}
