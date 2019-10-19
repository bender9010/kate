package com.kate.repo;

import com.kate.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, Long> {
}
