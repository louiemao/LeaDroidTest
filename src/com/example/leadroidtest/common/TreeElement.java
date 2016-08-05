package com.example.leadroidtest.common;

import java.util.ArrayList;
import java.util.Stack;

public class TreeElement<T> {

	private T mObject;
	private TreeElement<T> parent;
	private ArrayList<TreeElement<T>> childList;
	private boolean expanded = false;
	private boolean selected = false;

	public TreeElement() {
		super();
	}

	public TreeElement(T mObject) {
		super();
		setObject(mObject);
	}

	public TreeElement(T object, TreeElement<T> parent,
			ArrayList<TreeElement<T>> childList) {
		super();
		setObject(object);
		setParent(parent);
		setChildList(childList);
	}

	public TreeElement(T object, T parent, ArrayList<T> childList) {
		super();
		setObject(object);
		setParent(parent);
		setChildListDirect(childList);
	}

	public T getObject() {
		return mObject;
	}

	public void setObject(T object) {
		this.mObject = object;
	}

	public TreeElement<T> getParent() {
		return parent;
	}

	public void setParent(TreeElement<T> parent) {
		this.parent = parent;
		if (this.parent != null) {
			this.parent.addChild(this);
		}
	}

	public void setParent(T parent) {
		setParent(new TreeElement<T>(parent));
	}

	public ArrayList<TreeElement<T>> getChildList() {
		return childList;
	}

	public void setChildList(ArrayList<TreeElement<T>> childList) {
		this.childList = childList;
		if (childList != null && childList.size() > 0) {
			for (TreeElement<T> e : childList) {
				e.parent = this;
			}
		}
	}

	public void setChildListDirect(ArrayList<T> childList) {
		if (childList == null || childList.size() == 0) {
			this.childList = null;
		} else {
			this.childList = new ArrayList<TreeElement<T>>();
			for (T e : childList) {
				this.addChild(e);
			}
		}
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void addChild(TreeElement<T> c) {
		if (this.childList == null) {
			childList = new ArrayList<TreeElement<T>>();
		}
		this.childList.add(c);
		c.parent = this;
	}

	public void addChild(T c) {
		addChild(new TreeElement<T>(c));
	}

	public boolean isHasParent() {
		return parent != null;
	}

	public boolean isHasChild() {
		return childList != null && childList.size() > 0;
	}

	/**
	 * 获取层级，根节点层级为0
	 * 
	 * @return
	 */
	public int getLevel() {
		int level = 0;
		TreeElement<T> element = this;
		while (element.isHasParent()) {
			level++;
			element = element.parent;
		}
		return level;
	}

	/**
	 * 找到根节点
	 * 
	 * @return
	 */
	public TreeElement<T> getRootElement() {
		TreeElement<T> element = this;
		while (element.isHasParent()) {
			element = element.parent;
		}
		return element;
	}

	/**
	 * 获取展开节点个数，包括自己和所有孩子节点
	 * 
	 * @return
	 */
	public int getExpandedCount() {
		int count = 1;
		if (this.isExpanded() && this.isHasChild()) {
			for (TreeElement<T> e : this.childList) {
				count += e.getExpandedCount();
			}
		}
		return count;
	}

	/**
	 * 获取整个树展开的节点个数
	 * 
	 * @return
	 */
	public int getTreeExpandedSize() {
		int count = 1;
		TreeElement<T> root = getRootElement();
		if (root != null && root.isHasChild()) {
			for (TreeElement<T> e : root.getChildList()) {
				count += e.getExpandedCount();
			}
		}
		return count;
	}

	/**
	 * 得到指定位置的元素，根据深度优先遍历，根节点位置为0
	 * 
	 * @param position
	 * @return
	 */
	public TreeElement<T> getElement(int position) {
		int index = 0;
		Stack<TreeElement<T>> stack = new Stack<TreeElement<T>>();
		stack.push(getRootElement());
		while (stack.isEmpty() == false) {
			if (index == position) {
				return stack.pop();
			}
			index++;
			TreeElement<T> node = stack.pop();
			if (node.isHasChild()) {
				for (int i = node.getChildList().size() - 1; i >= 0; i--)
					stack.push(node.getChildList().get(i));
			}
		}
		return null;
	}

	/**
	 * 得到展开的指定位置的元素，根据深度优先遍历，根节点位置为0
	 * 
	 * @param position
	 * @return
	 */
	public TreeElement<T> getExpandedElement(int position) {
		int index = 0;
		Stack<TreeElement<T>> stack = new Stack<TreeElement<T>>();
		stack.push(getRootElement());
		while (stack.isEmpty() == false) {
			if (index == position) {
				return stack.pop();
			}
			index++;
			TreeElement<T> node = stack.pop();
			if (node.isExpanded() && node.isHasChild()) {
				for (int i = node.getChildList().size() - 1; i >= 0; i--)
					stack.push(node.getChildList().get(i));
			}
		}
		return null;
	}

	/**
	 * 深度优先遍历
	 */
	public void depthOrderTraversal(Traversal<T> traversal) {
		Stack<TreeElement<T>> stack = new Stack<TreeElement<T>>();
		stack.push(this);
		while (stack.isEmpty() == false) {
			TreeElement<T> node = stack.pop();
			if (traversal.isBreak(node)) {
				break;
			}
			if (node.isHasChild()) {
				for (int i = node.getChildList().size() - 1; i >= 0; i--)
					stack.push(node.getChildList().get(i));
			}
		}
	}

	public interface Traversal<T> {
		boolean isBreak(TreeElement<T> node);
	}
}
