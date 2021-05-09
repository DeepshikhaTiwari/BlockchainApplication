package noobchain;
import java.util.Date;
import java.security.*;

class Block {
	public String hash;
	public String previousHash;
	private String data; 
	private long timeStamp; 
	Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
	}
	public void mineBlock(int difficulty) {
		
	}
}
class StringUtil { 
public static String applySha256(String input){		
try {
MessageDigest digest = MessageDigest.getInstance("SHA-256");	         
byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
StringBuffer hexString = new StringBuffer(); 
for (int i = 0; i < hash.length; i++) {
String hex = Integer.toHexString(0xff & hash[i]);
if(hex.length() == 1) hexString.append('0');
hexString.append(hex);
}
return hexString.toString();
}
catch(Exception e) {
throw new RuntimeException(e);
}
}
private String data;
private String previousHash;
private long timeStamp;
private String hash;
public String calculateHash(int data, long timeStamp, String previousHash) {
String calculatedhash = StringUtil.applySha256(previousHash +Long.toString(timeStamp) +data);
return calculatedhash;
}
public void Block(String data,String previousHash,long timeStamp,String calculateHash ) {
	this.data = data;
	this.previousHash = previousHash;
	this.timeStamp = new Date().getTime();
	this.hash = calculateHash(0, timeStamp, calculateHash); 
  }
}
public class noobchain {

	public static void main(String[] args) {
		Block genesisBlock = new Block("Hi im the first block", "0");
		System.out.println("Hash for block 1 : " + genesisBlock.hash);
		
		Block secondBlock = new Block("Hllo im the second block",genesisBlock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		Block thirdBlock = new Block("Hey im the third block",secondBlock.hash);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);
   }
}