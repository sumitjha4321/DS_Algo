package functional_programming_devoxx;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Data
@AllArgsConstructor
class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;
}

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}
@Data
@AllArgsConstructor
class Tuple {
    BlogPostType type;
    String author;
}

class GroupingByDemo {


    public static void main(String[] args) {

        List <BlogPost> blogPosts = new ArrayList<>();
        blogPosts.add(new BlogPost("sumit-1", "sumit", BlogPostType.NEWS, 1));
        blogPosts.add(new BlogPost("bakri-1", "kedia", BlogPostType.REVIEW, 10));
        blogPosts.add(new BlogPost("bakri-2", "kedia", BlogPostType.REVIEW, 8));
        blogPosts.add(new BlogPost("sumit-2", "sumit", BlogPostType.REVIEW, 2));
        blogPosts.add(new BlogPost("amit-1", "amit", BlogPostType.GUIDE, 7));

        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = blogPosts.stream()
                .collect(groupingBy(blogPost -> new Tuple(blogPost.getType(), blogPost.getAuthor())));

        //Map<BlogPostType, BlogPost> blogPostTypeBlogPostMap = blogPosts.stream().collect(groupingBy(blogpost -> blogpost.getClass()));

        System.out.println(blogPosts.stream()
                .collect(groupingBy(BlogPost::getAuthor)));


        //System.out.println(postsPerTypeAndAuthor);

    }


}
