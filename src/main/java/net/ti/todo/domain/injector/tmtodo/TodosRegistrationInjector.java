package net.ti.todo.domain.injector.tmtodo;

import lombok.AllArgsConstructor;
import net.ti.todo.domain.entity.Todo;
import net.ti.todo.service.domainservice.common.UuidGenerator;
import net.ti.todo.tmtodo.model.TodoRegistrationDto;

@AllArgsConstructor
public class TodosRegistrationInjector {
  private TodoRegistrationDto todoRegistrationDto;

  /**
   * 登録用DtoからEntityに変換する<></>
   *
   * @return エンティティ
   */
  public Todo inject() {
    Todo entity = new Todo();
    entity.setUuid(UuidGenerator.generate());
    entity.setTitle(todoRegistrationDto.getTitle());
    entity.setDescription(todoRegistrationDto.getDescription());
    return entity;
  }
}
