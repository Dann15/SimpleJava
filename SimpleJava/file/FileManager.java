package com.leftindust.SimpleJava.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Copyright (c) 2015 Daniel Shirvani
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * @author Daniel Shirvani
 * @version 1.0
 * 
 */
public class FileManager {

	/**
	 * This will return the text in a file.
	 * @return A string with line breaks.
	 * @param file This is the file that you would like to read.
	 * @throws IOException This is due to the BufferedReader in this method.
	 */
	public String readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String total = "";
		int times = 0;
		String x = "";
		while ((x = br.readLine()) != null) {
			if(times == 0){
				total = x;
			} else {
				times++;
				total = total+"\n"+x;
			}
		}
	 
		br.close();
		return total;
	}
	
	/**
	 * This will return the text in a file.
	 * @return An array of strings.
	 * @param file This is the file that you would like to read.
	 * @throws IOException This is due to the BufferedReader in this method.
	 */
	public ArrayList<String> readFileInArray(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> total = new ArrayList<String>();
		String x = "";
		while ((x = br.readLine()) != null) {
			total.add(x);
		}
		br.close();
		return total;
	}
	
	/**
	 * This will return the amount of lines in a file
	 * @param file This is the file that you would like to get the line amount from.
	 * @return The number of lines in the file (As an int)
	 * @throws IOException This is due to the BufferedReader in this method.
	 */
	public int getFileLineAmount(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int total = 0;
		while (br.readLine() != null) {
			total++;
		}
		br.close();
		return total;
	}
	

}
