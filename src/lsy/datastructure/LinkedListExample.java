package lsy.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		
		//linkedList�� �� ��� ������ �ڽŰ� ����� ������ҿ� ���� ����(�ּҰ�)�� �����ͷ� �����Ǿ��ִ�.
		
		//������
		LinkedList list = new LinkedList();//Ÿ���� �������ϸ� objects
		LinkedList<Integer> num = new LinkedList<Integer>();//Ÿ�Լ��� intŸ�Ը� ��밡��
		LinkedList<Integer> num2 = new LinkedList<>();//new���� Ÿ�� �Ķ���� ��������
		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(1,2));//������ ���߰�
		
		//Arrays.asList�� Arrays.asList()�� Arrays�� private ���� Ŭ������ ArrayList�� �����Ѵ�.
		//java.util.ArrayList Ŭ�����ʹ� �ٸ� Ŭ�����̴�.
		//java.util.Arrays.ArrayList Ŭ������ set(), get(), contains() �޼��带 ������ ������
		//���Ҹ� �߰��ϴ� �޼���� ������ ���� �ʱ� ������ ����� �ٲ� �� ����.
		//Arrays.asList()�� �迭�� ������ �����Ϸ��� �� �� List�� �ٲ㼭 ���ϰ� ����ϱ� ����.
		
		
		//�� �߰�
		list.addFirst(1);//���� �տ� ������ �߰�
		list.addLast(2);//���� �ڿ� ������ �߰�
		list.add(3);//������ �߰�
		list.add(1, 10);//index 1�� ������ 10 �߰�
		
		//LinkedList�� ���� �߰��ϴ� ����� ���� ���� �ִµ� ���������� add(index, value) �޼ҵ带 ����մϴ�. 
		//index�� �����ϸ� ���� �������� �����Ͱ� �߰��˴ϴ�. 
		
		
		//����ó��
		LinkedList<Integer> list3 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		list3.removeFirst(); //���� ���� ������ ����
		list3.removeLast(); //���� ���� ������ ����
		list3.remove(); //������ 0��° index����
		list3.remove(1); //index 1 ����
		list3.clear(); //��� �� ����
		
		
		//ũ�� ���ϱ�
		LinkedList<Integer> list4 = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println("list4 : " + list4.size()); //list ũ�� : 3
		
		
		
		//�� ���ϱ�
		LinkedList<Integer> list5 = new LinkedList<Integer>(Arrays.asList(1,2,3));

		System.out.println("list5 : " + list5.get(0));//0��° index ���
						
		for(Integer i : list5) { //for���� ���� ��ü���
		    System.out.println("list5 : " + i);
		}

		Iterator<Integer> iter = list5.iterator(); //Iterator ����  > ����Ǿ� �ִ� ��ҵ��� �о���� ����� ǥ��ȭ �Ѱ�
		while(iter.hasNext()){//�������� �ִ��� üũ
		    System.out.println("list5 : " + iter.next()); //�� ���
		}
		
		
		
		//�� �˻�
		LinkedList<Integer> list6 = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println("list6 : " + list6.contains(1)); //list�� 1�� �ִ��� �˻� : true
		System.out.println("list6 : " + list6.indexOf(1)); //1�� �ִ� index��ȯ ������ -1
		
		//LinkedList���� ã���� �ϴ� ���� �˻��Ϸ��� LinkedList�� contains(value) �޼ҵ带 ����ϸ� �˴ϴ�. 
		//���� ���� �ִٸ� true�� ���ϵǰ� ���� ���ٸ� false�� ���ϵ˴ϴ�. 
		//���� �ִ� index�� ã������ indexOf(value) �޼ҵ带 ����ϸ� �ǰ� ���� ���� ���ٸ� -1�� �����մϴ�.
		
		
	}

}
