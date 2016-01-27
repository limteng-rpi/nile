/**
 * limteng
 * Date: Jan 26, 2016.
 */
package edu.rpi.nile.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {
    /* Attributes and value in *.ltf file */
    private String id;
    private String language;

    /* Segment list */
    private List<Segment> segment_list;

    /* Attribute map. For storing additional attributes (key-value pair) */
    private Map<Object, Object> attribute_map;

    /* Constructors */
    public Document() {
        segment_list  = new ArrayList<>();
        attribute_map = new HashMap<>();
    }

    public Document(String id, String language) {
        this();
        this.id = id;
        this.language = language;
    }

    /* Mutators and accessors */
    public void set_id(String id) {
        this.id = id;
    }

    public void set_language(String language) {
        this.language = language;
    }

    public String get_id() {
        return id;
    }

    public String get_language() {
        return language;
    }

    /* Segment list operations */
    public void add_segment(Segment segment) {
        segment_list.add(segment);
    }

    public List<Segment> get_segment_list() {
        return segment_list;
    }

    public int segment_number() {
        return segment_list.size();
    }

    /* Attribute map operations */
    public boolean has_attribute(Object key) {
        return attribute_map.containsKey(key);
    }

    public Object get_attribute(Object key) {
        return attribute_map.get(key);
    }

    public void put_attribute(Object key, Object value) {
        attribute_map.put(key, value);
    }
}
