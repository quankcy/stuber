package com.quankcy.stuber;

public enum BytecodeConsts {
    STRING("Ljava/lang/String;");

    public final String bytecodeDefinition;

    BytecodeConsts(String bytecodeDefinition) {
        this.bytecodeDefinition = bytecodeDefinition;
    }
}
