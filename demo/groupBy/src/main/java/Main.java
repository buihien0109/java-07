import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        List<BlogPost> posts = Arrays.asList(
                new BlogPost("Title 1", "Tô Hoài", BlogPostType.GUIDE, 1000),
                new BlogPost("Title 1", "Bùi Hiên", BlogPostType.GUIDE, 400),
                new BlogPost("Title 2", "Thu Hằng", BlogPostType.GUIDE, 1220),
                new BlogPost("Title 3", "Tô Hoài", BlogPostType.NEWS, 2420),
                new BlogPost("Title 4", "Bích Ngọc", BlogPostType.NEWS, 926),
                new BlogPost("Title 5", "Minh Duy", BlogPostType.NEWS, 1523),
                new BlogPost("Title 6", "Thu Hằng", BlogPostType.REVIEW, 2617),
                new BlogPost("Title 7", "Bùi Hiên", BlogPostType.REVIEW, 2517)
        );

        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType));

        postsPerType.forEach((k,v)-> v.forEach(p -> System.out.println(p.getTitle() + " - " + p.getType() )));
    }
}
