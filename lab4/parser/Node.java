package parser;

import java.util.Map;

public abstract class Node {
    public Node parent;
    public Map<String, Object> props;

    public Object addProp(String name, Object prop){
        return props.put(name, prop);
    }
}
