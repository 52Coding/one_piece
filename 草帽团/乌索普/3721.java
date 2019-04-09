// 001	两数之和	每天一算：Two Sum
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 002	两个数字相加	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

// 003	无重复字符的最长子串
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

// 复杂度分析
// 时间复杂度：O(L)O(L)，
// 该算法对含有 LL 个结点的列表进行了一次遍历。因此时间复杂度为 O(L)O(L)。
// 空间复杂度：O(1)O(1)，
// 我们只用了常量级的额外空间。

// 019	删除链表的倒数第N个节点
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}


// 020	有效的括号
class Solution {

  // Hash table that takes care of the mappings.
  private HashMap<Character, Character> mappings;

  // Initialize hash map with mappings. This simply makes the code easier to read.
  public Solution() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {

    // Initialize a stack to be used in the algorithm.
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket.
      if (this.mappings.containsKey(c)) {

        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}
// 复杂度分析
// 时间复杂度：O(n)O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1)O(1) 的推入和弹出操作。
// 空间复杂度：O(n)O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。例如 ((((((((((。



// 024	两两交换链表中的节点
// 使用递归来解决该题，主要就是递归的三部曲：
// 找终止条件：本题终止条件很明显，当递归到链表为空或者链表只剩一个元素的时候，没得交换了，自然就终止了。
// 找返回值：返回给上一层递归的值应该是已经交换完成后的子链表。
// 单次的过程：因为递归是重复做一样的事情，所以从宏观上考虑，只用考虑某一步是怎么完成的。我们假设待交换的俩节点分别为head和next，next的应该接受上一级返回的子链表(参考第2步)。就相当于是一个含三个节点的链表交换前两个节点，就很简单了，想不明白的画画图就ok。
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

// 026	删除排序数组中的重复项
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}
// 复杂度分析
// 时间复杂度：O(n)O(n)， 假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
// 空间复杂度：O(1)O(1)。

// 075	颜色分类
class Solution {
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int i = 0;//始终指向值为0的位置
        int j = len-1;//始终指向值为2的位置
        for(int k = 0;k<len;k++){
            if(k>j) break;//j后面全是2，所以如果超过了j，就不用再比了
            if(nums[k]==0 && k!=i){
                swap(nums,k,i);//将值为0的数交换到i的位置
                k--;//交换回来的值还需要比较，所以保持当前遍历位置k不变
                i++;//值为0的指针向右移动一下
                
            }else if(nums[k]==2 && k!=j){
                swap(nums,k,j);//将值为2的数交换到j的位置
                k--;//交换回来的值还需要比较，所以保持当前遍历位置k不变
                j--;//值为2的指针向左移动一下
            }
            
        }
    }
}


// 086	分隔链表
// 借助虚拟头结点实现
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}

// 092	反转链表 II
// 时间复杂度：O(n)
// 空间复杂度：O(1)
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)  return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = null, temp = dummy, next = null, cutPoint = dummy;
        int cnt = 1;
        // 先确定从哪里开始翻转
        while (cnt < m) {
            cnt++;
            temp = temp.next;
        }
        // 1->2->3->4->5->NULL, m = 2, n = 4
        // cutPoint 记录翻转点的上一个节点
        cutPoint = temp;
        temp = temp.next;
        // 局部翻转
        while (cnt <= n) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            cnt++;
        }
        // 1<=>2<-3<-4<-5->NULL
        // 将 2 的后继指向 5
        // 将 1 的后继指向 4
        cutPoint.next.next = next;
        cutPoint.next = prev;
        return dummy.next;
    }
}


// 094	二叉树的中序遍历
// 基于栈的中序遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}


// 102	二叉树的层序遍历
// 利用队列实现二叉树的层次遍历
public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null)
        return new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
        int count = queue.size();
        List<Integer> list = new ArrayList<Integer>();
        while(count > 0){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            count--;
        }
        res.add(list);
    }
    return res;
}


