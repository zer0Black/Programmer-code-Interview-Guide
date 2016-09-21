/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.LinkedList;

import com.sun.xml.internal.ws.encoding.TagInfoset;

/**
 * è������
 * ��Ŀ���������è��������;
 * 
 * ʵ��һ��è�����еĽṹ��Ҫ�����£�
 *     �û����Ե���add������cat���dog���ʵ�����������
 *     �û����Ե���pollAll����������������ʵ�����ս����е��Ⱥ�˳�򵯳�
 *     �û����Ե���pollDog��������������dog���ʵ�����ս����е��Ⱥ�˳�����ε���
 *     �û����Ե���pollCat��������������cat���ʵ�����ս����е��Ⱥ�˳�����ε���
 *     �û����Ե���isEmpty���������������Ƿ���dog��cat����
 *     �û����Ե���isDogEmpty/isCatEmpty���������������Ƿ���dog/cat���ʵ��
 * @author zer0
 *
 */
public class CatDogQueue {

	/************��Ŀ����***********/
	public class Pet{
		private String type;
		
		public Pet(String type) {
			this.type = type;
		}
		
		public String getPetType(){
			return this.type;
		}
	}
	
	public class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	
	public class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	/************��Ŀ����***********/
	
	public static class PetQueueEnter{
		public int count;
		Pet pet;
		
		public PetQueueEnter(Pet pet, int count) {
			this.pet = pet;
			this.count = count;
		}
		
		public Pet getPet(){
			return pet;
		}
	}
	
	LinkedList<PetQueueEnter> dogList = new LinkedList<>();
	LinkedList<PetQueueEnter> catList = new LinkedList<>();
	int count = 0;
	
	public void add(Pet pet){
		if (pet.getPetType().equals("dog")) {
			dogList.add(new PetQueueEnter(pet, count++));
		}else if (pet.getPetType().equals("cat")) {
			catList.add(new PetQueueEnter(pet, count++));
		//���Ͻ���Ӧ���������жϣ����ߵ����ߴ���Ĳ�������
		}else {
			throw new RuntimeException("���󣬷�è�ǹ�");
		}
	}
	
	public Pet pollAll(){
		if (!dogList.isEmpty() && !catList.isEmpty()) {
			if (dogList.peekFirst().count < catList.peekFirst().count) {
				System.out.println("��������"+dogList.peekFirst().count);
				return dogList.pollFirst().getPet();
			}else {
				System.out.println("è������"+catList.peekFirst().count);
				return catList.pollFirst().getPet();
			}
		}else if (!dogList.isEmpty()) {
			System.out.println("��������"+dogList.peekFirst().count);
			return dogList.pollFirst().getPet();
		}else if (!catList.isEmpty()) {
			System.out.println("è������"+catList.peekFirst().count);
			return catList.pollFirst().getPet();
		}else {
			throw new RuntimeException("���󣬶���Ϊ��");
		}
	}
	
	public Cat pollCat(){
		if (catList.isEmpty()) {
			throw new RuntimeException("è����Ϊ��");
		}
		return (Cat)catList.pollFirst().getPet();
	}
	
	public Dog pollDog(){
		if (dogList.isEmpty()) {
			throw new RuntimeException("������Ϊ��");
		}
		return (Dog)dogList.pollFirst().getPet();
	}
	
	public boolean isDogEmpty(){
		if (dogList.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isCatEmpty(){
		if (catList.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEmpty(){
		if (dogList.isEmpty() && catList.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Cat cat1 = new CatDogQueue().new Cat();
		Cat cat2 = new CatDogQueue().new Cat();
		Dog dog1 = new CatDogQueue().new Dog();
		Dog dog2 = new CatDogQueue().new Dog();
		Dog dog3 = new CatDogQueue().new Dog();
		
		CatDogQueue catDogQueue = new CatDogQueue();
		catDogQueue.add(dog3);
		catDogQueue.add(cat2);
		catDogQueue.add(cat1);
		catDogQueue.add(cat1);
		catDogQueue.add(dog1);
		catDogQueue.add(cat2);
		catDogQueue.add(dog2);
		catDogQueue.add(dog1);
		
		while(!catDogQueue.isEmpty()){
			catDogQueue.pollAll();
		}
	}
}
