package com.flz.dt.common.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    private String id;
    private String name;

    public static User systemUser() {
        return new User("System", "System");
    }
}
