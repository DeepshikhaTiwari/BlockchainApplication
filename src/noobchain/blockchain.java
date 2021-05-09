package noobchain;

import java.lang.*;
import java.text.*;
import java.util.*;

public class blockchain {

ArrayList<Block> blockchain = new ArrayList<>();

public static void main (String args[]) throws Exception {

String[] genesisTransactions = {"abc sent bca 1000 bitcoin","def sent 10 bitcoin to abc"};
int previousHash = 0;
blockchain_2 genesisBlock = new blockchain_2(previousHash, genesisTransactions);

String[] block2Transactions = {"Hello"};
blockchain_2 block2 = new blockchain_2(genesisBlock.getBlockHash(),block2Transactions);

System.out.println("Hash of genesis block :");
System.out.println(genesisBlock.getBlockHash());
System.out.println("Hash of block2:");
System.out.println(block2.getBlockHash());
  }
}