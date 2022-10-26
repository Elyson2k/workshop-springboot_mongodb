package com.devnc.workshop.config;

import com.devnc.workshop.dto.AuthorDTO;
import com.devnc.workshop.dto.CommentDTO;
import com.devnc.workshop.entities.Post;
import com.devnc.workshop.entities.User;
import com.devnc.workshop.repository.PostRepository;
import com.devnc.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu", "SP", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Partiu", "SP", new AuthorDTO(maria));

        CommentDTO commentDTO1 = new CommentDTO("Boa Viagem", sdf.parse("23/02/2003"), new AuthorDTO(alex));
        CommentDTO commentDTO2 = new CommentDTO("Aproveita", sdf.parse("12/05/2015"), new AuthorDTO(bob));
        CommentDTO commentDTO3 = new CommentDTO("Bom dia amigos!", sdf.parse("22/07/2009"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(commentDTO1,commentDTO3));
        post2.getComments().add(commentDTO2);

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);

    }
}
