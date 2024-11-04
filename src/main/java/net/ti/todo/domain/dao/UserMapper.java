package net.ti.todo.domain.dao;

import net.ti.todo.domain.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends UserRepository {
}
