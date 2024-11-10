package net.ti.todo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ti.todo.domain.entity.Role;
import net.ti.todo.domain.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithRole {
    private User user;
    private Role role;
}
