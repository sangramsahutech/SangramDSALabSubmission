package com.gl.lab3dsa.longestpath;

import java.util.ArrayList;

public class LongestPathRootLeaf {
	
	static class Node{
		int data;
		Node left, right;
	}
	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);
		ArrayList<Integer> res = longestPathRoottoLeaf(root);
		int size = res.size();
		System.out.print("Longest path "+res.get(size-1));
		for(int i=size-2;i>=0;i--) {
			System.out.print("->"+res.get(i));
		}
	}
	private static ArrayList<Integer> longestPathRoottoLeaf(Node root) {
		// TODO Auto-generated method stub
		if(root==null) {
			ArrayList<Integer> ans = new ArrayList<>();
			return ans;
		}
		ArrayList<Integer> left = longestPathRoottoLeaf(root.left);
		ArrayList<Integer> right = longestPathRoottoLeaf(root.right);
		int rl = right.size();
		int ll = left.size();
		if(rl<ll)
			left.add(root.data);
		else
			right.add(root.data);
		return (left.size() > right.size()?left:right);
	}
}
