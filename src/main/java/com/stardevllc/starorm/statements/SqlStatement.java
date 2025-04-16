package com.stardevllc.starorm.statements;

@FunctionalInterface
public interface SqlStatement {
    String build();
}