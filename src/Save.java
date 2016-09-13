import java.io.*;
import java.util.*;

public class Save {
	public void LoadSave(File LoadPath){
		try {
		Scanner LoadScanner = new Scanner(LoadPath);
		
			while(LoadScanner.hasNext()){
				Screen.killsToWin = LoadScanner.nextInt();
				
				for(int y=0;y<Screen.room.block.length;y++){
					for(int x=0;x<Screen.room.block[0].length;x++){
						Screen.room.block[y][x].groundID = LoadScanner.nextInt();
					}
				}
				
				for(int y=0;y<Screen.room.block.length;y++){
					for(int x=0;x<Screen.room.block[0].length;x++){
						Screen.room.block[y][x].airID = LoadScanner.nextInt();
					}
				}
			}
			
			LoadScanner.close();
		} catch(Exception e) {}
	}
}