// 103	二叉树的锯齿形层次遍历
// 有一种东西，既可以是栈，又可是队列，它有着双重身份，它的名字叫做——双端队列。c++ 对应的数据结构是 deque.
// 使用一个双端队列实现。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 锯齿形层次遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null ){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>(); // 队列
        queue.add(root);
        boolean left = true; //记录是从左往右还是从右往左
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList(size);
            if(left){ // 从左边出，先加左孩子再加右孩子
                while(size > 0){
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if(node.left != null){
                        queue.addFirst(node.left);
                    }
                    if(node.right != null){
                        queue.addFirst(node.right);
                    }
                    size--;
                }
            }else{
                // 从右边出，先加右孩子再加左孩子
                while(size > 0){
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if(node.right != null){
                        queue.addLast(node.right);
                    }
                    if(node.left != null){
                        queue.addLast(node.left);
                    }
                    size--;
                }                
            }            
            left = !left;
            res.add(list);
        }
        return res;
    }
}


// 107	二叉树的层次遍历 II
class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            func(lists, 0, root);
            for (int i = 0, j = lists.size() - 1; i < j; i++, j--) {
                List<Integer> temp = lists.get(i);
                lists.set(i, lists.get(j));
                lists.set(j, temp);
            }
            return lists;
        }

        private void func(List<List<Integer>> lists, int level, TreeNode root) {
            if (root == null) {
                return;
            }
            if (lists.size() == level) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                lists.add(list);
            } else {
                lists.get(level).add(root.val);
            }
            func(lists, level + 1, root.left);
            func(lists, level + 1, root.right);
        }
    }


// 136	只出现一次的数字
// 异或
public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }

// 144	二叉树的前序遍历
// 迭代（栈实现）：
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        List<Integer> list=new ArrayList<>();
        while(root!=null||!st.empty()){
            if(root!=null){
                list.add(root.val);
                st.push(root);
                root=root.left;
            }else{
                root=st.pop().right;
            }
        }
        return list;
    }
}

// 145	二叉树的后序遍历
// 写法(1)：递归写法 写法(2)：迭代写法，利用pre记录上一个访问过的结点，与当前结点比较，如果是当前结点的子节点，说明其左右结点均已访问，将当前结点出栈，更新pre记录的对象。 写法(3)：取巧的方法。该写法的访问顺序并不是后序遍历，而是利用先序遍历“根左右”的遍历顺序，将先序遍历顺序更改为“根右左”，反转结果List，得到结果顺序为“左右根”。
/*
//写法(1)
public List<Integer> res = new ArrayList<Integer>();
public List<Integer> postorderTraversal(TreeNode root) {//递归写法
    if(root == null)
        return res;
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    res.add(root.val);
    return res;
}*/
/*
//写法(2)
public List<Integer> postorderTraversal(TreeNode root) {//非递归写法
    List<Integer> res = new ArrayList<Integer>();
    if(root == null)
        return res;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode pre = null;
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode curr = stack.peek();            
        if((curr.left == null && curr.right == null) ||
           (pre != null && (pre == curr.left || pre == curr.right))){ 
                        //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
            res.add(curr.val);
            pre = curr;
            stack.pop();
        }else{
            if(curr.right != null) stack.push(curr.right); //先将右结点压栈
            if(curr.left != null) stack.push(curr.left);   //再将左结点入栈
        }            
    }
    return res;        
}
*/
/*
//方法(3)
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if(root == null)
        return res;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
        if(node.right != null) stack.push(node.right);//后将右结点入栈
        res.add(0,node.val);                        //逆序添加结点值
    }     
    return res;
}
*/

