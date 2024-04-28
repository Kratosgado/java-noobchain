import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private final String data; // data will be a simple message.
    private final long timeStamp; // as number of milliseconds since 1/1/1970.
    private int nonce;

    // Block Constructor.
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculatehash(); // Making sure we do this after we set the other values.
    }

    // Applies Sha256 to a string and returns the result.
    public String calculatehash(){
        String calculatedHash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
              data);
        return calculatedHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculatehash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
