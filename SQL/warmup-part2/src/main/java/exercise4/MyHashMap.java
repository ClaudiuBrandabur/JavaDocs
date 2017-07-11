package exercise4;

import java.util.*;

/**
 * Exercise 4. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    //int capacity;

    public MyHashMap() {

        // TODO Initialize buckets list
        //capacity = BUCKET_ARRAY_SIZE;
        buckets = new ArrayList<LinkedList<MyEntry>>();
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            buckets.add(new LinkedList<MyEntry>());
    }

    public String get(String key) {
        // TODO
        if (key == null) return null;
        int index = Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;

        LinkedList<MyEntry> specificBucket = buckets.get(index);
        for(int i=0; i< specificBucket.size(); i++)
            if ( specificBucket.get(i).getKey().equals(key) )
                return specificBucket.get(i).getValue();

        return null;
    }

    public void put(String key, String value) {
        // TODO
        if (key == null){
            buckets.get(0).add(new MyEntry(key,value));
            return;
        }

        int index = Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;
        LinkedList<MyEntry> specificBucket = buckets.get(index);

        for(int i=0; i< specificBucket.size(); i++)
            if (specificBucket.get(i).getKey().equals(key)) {
                specificBucket.get(i).setValue(value);
                return;
            }

        specificBucket.add(new MyEntry(key,value));
    }

    public Set<String> keySet() {
        // TODO
        Set<String> set = new HashSet<String>();
        LinkedList<MyEntry> specificBucket;

        for(int i=0; i < buckets.size(); i++){
            specificBucket = buckets.get(i);
            for(int j=0; j < specificBucket.size(); j++){
                set.add(specificBucket.get(j).getKey());
            }
        }

        return set;
    }

    public Collection<String> values() {
        // TODO
        Collection<String> col = new ArrayList<String>();
        LinkedList<MyEntry> specificBucket;

        for(int i=0; i < buckets.size(); i++){
            specificBucket = buckets.get(i);
            for(int j=0; j < specificBucket.size(); j++){
                col.add(specificBucket.get(j).getValue());
            }
        }

        return col;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        //if (key == null) return null;
        int index = Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;
        String value = null;
        int toRemoveIndex = -1;

        LinkedList<MyEntry> specificBucket = buckets.get(index);
        for(int i=0; i< specificBucket.size(); i++){
            if ( specificBucket.get(i).getKey().equals(key) ) {
                value = specificBucket.get(i).getValue();
                toRemoveIndex = i;
            }
        }

        if (toRemoveIndex >= 0) {
            specificBucket.remove(toRemoveIndex);
        }

        return value;
    }

    public boolean containsKey(String key) {
        // TODO
        LinkedList<MyEntry> specificBucket;

        for(int i=0; i < buckets.size(); i++){
            specificBucket = buckets.get(i);
            for(int j=0; j < specificBucket.size(); j++){
                if(specificBucket.get(j).getKey().equals(key)) return true;
            }
        }

        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        LinkedList<MyEntry> specificBucket;

        for(int i=0; i < buckets.size(); i++){
            specificBucket = buckets.get(i);
            for(int j=0; j < specificBucket.size(); j++){
                if(specificBucket.get(j).getValue().equals(value)) return true;
            }
        }

        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        int size = 0;

        LinkedList<MyEntry> specificBucket;

        for(int i=0; i < buckets.size(); i++){
            specificBucket = buckets.get(i);
            for(int j=0; j < specificBucket.size(); j++){
                size += 1;
            }
        }

        return size;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        LinkedList<MyEntry> specificBucket;

        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++){
            specificBucket = buckets.get(i);
            for(int j = 0; j < specificBucket.size(); j++) {
                if (specificBucket.get(j)!=null)
                    specificBucket.remove(j);
            }
        }

    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        Set<MyEntry> set = new HashSet<MyEntry>();
        LinkedList<MyEntry> specificBucket;

        for(int i=0; i < buckets.size(); i++){
            specificBucket = buckets.get(i);
            for(int j=0; j < specificBucket.size(); j++){
                set.add( new MyEntry( specificBucket.get(j).getKey(),specificBucket.get(j).getValue() ) );
            }
        }

        return set;
    }

    public boolean isEmpty() {
        // TODO
        if(size() == 0) return true;
        return false;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