// 146	LRU缓存机制
// 双链表和hashmap：
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            // 如果node不是最后一个，将其挪到最后一个
            if (node != last) {
                // 先将node移除
                removeNode(node);
                // 然后放在最后
                addLast(node);
            }
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                // 删除最老的最没用的
                cache.remove(first.key);
                removeLast();
            }
            addLast(new Node(key, value));
            cache.put(key, last);
        } else {
            node.value = value;
            get(key);  // refresh key
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        // first
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }
        next.prev = prev;
    }

    private void addLast(Node node) {
        node.next = null;
        node.prev = last;
        // 第一个添加的元素
        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    private void removeLast() {
        Node next = first.next;
        // 只有一个元素，删除first后first，last都为null
        // 否则，将下一个元素的prev置为null，并将其设为first
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        first = first.next;
    }

    private static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

// 解法2：
// 手动实现HashMap&LinkedHashMap(简单实现)。
/**
 * LRUCache
 * 
 * @author Hansin1997
 *
 */
public class LRUCache {

	public static class Node {

		protected int hash;
		protected int key;
		protected int value;
		protected Node before, after, previous, next;

		public Node(int hash, int key) {
			this.hash = hash;
			this.key = key;
			before = after = previous = next = null;
		}

		public Node(int hash, int key, int value) {
			this.hash = hash;
			this.key = key;
			this.value = value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}
	}

	protected static final float DEFAULT = 3f;
	protected int cap, size;
	protected Node data[], head, tail;

	public LRUCache(int capacity) {
		this.cap = capacity;
		this.size = 0;
		this.data = new Node[(int) (cap * DEFAULT)];
		this.head = tail = null;
	}

	protected int hash(int key) {
		return (key ^ (key >>> 16)) & (data.length - 1);
	}

	protected Node getNode(int hash, int key) {
		Node p = data[hash];
		while (p != null) {
			if (p.key == key)
				return p;
			p = p.next;
		}
		return null;
	}

	protected void update(Node node) {
		if (tail == node)
			return;
		if (head == node) {
			node.after.before = null;
			head = node.after;
		} else {
			node.after.before = node.before;
			node.before.after = node.after;
		}
		tail.after = node;
        node.before = tail;
		node.after = null;
		tail = node;
	}

	protected void insert(Node node) {
		if (size < cap)
			size++;
		else {
			if (head.next != null) {
				head.next.previous = head.previous;
			}
			if (head.previous != null) {
				head.previous.next = head.next;
			} else {
				data[head.hash] = head.next;
			}

			if (head.after != null) {
				head.after.before = null;
				head = head.after;
			} else {
				head = tail = node;
			}
		}
		if (head == null) {
			head = tail = node;
		} else if(node != tail){
			node.before = tail;
			tail.after = node;
			tail = node;
		}

		Node p = data[node.hash];
		if (p == null)
			data[node.hash] = node;
		else {
			while (true) {
				if (p.next == null) {
					p.next = node;
					node.previous = p;
					break;
				}
				p = p.next;
			}
		}
	}

	public int get(int key) {
		Node node = getNode(hash(key), key);
		if (node != null) {
			update(node);
			return node.getValue();
		}
		return -1;
	}

	public void put(int key, int value) {
		int hash = hash(key);
		Node node = getNode(hash, key);
		if (node != null) {
			update(node);
			node.setValue(value);
		} else {
			node = new Node(hash, key, value);
			insert(node);
		}
	}

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


//  150	逆波兰表达式求值
class Solution {
    public int evalRPN(String[] tokens) {
        
         Stack<Integer> stack=new Stack<Integer>();
		 for(int i=0;i<tokens.length;i++) {
			 switch (tokens[i]) {
			case "+":
				int j=stack.pop();
				int k=stack.pop();
				stack.push(k+j);
				break;
			case "-":
				int jj=stack.pop();
				int kk=stack.pop();
				stack.push(kk-jj);
				break;
			case "*":
				int jjj=stack.pop();
				int kkk=stack.pop();
				stack.push(kkk*jjj);
				break;
			case "/":
				int jjjj=stack.pop();
				int kkkk=stack.pop();
				stack.push(kkkk/jjjj);
				break;
			default:
				stack.push(Integer.parseInt(tokens[i]));
				break;
			}
		 }
		 
		 return stack.pop();
    }
}

// 167	两数之和 II - 输入有序数组
public int[] twoSum(int[] numbers, int target) {
        //方法一：采用二分搜索法，给定i，对于(i, numbers.length-1]的区域使用二分搜索法
        // 使得numbers[j] = target - numbers[i]; 时间复杂度为O（nlogn）
        int[] result = new int[2];
        int N = numbers.length;
        for (int i = 0; i < N; i++) {
            int aim = target - numbers[i];
            int lo = i + 1, hi = N - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (numbers[mid] == aim) {
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                } else if (numbers[mid] < aim) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return result;
    }

public int[] twoSum(int[] numbers, int target) {
        //方法二：双指针对撞法 由于数组有序，故可从两端开始同时遍历，时间复杂度为O（n）
        int l = 0, r = numbers.length - 1;
        int sum = numbers[l] + numbers[r];
        int[] result = new int[2];
        while (sum != target && l < r) {
            if(sum < target) ++l;
            else if(sum > target) --r;
            else {
                break;
            }
            sum = numbers[l] + numbers[r];
        }
        result[0] = l + 1;
        result[1] = r + 1;
        return result;
    }

// 199	二叉树的右视图
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        int sign = 1;
        deque.add(root);
        int count = 0;
        while (deque.size() > 0) {
            TreeNode node = deque.pollFirst();
            if(node.left != null) {
                deque.addLast(node.left);
                count++;
            }
            if(node.right != null) {
                deque.addLast(node.right);
                count++;
            }
            sign--;
            if(sign == 0) {
               sign = count;
               count = 0;
               list.add(node.val);
            }
        }
        return list;
    }
}


// 203	移除链表元素
public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return header.next;
    }


