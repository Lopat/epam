package com.ddemyanov.javase10.t02.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book{

    long id;
    private String name;
    private Author author;
}
