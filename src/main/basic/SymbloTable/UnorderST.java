package basic.SymbloTable;

public interface UnorderST <Key, Value>{
    int size();

    Value get(Key key);

    void put(Key key, Value value);

    void delete(Key key);
}
