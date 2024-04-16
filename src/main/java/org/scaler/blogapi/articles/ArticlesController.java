package org.scaler.blogapi.articles;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping("")
    ResponseEntity<Void> getAllArticles(){

        return  null;
    }

    @GetMapping("/{id}")
    ResponseEntity<Void> getArticleById(){

        return null;
    }

    @PostMapping("/{id}")
    ResponseEntity<Void> createArticle() {

        return null;
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

    @PostMapping("")
    ResponseEntity<Void> unlikeArticle(){

        return null;
    }

}
