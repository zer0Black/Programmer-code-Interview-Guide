/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.LinkedList;

import com.sun.xml.internal.ws.encoding.TagInfoset;

/**
 * 猫狗队列
 * 题目：宠物、狗和猫的类如下;
 * 
 * 实现一种猫狗队列的结构，要求如下：
 *     用户可以调用add方法将cat类或dog类的实例放入队列中
 *     用户可以调用pollAll方法，将队列所有实例按照进队列的先后顺序弹出
 *     用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
 *     用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
 *     用户可以调用isEmpty方法，检查队列中是否还有dog或cat队列
 *     用户可以调用isDogEmpty/isCatEmpty方法，检查队列中是否有dog/cat类的实例
 * @author zer0
 *
 */
public class CatDogQueue {

	/************题目所给***********/
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
	/************题目所给***********/
	
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
		//不严谨，应加上如下判断，告诉调用者传入的参数错误
		}else {
			throw new RuntimeException("错误，非猫非狗");
		}
	}
	
	public Pet pollAll(){
		if (!dogList.isEmpty() && !catList.isEmpty()) {
			if (dogList.peekFirst().count < catList.peekFirst().count) {
				System.out.println("狗计数："+dogList.peekFirst().count);
				return dogList.pollFirst().getPet();
			}else {
				System.out.println("猫计数："+catList.peekFirst().count);
				return catList.pollFirst().getPet();
			}
		}else if (!dogList.isEmpty()) {
			System.out.println("狗计数："+dogList.peekFirst().count);
			return dogList.pollFirst().getPet();
		}else if (!catList.isEmpty()) {
			System.out.println("猫计数："+catList.peekFirst().count);
			return catList.pollFirst().getPet();
		}else {
			throw new RuntimeException("错误，队列为空");
		}
	}
	
	public Cat pollCat(){
		if (catList.isEmpty()) {
			throw new RuntimeException("猫队列为空");
		}
		return (Cat)catList.pollFirst().getPet();
	}
	
	public Dog pollDog(){
		if (dogList.isEmpty()) {
			throw new RuntimeException("狗队列为空");
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
