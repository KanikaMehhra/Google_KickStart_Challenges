package challenge3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {
	private Node root;
	private Stack<Node> nodeStack;
	private int longestPath;
	private List<Node> nodesLeft;
	private boolean found;

	public Tree(Node root, List<Node> nodesLeft) {
		this.root = root;
		this.nodeStack = new Stack<Node>();
		this.longestPath = 0;
		this.nodesLeft = nodesLeft;
		this.found = false;
		setLongestPath(this.root, 1);
	}

	public Node getRoot() {
		return this.root;
	}

	public int getLongestPath() {
		return this.longestPath;
	}

	public void setLongestPath(Node root, int currentPathCount) {
		if (root.getLeftNode() == null && root.getRightNode() == null) {
			if (!nodeStack.empty()) {
				Node popped = nodeStack.pop();
				this.longestPath = Math.max(this.longestPath, currentPathCount);
				this.nodesLeft.remove(popped);
				setLongestPath(popped, 1);
			} else {
				if (!this.found) {
					this.found = true;
					return;
				}
			}
		} else if (root.getLeftNode() == null) {
			if (root.getValue() == root.getRightNode().getValue() - 1) {
				currentPathCount++;
				setLongestPath(root.getRightNode(), currentPathCount);
			}
			this.longestPath = Math.max(this.longestPath, currentPathCount);
			this.nodesLeft.remove(root.getRightNode());
			setLongestPath(root.getRightNode(), 1);
		} else if (root.getRightNode() == null) {
			if (root.getValue() == root.getLeftNode().getValue() - 1) {
				currentPathCount++;
				setLongestPath(root.getLeftNode(), currentPathCount);
			}
			this.longestPath = Math.max(this.longestPath, currentPathCount);
			this.nodesLeft.remove(root.getLeftNode());
			setLongestPath(root.getLeftNode(), 1);
		} else if (root.getValue() == root.getLeftNode().getValue() - 1) {
			nodeStack.push(root.getRightNode());
			currentPathCount++;
			this.nodesLeft.remove(root.getLeftNode());
			setLongestPath(root.getLeftNode(), currentPathCount);
		} else if (root.getValue() == root.getRightNode().getValue() - 1) {
			nodeStack.push(root.getLeftNode());
			currentPathCount++;
			this.nodesLeft.remove(root.getRightNode());
			setLongestPath(root.getRightNode(), currentPathCount);
		} else {
			nodeStack.push(root.getLeftNode());
			this.nodesLeft.remove(root.getRightNode());
			setLongestPath(root.getRightNode(), 1);
		}
	}
	
	
	/*public void setLongestPath(Node root, int currentPathCount) {
		   List<Node> children=new ArrayList<Node>();
		   // Add left and right nodes to children, if present.
		   if(root.getLeftNode()!=null) {
			   children.add(root.getLeftNode());			   
		   }
		   if(root.getRightNode()!=null) {
			   children.add(root.getRightNode());		   
		   }

		   if (children.isEmpty()) {
		      // pop another node off the stack, etc...
			   if (!nodeStack.empty()) {
					Node popped = nodeStack.pop();
					this.longestPath = Math.max(this.longestPath, currentPathCount);
					this.nodesLeft.remove(popped);
					setLongestPath(popped, 1);
				} else {
					if (!this.found) {
						this.found = true;
						return;
					}
				}
		   }
		   boolean flag=true;
		   for (Node child : children) {
//			   if(child==null) {
//				   this.longestPath = Math.max(this.longestPath, currentPathCount);
//					this.nodesLeft.remove(root.getLeftNode());
////					setLongestPath(root.getLeftNode(), 1);
//			   }else
		      if (root.getValue() == child.getValue() - 1) {
		         // follow the path; call setLongestPath recursively
		    	  currentPathCount++;
		    	  flag=false;
		    	  setLongestPath(child, currentPathCount);
		      } else {
		         // push child onto stack
		    	 this.nodeStack.push(child);
		      }
		   }
		   if(flag) {
			   Node popped = nodeStack.pop();
				this.longestPath = Math.max(this.longestPath, currentPathCount);
				this.nodesLeft.remove(popped);
				setLongestPath(popped, 1);
		   }
		}*/
}
