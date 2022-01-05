package com.quankcy.stuber;

import lombok.Builder;
import org.junit.Test;
import spock.lang.Specification;

@Seeder(name = "SeederClassTest name")
@Builder
public class SeederClassTest{

    String someField;

//    @Test
//    public void SingleNoDependencyTest(){
////        Seeder.parseClass();
//    }

}
