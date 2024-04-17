package org.scaler.blogapi.articles;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping("")
    ResponseEntity<String> getAllArticles(){

        return  ResponseEntity.ok("All articles");
    }

    @GetMapping("/{id}")
    ResponseEntity<Void> getArticleById(){

        return null;
    }

    @PostMapping("")
    ResponseEntity<String> createArticle(
            @AuthenticationPrincipal String username
    ) {

        return ResponseEntity.accepted().body("Article created "+ username + " Successfully");
    }

    @PatchMapping("/{id}")
    ResponseEntity<Void> updateArticle(){

        return null;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteArticle(){

        return null;
    }

    @PutMapping("/{id}/like")
    ResponseEntity<Void> likeArticle(){

        return null;
    }

    @PostMapping("/{id}")
    ResponseEntity<Void> unlikeArticle(){

        return null;
    }

}
