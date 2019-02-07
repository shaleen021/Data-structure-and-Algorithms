package practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

class NodeLRU {
	int data;
	NodeLRU next;
	NodeLRU previous;

	public NodeLRU(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

public class LRUCache {

	private final static int CACHE_SIZE = 5;
	private Map<Integer, NodeLRU> map = new HashMap<Integer, NodeLRU>(CACHE_SIZE);
	NodeLRU head = null;
	NodeLRU tail = null;
	
	public void set(int key, int value){
		if(map.containsKey(key)){
			removeExistingNode(key,value);
			set(key, value);
		} else {
			addNode(key, value);
		}
	}
	
	public void removeExistingNode(int key,int value) {
		NodeLRU tmp = map.get(key);
		  if (tmp.next != null && tmp.previous != null) {
		   tmp.previous.next = tmp.next;
		   tmp.next.previous = tmp.previous;
		  } else if (tmp.equals(tail)) {
			  removeLeastUsedNode();
		  } else if (tmp.equals(head)) {
		   removeHeadNode();
		  }
	}
	
	public void removeHeadNode(){
		NodeLRU tmp = head;
		head = head.next;
		removeFromMap(tmp);
	}
	
	public void removeLeastUsedNode(){
		NodeLRU leastused = tail;
		tail.previous= null;
		removeFromMap(leastused);
	}
	
	public void removeFromMap(NodeLRU node) {
		for(Map.Entry<Integer, NodeLRU> entry : map.entrySet()){
			if(entry.getValue() == node){
				map.remove(entry.getKey());
			    return;
			}
		}
	}
	
	public void addNode(int key, int value) {
		if (map.size() < CACHE_SIZE) {
			NodeLRU t = new NodeLRU(value);
			if(head == null && tail == null){
				head = tail = t;
			} else {
				head.previous = t;
				t.next = head;
				head = t;
			}
			map.put(key, t);
		} else {
			removeLeastUsedNode();
			addNode(key,value);
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		cache.set(1, 11);
		cache.set(2, 12);
		cache.set(3, 13);
		cache.set(4, 14);
		cache.set(5, 15);
	}

}
