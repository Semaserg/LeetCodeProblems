package LeetCode.stack.MiniParser_385;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
      private boolean single = false;
      private int value = 0;
      private ArrayList<NestedInteger> list = new ArrayList<>();

      // Constructor initializes an empty nested list.
      public NestedInteger(){
      }

      // Constructor initializes a single integer.
      public NestedInteger(int value){
            this.value = value;
            this.single = true;
      }

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger(){
          return single;
      }

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger(){
          if(!single) return null;
          return this.value;
      }

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value){
          this.value = value;
      }

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni){
            this.list.add(ni);
      }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList(){
         return list;
     }

    public boolean isSingle() {
        return single;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value + ", ");
        if (!this.list.isEmpty()) {
            sb.append("[ ");
            for (NestedInteger ni : this.list) {
                sb.append(ni);
            }
            sb.append(" ]");
        }
        return sb.toString();
    }
}
