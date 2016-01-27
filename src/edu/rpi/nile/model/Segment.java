/**
 * limteng
 * Date: Jan 26, 2016.
 */
package edu.rpi.nile.model;

import java.util.*;

public class Segment {
    /* Attributes and value in *.ltf file */
    private String text;           // original text
    private int start_char;
    private int end_char;
    private String id;
    private int short_id;          // segment level ID (e.g., the last '0' in full ID 'NW_BBC_BEN_000001_20050929-0-1')

    /* Token list */
    private List<Token> token_list;

    /* Attribute map. For storing additional attributes (key-value pair) */
    private Map<Object, Object> attribute_map;

    /* Constructor */
    public Segment() {
        attribute_map = new HashMap<>();
        token_list    = new ArrayList<>();
    }

    public Segment(String text) {
        this();
        this.text = text;
    }

    public Segment(String text, int start_char, int end_char, String id) {
        this();
        this.text       = text;
        this.start_char = start_char;
        this.end_char   = end_char;
        this.id         = id;
    }

    /* Mutators and accessors*/
    public void set_text(String text) {
        this.text = text;
    }

    public void set_start_char(int start_char) {
        this.start_char = start_char;
    }

    public void set_end_char(int end_char) {
        this.end_char = end_char;
    }

    public void set_id(String id) {
        this.id = id;
    }

    public void set_short_id(int short_id) {
        this.short_id = short_id;
    }

    public String get_text() {
        return text;
    }

    public int get_start_char() {
        return start_char;
    }

    public int get_end_char() {
        return end_char;
    }

    public String get_id() {
        return id;
    }

    public int get_short_id() {
        return short_id;
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

    /* Token list operations */
    public void add_token(Token token) {
        token_list.add(token);
    }

    public List<Token> get_token_list() {
        return token_list;
    }

    public int token_number() {
        return token_list.size();
    }


    @Override
    public String toString() {
        return text;
    }
}
