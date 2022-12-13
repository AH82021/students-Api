package com.stdudentsystem.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