// 206	反转链表
// 复杂度分析
// 时间复杂度：O(n)O(n) 。 假设 nn 是列表的长度，时间复杂度是 O(n)O(n)。
// 空间复杂度：O(1)O(1) 
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}

// 复杂度分析
// 时间复杂度：O(n)O(n) 。 假设 nn 是列表的长度，那么时间复杂度为 O(n)O(n)。
// 空间复杂度：O(n)O(n) 。 由于使用递归，将会使用隐式栈空间。递归深度可能会达到 nn 层。
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}


// 209	长度最小的子数组
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;//nums[l...r]为滑动窗口
        int r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while(l < nums.length) {
        	if (r+1 < nums.length && sum < s) {
				sum += nums[++r];
			}else {
				sum -= nums[l++];
			}
        	if (sum >= s) {
				res = (r-l+1) < res ? (r-l+1):res;
			}
        }
        return res == nums.length + 1? 0: res;
    }
}

// 219	存在重复元素 II
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet();
        while(j < len) {
            if (!set.add(nums[j])) {
                return true;
            }
            if (j - i == k) {
                set.remove(nums[i++]);
            }
            j++;
        }
        
        return false;
    }
}


// 237	删除链表中的节点
// 时间和空间复杂度都是：O(1)O(1)。
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}

// 279	完全平方数
// 动态规划
import java.util.*;
class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 1;
        for(int i=1;i<=n;i++){
            int m = (int)Math.sqrt(i);
            if(m*m==i) dp[i] = 1;
            else{
                for(int j = 1;j <= i/2; j++){
                    dp[i] = Math.min(dp[j]+dp[i-j],dp[i]);
                }
            }
        }
        return dp[n];
    }
}


// 283	移动零
class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            } 
            nums[i-count] = nums[i];
        }
        
        for (int i = nums.length-1; i >= nums.length-count; i--) {
            nums[i] = 0;
        }
    }
}

// 328	奇偶链表
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode o = head;
        ListNode p = head.next;
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }
}

// 344	反转字符串
// 面试的时候肯定不让用reverse()这种高级函数的。
class Solution {
    public String reverseString(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] ch = s.toCharArray();
        while(i<j){
            swap(ch,i,j);
            i++;
            j--;
        }
        return new String(ch);
    }
    public void swap(char[] ch,int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}


