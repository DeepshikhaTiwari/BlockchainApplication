package noobchain;

import java.util.Arrays;

public class blockchain_2 {
 private int previousHash;
 
 private String[] transaction;
 
 public  int blockHash;
 
public blockchain_2(int previousHash,String[] transaction) {
this.previousHash = previousHash;
this.transaction =transaction;

Object[] contense= {Arrays.deepHashCode(transaction),previousHash};
this.blockHash = Arrays.hashCode(contense);
 
}
 
public int getPreviousHash() {
return previousHash;

 }

 public String[] getTransaction() {
return transaction;
 }

public int getBlockHash1() {

return blockHash;
}

public int getBlockHash() {
	return blockHash;
  }
}