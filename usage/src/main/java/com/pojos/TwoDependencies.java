package com.pojos;

import lombok.Builder;

import java.util.List;

@Builder
public class TwoDependencies {

    NoDependency noDependency;
    List<NoFields> noFieldsList;
}
