package qubole.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * created a class to maintain the File object along with its size to ease the sorting process
 */
class SortFile{
	File f;
	int size;
	SortFile(File f , int size){
		this.f=f;
		this.size=size;
	}
}

/**
 * Comparator to sort the File objects 
 */
class SortComparator implements Comparator<SortFile>{
	public int compare(SortFile e1, SortFile e2){
		if(e1.size<e2.size) return -1;
		if(e1.size>e2.size) return 1;
		else return 0;
	}
}

/**
 * Assumption: 
 * Given that this is a standard Java File interface , i have assumed a instance method toString() exists which returns the String form of the path of the File object
 * the question did not mention how we can get  a handle on the string form on the file to print it
 * 
 * Eg:
 * File f = new File("/original/path");
 * System.out.println(f.toString)
 * >> /original/path
 */
public class PrintFilePath {

	/**
	 * Base method to print the file system in tree form
	 * @param path
	 */
	public static void printFileTree(String path){
		check(path,new File(path),0,new ArrayList<File>());
	}
	
	/**
	 * This recursive method does the main computation.
	 * @param base -> parent path for this File object
	 * @param file -> File object to be traversed now
	 * @param space -> number of spaces to be printed
	 * @param parent -> array list that contains files that have been visited to avoid infinite loops
	 */
	public static void check(String base, File file , int space,List<File> parent){
		/*maintain a list of files that have been visited*/
		parent.add(file);
		/*if file is a directory then get the subfiles/sub-directories and recursively process them*/
		if(file.isDir()){
			printSpace(space);
			String ending=printNecessary(base,file.toString(),true);
			File[] list = file.list();
			for(int i=0;i<list.length;i++){
				String canonicalPath = file.getCanonicalPath();
				/*if the file is a link to any file seen before then do not recursively handle it , just print the file name and continue*/
				if(parent.contains(new File(canonicalPath))) {
					printSpace(space);
					printNecessary(base,file.toString(),false);
					continue;
				}
				check(base+"/"+ending,list[i],space+8,parent);
			}
		}else{
			/*if it is a file, then print the necessary spaces , filename and return*/
			printSpace(space);
			printNecessary(base,file.toString(),false);
			return;
		}
	}
	/**
	 * helper function to print spaces
	 * @param count
	 */
	public static void printSpace(int count){
		for(int i=0;i<count;i++) System.out.print(" ");
	}
	/**
	 * helper function to get the trailing part of the file path , relative to the parent in order to print
	 * @param str1 -> /original/path/
	 * @param str2 -> /original/path/dir1
	 * @param isDir
	 */
	public static void printNecessary(String str1,String str2, boolean isDir){
		/*this will happen for the root of the FS being traversed. i.e str1="/original/path" str2="/original/path" */
		if(str1.equals(str1)) {
			if(isDir) System.out.println(str1+"/");
			else System.out.println(str1);
		}
		else{
			for(int i=0;i<str2.length();i++){
				if(str1.charAt(i)==str2.charAt(i)) continue;
			}
			String necessary = str2.substring(i);
			if(isDir) System.out.println(necessary+"/");
			else System.out.println(necessary);
		}
	}
	/**
	 * Logic: get the sublist of files and directories. create a array of objects associating the File object with its size. Sort this array 
	 * using a comparator.Assign the objects to the numsets arrays in a round robin fashion . if numsets is 3 and there are 9 subdirectories/files which are sorted
	 * file 0,4,7-> array1 file 1,5,8->array2 file 3,6,9 -> array3 . This way the arrays might have roughly similar size  
	 * @param numSets
	 */
	List<File[]> getFileSets(int numSets){
		//initially creating a list of File arrays. This seemed easier while implementing. will reverse this and return.
		List<File>[] array = (List<File>[])new ArrayList[numSets];
		File[] subList = list();//get list of files and subdirectories
		SortFile[] sorted = new SortFile[subList.length]; // create a array of SortedFile objects inorder to sort Files based on size
		for(int i=0;i<subList.length;i++){
			SortFile sf = new SortFile(subList[i],subList[i].getLength());
			sorted[i]=sf;
		}
		//sort the arrays based on the size of the File object.
		Arrays.sort(sorted,new SortComparator());
		
		//add the sorted File objects one at a time in  a round robbin fashion to the main array.
		for(int i=0;i<subList.length;i++){
			array[i%numSets].add(sorted[i].f);
		}
		
		List<File[]> finalList = new ArrayList<File[]>();
		for(int i=0;i<array.length;i++){
			File[] f = new File[array[i].size()];
			int j=0;
			for(File file : array[i]){
				f[j]=file;j++;
			}
			finalList.add(f);
		}
		return finalList;
	}
}
