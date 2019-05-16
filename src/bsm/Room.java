package bsm;
import java.util.Scanner;
import java.util.List;

public class Room {
	private String id;
    private String name;
    private int maxSize;
    private String password;
	

public void setId(String id) { this.id = id; }
public String getId() { return id; }

public void setName(String name) { this.name = name; }
public String getName() { return name; }

public void setMaxSize(int maxSize) { this.maxSize = maxSize; }
public int MaxSize() { return maxSize; }

public void setPassword(String password) { this.password = password; }

public boolean checkPassword(String input) { 

    if (input.equals(password)) {
        return true;
    } 
    return false;
}

}