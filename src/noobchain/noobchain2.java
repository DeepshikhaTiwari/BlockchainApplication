package noobchain;
import java.util.Date;

import java.util.ArrayList;
public static Boolean isChainValid() {
Block currentBlock; 
Block previousBlock;{
for(int i=1; i < blockchain.size(); i++) {
currentBlock = blockchain.get(i);
previousBlock = blockchain.get(i-1);
if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
System.out.println("Current Hashes not equal");			
return false;
}
if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
System.out.println("Previous Hashes not equal");
return false;
}
}
return true;
}
}
class chain {
	
public String hash;
public String previousHash; 
private String data; 
private long timeStamp;
private int nonce;  
public chain(String data,String previousHash ) {
this.data = data;
this.previousHash = previousHash;
this.timeStamp = new Date().getTime();
this.hash = calculateHash(); 
}
public String calculateHash() {
String calculatedhash = StringUtil.applySha256( 
previousHash +Long.toString(timeStamp) +Integer.toString(nonce) + data );
return calculatedhash;
}
public void mineBlock(int difficulty) {
String target = new String(new char[difficulty]).replace('\0', '0');  
while(!hash.substring( 0, difficulty).equals(target)) {
nonce ++;
hash = calculateHash();
}
System.out.println("Block Mined!!! : " + hash);
}
}

public class noobchain2 {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
	public static void main(String[] args) {
		blockchain.add(new Block("Hi im the first block", "0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}
	
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
  }