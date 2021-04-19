import java.util.*;

class IntList {
  int value;
	IntList next = null;

    public IntList(int v, IntList n) {
        value = v;
        next = n;
    }
}

class FoldIntList {
	public IntList center(IntList head) {
		IntList slow = head;
		IntList fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public IntList fold(IntList head) {
		IntList result = center(head);
		
		Deque<IntList> dq = new ArrayDeque<IntList>();
		IntList curr = head;
		while (curr != null) {
			dq.add(curr);
			curr = curr.next;
		}
	
		while (dq.size() > 1) {
			IntList left = dq.removeFirst();
			IntList right = dq.removeLast();
			right.value += left.value;
		}
		
		return result;
	}
}

public class Driver {
    public static void main(String args[]) {
        FoldIntList folder = new FoldIntList();
        IntList l1 = constructIntList(new int[]{3, 1, 2, 4});
        IntList l2 = constructIntList(new int[]{1, 2, 3});
        IntList l3 = constructIntList(new int[]{8, 4, 2, 1, 1, 1, 2, 4, 8});

        test(l1, folder);
        test(l2, folder);
        test(l3, folder);
    }
    
    public static IntList constructIntList(int arr[]) {
        IntList result = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            result = new IntList(arr[i], result);
        }
        return result;
    }
    
    public static String printIntList(IntList l) {
        String result = "";
        while (l != null) {
            result += Integer.toString(l.value) + "->";
            l = l.next;
        }
        return result.length() == 0 ? "" : result.substring(0, result.length() - 2);
    }
    
    public static void test(IntList l, FoldIntList f) {
        System.out.println("Before: " + printIntList(l));
        System.out.println("After: " + printIntList(f.fold(l)));
        System.out.println("");
    }
}
