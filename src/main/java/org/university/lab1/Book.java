package org.university.lab1;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;
}
