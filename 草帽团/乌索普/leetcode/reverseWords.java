class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder target = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(String str : strArr) {
        	char[] tempCharArr = str.toCharArray();
            for (Character item : tempCharArr) {
            	stack.push(item);
			}
            
            for (int i = 0; i < tempCharArr.length; i++) {
            	target.append(stack.pop());
			}
            target.append(" ");
        }
		return target.toString().trim();
    }
}



class Solution {
    public String reverseWords(String s) {
        s += " ";
        char[] tempCharArr = s.toCharArray();
        StringBuilder target = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>(48);
        List<Integer> slotList = new ArrayList<>();
        
        for(int i=0;i<tempCharArr.length;i++) {
            map.put(i, tempCharArr[i]);
            if(" ".equals(tempCharArr[i]+"")) {
                slotList.add(i);
            }
        }
        
        int start = 0;
        for(int i=0;i<slotList.size();i++) {
            int end = slotList.get(i);
            int temp = end;
            for(--end;end>=start;end--) {
                target.append(map.get(end).toString());
            }
            target.append(" ");
            start = ++temp;
        }
        
        return target.toString().trim();
        
    }
}


// 向前插入
class Solution {
    public String reverseWords(String s) {
        
        String result="";
        String tmp = ""; 
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) == ' '){
                result+=tmp+" ";
                tmp = "";
            }else{
                tmp=s.charAt(i)+tmp;
            }
        }
        return result+tmp;
        
    }
}

// good job！
class Solution {
    public void reverseString(char[] s) {
        
        int size = s.length;
        int start = 0;
        int end = size - 1;
        if(size>1) {
            if(size % 2 == 0) {
                for(int i=0;i<size/2;i++) {
                    swap(s, start, end);
                    start++;
                    end--;
                }
            } else {
                while(start!=end) {
                    swap(s, start, end);
                    start++;
                    end--;
                }
            }
        }
        
    }
    
    public void swap(char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }
    
}



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


// 二叉搜索树（二叉排序树）【前提】
// 中序遍历有序
// 求第K小 值
// 二叉搜索树定义：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 
// 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
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
    public int kthSmallest(TreeNode root, int k) {
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                System.out.println("if:"+cur.val);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println("else:"+cur.val);
                if (++i == k) {
                    return cur.val;
                }
                cur = cur.right;
            }
        }
        return -1; // 或者抛异常 throw new IllegalArgumentException("k is illegal...");
    }
}