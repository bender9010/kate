package com.kate.repo;

import com.kate.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Long> {
}
