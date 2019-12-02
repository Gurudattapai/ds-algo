package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int [][] matrix = new int [n][n];
        for (int col = 0; col < n; col++) {
            matrix[0][col] = 1;
            List<List<String>> childList = solve(1, matrix, n);
            if (childList != null) {
            	String str = getString(n, col);
            	for (int i = 0; i < childList.size(); i++) {
       			 List<String> strList = childList.get(i);
       			 strList.add(0, str);
       			 list.add(strList);
       		 }
            }
            matrix[0][col] = 0;
        }
        return list;
    }
    
    public static List<List<String>> solve(int row, int [][] matrix, int n) {
        
        if (row >= n) {
          return Collections.EMPTY_LIST;
        }
        List<List<String>> returnList = new LinkedList<>();
        for (int j = 0; j < n; j++) {
         if (!checkValid(row, j, matrix, n)) {
             continue;
         } else {
             matrix[row][j] = 1;
             List<List<String>> childList = solve(row+1, matrix, n);
             if (childList == null) {
                 matrix[row][j] = 0;
                 //continue;
             } else {
            	 String string = getString(n, j);
            	 if (childList.size() == 0) {
            		 List<String> str = new LinkedList<>();
            		 str.add(string);
            		 returnList.add(str);
            	 } else {
            		 for (int i = 0; i < childList.size(); i++) {
            			 System.out.println("List is "+childList.get(i));
            			 List<String> str = childList.get(i);
            			 str.add(0, string);
            			 returnList.add(str);
            		 }
            	 }
                 matrix[row][j] = 0;
             }
         }   
        }
        return returnList.size() == 0 ? null : returnList;
        
        /*[["Q....","..Q..","....Q",".Q...","...Q."],
         ["Q....","...Q.",".Q...","....Q","..Q.."],
         [".Q...","...Q.","Q....","..Q..","....Q"],
         [".Q...","....Q","..Q..","Q....","...Q."],
         ["..Q..","Q....","...Q.",".Q...","....Q"],
         ["..Q..","....Q",".Q...","...Q.","Q...."],
         ["...Q.","Q....","..Q..","....Q",".Q..."],
         ["...Q.",".Q...","....Q","..Q..","Q...."],
         ["....Q",".Q...","...Q.","Q....","..Q.."],
         ["....Q","..Q..","Q....","...Q.",".Q..."]]*/

    }
    
    public static String getString(int n, int num) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0; i < n; i++) {
            if (i == num) {
                strBuilder.append("Q");
            } else {
                strBuilder.append(".");
            }
        }
        return strBuilder.toString();
    }
    
    public static boolean checkValid(int row, int col, int [][] matrix, int n) {
        /*for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }*/
        //System.out.println("row: "+ row + " col: "+col);
        for (int i = 0; i < n; i++) {
            if (i == row) {
                continue;
            }
            if (matrix[i][col] == 1) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == col) {
                continue;
            }
            if (matrix[row][i] == 1) {
                return false;
            }
        }
        int index = 1;
        int i = Math.min(row, col);
        while (i > 0) {
        	if (matrix[row-index][col-index] == 1) {
        		return false;
        	}
        	i--;
        	index++;
        }
        index = 1;
        i = row;
        int j = col;
        while (i > 0 && j < n - 1) {
        	if (matrix[row-index][col+index] == 1) {
        		return false;
        	}
        	i--;
        	j++;
        	index++;
        }
        return true;
    }
    
    public static void main(String [] args) {
    	List<List<String>> list = solveNQueens(5);
    	for (int i = 0; i < list.size(); i++) {
    		System.out.println(list.get(i));
    	}
    }
}