package net.ti.todo.domain.dao;

import net.ti.todo.domain.repository.TodosRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodosMapper extends TodosRepository {
}
