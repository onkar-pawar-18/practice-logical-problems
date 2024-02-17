public class HashMapImplementation<K, V> {

    private MapNode<K, V>[] mapNodeArray;

    public HashMapImplementation() {}

    public HashMapImplementation(int size) {
        this.mapNodeArray = new MapNode[size];
    }

    public void put(K key, V value) {
        MapNode<K, V> newMapNode = getMapNode(key, value);
        int index = getIndex(key);

        MapNode<K, V> mapNode = this.mapNodeArray[index];

        if (mapNode == null) {
            this.mapNodeArray[index] = newMapNode;
        } else {
            while (mapNode.getNext() != null) {
                if ((mapNode.getKey().hashCode() == newMapNode.getKey().hashCode()) && mapNode.getKey().equals(newMapNode.getKey())) {
                    mapNode.setValue(newMapNode.getValue());
                    return;
                }
                mapNode = mapNode.getNext();
            }

            if ((mapNode.getKey().hashCode() == newMapNode.getKey().hashCode()) && mapNode.getKey().equals(newMapNode.getKey())) {
                mapNode.setValue(newMapNode.getValue());
            } else {
                mapNode.setNext(newMapNode);
            }
        }
    }

    public V get(K key){
        int index = getIndex(key);
        MapNode<K, V> mapNode = mapNodeArray[index];

        while (mapNode != null) {
            if ((mapNode.getKey().hashCode() == key.hashCode()) && mapNode.getKey().equals(key)) {
                return mapNode.getValue();
            }
            mapNode = mapNode.getNext();
        }
        return null;
    }

    private MapNode<K, V> getMapNode(K key, V value) {
        return new MapNode<>(key.hashCode(), key, value, null);
    }

    private int getIndex(K key) {
        return key.hashCode() & (this.mapNodeArray.length-1);
    }
}

class MapNode<K, V> {
    private int hashCode;
    private K key;
    private V value;
    private MapNode<K, V> next;

    public MapNode() {}

    public MapNode(int hashCode, K key, V value, MapNode<K, V> next) {
        this.hashCode = hashCode;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getHashCode() {
        return hashCode;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public MapNode<K, V> getNext() {
        return next;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(MapNode<K, V> next) {
        this.next = next;
    }
}