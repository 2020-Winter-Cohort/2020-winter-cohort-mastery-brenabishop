package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class HashtagStorageJpaImpl implements  HashtagStorage{
    private HashtagRepository hashtagRepo;

    public HashtagStorageJpaImpl(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public Iterable<Hashtag> retrieveAllHashtags() {
        return hashtagRepo.findAll();
    }

    @Override
    public Hashtag retrieveHashtagById(long id) {
        Optional<Hashtag> retrievedHashtagOptional = hashtagRepo.findById(id);
        if(retrievedHashtagOptional.isPresent()) {
            Hashtag foundHashtag = retrievedHashtagOptional.get();
            return foundHashtag;
        }
        return null;
    }

    @Override
    public void save(Hashtag hashtagToAdd) {
        hashtagRepo.save(hashtagToAdd);
    }
}
