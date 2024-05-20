package com.experimental.stringtemplate.view;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseModel {
    
	// if test that handles nulls to keep models clean
    @SuppressWarnings("unchecked")
    public default <E, F> String IF(Object test, E iftrue, F iffalse) {
        if (null == test) { // if null return false string
            return iffalse.toString();
        } else if (test instanceof Boolean) { // if boolean return either value based on boolean
            return ((Boolean)test) ? iftrue.toString() : iffalse.toString();
        } else if (test instanceof List) { // if LIST return value based on whether list is empty
            if (((List<Object>)test).size() > 0) {
                return iftrue instanceof List ? LIST((List<Object>)iftrue) : iftrue.toString();
            } else {
                return iffalse instanceof List ? LIST((List<Object>)iffalse) : iffalse.toString();
            }
        } else if (test instanceof String && "true".equals(((String)test).trim()) ) { 
            return iftrue.toString();
        } else { //return false string
            return iffalse.toString();
        }
    }

	// avoid having null tests littered throughout models
    public default String IF(Object test) {
        if (null == test) { 
            return "";
        } else {
            return test.toString();
        }
    }

    public default boolean IFNULL(Object test) {
        return null == test;
    }

    @SuppressWarnings("preview")
	public default <E> String LIST(List<E> list) {
        return list != null && list.size() > 0 ? list.stream()
        .map((element) -> STR."""
		\{element}
		""".indent(6))
        .collect(Collectors.joining("\n")) : "";
    }

}
