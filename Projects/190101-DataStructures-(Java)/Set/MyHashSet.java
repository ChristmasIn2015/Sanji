package Set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import Interface.MySet;

public class MyHashSet<E> implements MySet<E>{
	
	//-------------------------------------------------------------------��ʼ����
	private static int DEFAULT_INITIAL_CAPACITY = 4;//�趨��ʼ������Ϊʲôһ��Ҫ��2�ı���
	private static int MAXIMUM_CAPACITY = 1 << 30;//�趨������������=2^30,Ϊʲô��
	private int capacity;//���ϵ�����
	private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;//��ֵ���һ��f��ʾ��float���͵�
	private float loadFactorThreshold;
	private int size = 0;
	
	private LinkedList<E>[] table;//һ����������������

	//-------------------------------------------------------------------���췽��
	public MyHashSet() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
	}
	
	public MyHashSet(int initialCapacity) {
		this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
	}

	public MyHashSet(int initialCapacity, float loadFactorThreshold) {
		if(initialCapacity > MAXIMUM_CAPACITY)
			this.capacity = MAXIMUM_CAPACITY;
		else
			this.capacity = trimToPowerOf2(initialCapacity);
		this.loadFactorThreshold = loadFactorThreshold;
		table = new LinkedList[capacity];
	}
	private int trimToPowerOf2(int initialCapacity) {//-----��������
		int capacity = 1;
		while(capacity < initialCapacity) {
			capacity <<= 1;//�ȼ���capacity *= 2������λ������Ӹ�Ч��
		}
		return capacity;
	}
	
	//-------------------------------------------------------------------����
	@Override
	public boolean add(E e) {
		if(contains(e))//���ظ�
			return false;
		if(size+1 > capacity*loadFactorThreshold) {
			if(capacity == MAXIMUM_CAPACITY)
				throw new RuntimeException("Exceeding maximum capacity");
			rehash();
		}
		
		int bucketIndex = hash(e.hashCode());
		
		if(table[bucketIndex] == null) {
			table[bucketIndex] = new LinkedList<E>();
		}
		
		table[bucketIndex].add(e);
		size++;
		return true;
	}
	private void rehash() {
		ArrayList<E> list = setToList();
		capacity <<= 1;
		table = new LinkedList[capacity];
		size=0;
		
		for(E element: list) {
			add(element);
		}
		
	}
	private ArrayList<E> setToList(){
		//��������Set���ֵȫ���ŵ�List��
		ArrayList<E> list = new ArrayList<>();
		for(int i=0; i<capacity; i++) {
			if(table[i] != null) {
				for(E e: table[i])
					list.add(e);
			}
		}
		return list;
	}
	//-------------------------------------------------------------------��ʼ����
	@Override
	public boolean remove(E e) {
		if(!contains(e))
			return false;
		int bucketIndex = hash(e.hashCode());
		
		if(table[bucketIndex] != null) {
			LinkedList<E> bucket = table[bucketIndex];
			for(E element: bucket) {
				if(e.equals(element)) {
					bucket.remove(element);
					break;
				}
			}
		}
		size--;
		return true;
	}

	@Override
	public void clear() {
		size = 0;
		removeElements();
	}
	private void removeElements() {//------------------------��������
		for(int i=0; i<capacity; i++) {
			if(table[i] != null)
				table[i].clear();
		}
	}
	//-------------------------------------------------------------------�޸�
	//-------------------------------------------------------------------��ѯ
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E e) {
		int bucketIndex = hash(e.hashCode());
		if(table[bucketIndex] != null) {
			LinkedList<E> bucket = table[bucketIndex];
			for(E element: bucket) {
				if(element.equals(e))
					return true;
			}
		}
		return false;
	}
	private int hash(int hashCode) {//--------------------------��������
		return supplementalHash(hashCode) & (capacity-1);
	}
	private static int supplementalHash(int h) { //��֤�ֲ����ȣ�����
		h ^= (h>>20)^(h >>> 12);
		return h ^ (h>>>7) ^ (h >>> 4);
	}
	//-------------------------------------------------------------------����
	@Override
	public Iterator<E> iterator() {
		return new MyHashSetIterator(this);//this=���÷�
	}
	private class MyHashSetIterator implements Iterator<E>{
		
		private ArrayList<E> list;
		private int current = 0;
		private MyHashSet<E> set;
		
		public MyHashSetIterator(MyHashSet<E> set) {
			this.set = set;
			list = setToList();
		}
		
		@Override
		public boolean hasNext() {
			if(current < list.size())
				return true;
			return false;
		}

		@Override
		public E next() {
			return list.get(current++);
		}
		
		public void remove() {
			set.remove(list.get(current));
			list.remove(current);
		}
		
	}
	
}