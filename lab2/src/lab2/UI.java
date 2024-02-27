package lab2;

import java.util.*;
public class UI {
    <E> void displayList(DoubleLinkedList<E> list) {
    	System.out.println("\n");
    	if(!list.isEmpty()) {
    		for(int i = 0; i < list.size(); i++) {
    			if( i != list.size()-1) {
    				System.out.print("|----|-->");
    			}
    			else System.out.print("|----|");
    		}
    		System.out.print("\n");
    		for(int i = 0; i < list.size(); i++) {
            	System.out.print("| " + list.get(i) + " |   ");
            }
    		System.out.print("\n");
    		for(int i = 0; i < list.size(); i++) {
    			if( i != list.size()-1) {
    				System.out.print("|----|<--");
    			}
    			else System.out.print("|----|");
    		}
    		System.out.print("\n");
    	}
    	else System.out.println("List is empty");
    	System.out.println("\n");
    }

    public static void main(String[] args) {
        UI obj = new UI();
        DoubleLinkedList<Integer> newList = new DoubleLinkedList<Integer>();
        int choice = -1;
        int element, index;
        Scanner scanner = new Scanner(System.in);
        while(choice != 0) {
        	System.out.println("1.Add element to list\n2.Add element to list by index\n3.remove a element from list\n4.Get a element from list\n5.Clear the list\n6.Show list\n0.End\n");
        	choice = scanner.nextInt();
        	switch(choice) {
        	case 1:
        		System.out.println("Enter your element: ");
        		element = scanner.nextInt();
        		newList.add(element);
        		obj.displayList(newList);
        		break;
        	case 2:
        		System.out.print("Enter your element: ");
        		element = scanner.nextInt();
        		System.out.print("Enter element index: ");
        		index = scanner.nextInt();
        		newList.add(index, element);
        		obj.displayList(newList);
        		break;
        	case 3:
        		obj.displayList(newList);
        		System.out.print("Enter index of element you want to delete: ");
        		index = scanner.nextInt();
        		newList.remove(index);
        		obj.displayList(newList);
        		break;
        	case 4:
        		obj.displayList(newList);
        		System.out.print("Enter index of element you want to get: ");
        		index = scanner.nextInt();
        		System.out.print("The element you get is " + newList.get(index)+"\n");
        		break;
        	case 5:
        		obj.displayList(newList);
        		newList.clear();
        		obj.displayList(newList);
        		break;
        	case 6:
        		obj.displayList(newList);
        	case 0: 
        		break;
        	default:
        		break;
        	}
        		
        }
        scanner.close();
    }
    //2024.02.27
}
