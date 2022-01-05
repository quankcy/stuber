package com.pojos;

/*
    POJO class
 */
public class NoDependency {

//    @Seed(RegexGenerator)
    private String privateFieldWithAnnotation;

//    @Seed()
    protected Integer protectedFieldWithAnnotation;

//    @Seed()
    public boolean publicFieldWithAnnotation;

    private String privateField;

    protected Integer protectedField;

    public boolean publicField;

}
