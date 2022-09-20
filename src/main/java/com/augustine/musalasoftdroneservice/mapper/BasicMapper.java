package com.augustine.musalasoftdroneservice.mapper;

import java.util.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 20/Sep/2022 - 12:26 AM
 * @project MusalaSoftDroneService
 */
public interface BasicMapper<T, A> {
    A mapIn(T dto);

    List<A> mapListIn(List<T> dtoList);

    T mapOut(A dao);

    List<T> mapListOut(List<A> model);
}