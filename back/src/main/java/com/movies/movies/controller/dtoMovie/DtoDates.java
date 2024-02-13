package com.movies.movies.controller.dtoMovie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class DtoDates {

    @NonNull
    private Date start;
    @NonNull
    private Date end;
}
