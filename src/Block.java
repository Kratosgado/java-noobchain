import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private final String data; // data will be a simple message.
    private final long timeStamp; // as number of milliseconds since 1/1/1970.

    // Block Constructor.
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculatehash(); // Making sure we do this after we set the other values.
    }

    // Applies Sha256 to a string and returns the result.
    public String calculatehash(){
        String calculatedHash = StringUtil.applySha256(previousHash + Long.toString(timeStamp) + data);
        return calculatedHash;
    }
}
