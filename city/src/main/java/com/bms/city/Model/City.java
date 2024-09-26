package com.bms.city.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class City {
    private Long cityId;
    private String name;

    private List <Movie> movies = new ArrayList<>();

}
