package com.stardevllc.starorm.model;

public record PushInfo(String sql, boolean generateKeys, Table table) {
}
