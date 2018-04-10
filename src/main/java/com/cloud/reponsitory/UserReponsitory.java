package com.cloud.reponsitory;

import com.cloud.bean.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Oliverlee on 2018/3/24.
 */
public interface UserReponsitory extends CrudRepository<User, Integer> {
}
