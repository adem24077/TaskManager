package com.tobeto.case1.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum State {

    NEW("new"),
    INPROGRESS("in_progress"),
    COMPLETED("completed");

    private final String state;
}
