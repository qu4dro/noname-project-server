package ru.orlovvv.wilt.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orlovvv.wilt.entity.Post;
import ru.orlovvv.wilt.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserOrderByCreatedDateDesc(User user);

    List<Post> findAllOrderByCreatedDateDesc();

    Optional<Post> finnPostByIdAndUser(Long postId, User user);

}