// 349	两个数组的交集
// JAVA实现： 假设长度小的数组为 less, 长度为 M；长度大的数组为 more, 长度为 N
// 使用长度小的数组建立哈希表 lessSet，用于匹配查找，时间复杂度为 O(M), 最大额外空间复杂度为 O(M).
// 循环长度大的数组，通过哈希表 lessSet 匹配与长度小的数组的交集，查找时间复杂度为 O(1)，总的时间复杂度为 O(N).
// 总体的时间复杂度为 O(max(nums1.length, nums2.length)), 额外空间复杂度为 O(min(nums1.length, nums2.length)).
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
	int[] less = len1 < len2 ? nums1 : nums2;
	int[] more = len1 < len2 ? nums2 : nums1;
	
        //长度小的数组建立哈希表, 用于匹配查找
	HashSet<Integer> lessSet = new HashSet<Integer>();
	for(int i = 0, len = less.length; i < len; i++){
	    lessSet.add(less[i]);
	}
	//循环长度大的数组进行查找, 与哈希表匹配
	HashSet<Integer> moreSet = new HashSet<Integer>();
	for(int i = 0, len = more.length; i < len; i++){
	    if(!moreSet.contains(more[i]) && lessSet.contains(more[i])){
	        moreSet.add(more[i]);
	    }
	}
		
	//Set 转为 数组
	int size = moreSet.size(), k = 0;
	int[] ans = new int[size];
	for(int n : moreSet){
	    ans[k++] = n;
	}
	return ans;
    }
}

// 350	两个数组的交集 II
[Java] 几种实现方法，最后一种比较容易理解

class Solution {
    /**
     * 使用集合实现
     */
    public int[] intersect_1(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                // 从 list1 除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[list2.size()];
        int i = 0;
        for (int num : list2) {
            res[i++] = num;
        }
        return res;
    }

    /**
     * 使用集合的实现
     */
    public int[] intersect_2(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2)
                .boxed()
                .filter(num -> {
                    if (list1.contains(num)) {
                        list1.remove(num);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        int[] res = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            res[i] = list2.get(i);
        }
        return res;
    }

    /**
     * 使用映射实现
     */
    public int[] intersect_3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 将 nums1 出现的数值及频次放入映射中
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++count);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map.put(num, --count);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 排序预处理
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}


// 445	两数相加 II
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>stack1 = new Stack<>();
        Stack<Integer>stack2 = new Stack<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(0);
        boolean carry = false;
        while (p1!=null){
            stack1.add(p1.val);
            p1 = p1.next;
        }
        while (p2!=null){
            stack2.add(p2.val);
            p2 = p2.next;
        }
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            int r1 = stack1.isEmpty()?0:stack1.peek();
            int r2 = stack2.isEmpty()?0:stack2.peek();
            int sum = r1 + r2 + (carry ? 1:0);
            carry = (sum>=10);
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = res.next;
            res.next = newNode;
            if (!stack1.isEmpty()) stack1.pop();
            if (!stack2.isEmpty()) stack2.pop();
        }
        if (carry){  //最高为还有进位
            ListNode newNode = new ListNode(1);
            newNode.next = res.next;
            res.next = newNode;
        }
        return res.next;
    }
}


// 447	回旋镖的数量
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        //由于每一个点都可能是回旋镖的顶点 (三个点中的第一个点)，需要对每个点都分别进行考虑
        //对每一个点，构造一个查询表，K为其它点到该点的距离（避免浮点误差，使用距离的平方），V为该距离出现的频次
        for(int i=0; i<points.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for(int j=0; j<points.length; j++){
                if(i!=j){                    
                    int dist = (int)Math.pow((points[i][0]-points[j][0]), 2)+(int)Math.pow((points[i][1]-points[j][1]), 2);                         map.put(dist, map.getOrDefault(dist, 0)+1);              
                }           
            }
            
            //计算以i为顶点的回旋镖的个数
            for(int d : map.keySet()){
                int nums = map.get(d);
                if(nums>=2){
                    res+=nums*(nums-1);  //有nums个点到点i的距离相等
                }               
            }
        }
        
        return res;        
    }
}


// 454	四数相加 II
class Solution {
    //使用查找表，一个map存储A ,B和的所有组合和出现次数
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer ,Integer> mapAB =new HashMap<>();
        int res =0;

        for(int i =0 ; i<A.length ;i++){
            for(int j =0 ; j<B.length ;j++){
                int key =A[i]+B[j];
                if(mapAB.containsKey(key))
                    mapAB.put(key,mapAB.get(key)+1);
                else mapAB.put(key,1);
            }
        }

        for(int i =0 ; i<C.length ;i++){
            for(int j =0 ; j<D.length ;j++){
                int key =C[i]+D[j];
                if(mapAB.containsKey(0-key)){
                    res += mapAB.get(0-key);
                }
            }
        }
        return res;

    }
}




