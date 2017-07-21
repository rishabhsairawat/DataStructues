package substringSearch;

public class KMPAlgorithm {
	
	static void KMP(char[] text,char[] pattern){
		int tempArray[]=computeLPS(pattern);
		int i=0;
		int j=0;
		while(i<text.length){
			if(text[i]==pattern[j]){
				i++;
				j++;
			}
			else{
				if(j!=0){
					j=tempArray[j-1];
				}
				else{
					i++;
				}
			}
			if(j==pattern.length){
				System.out.println("Found pattern "+"at index " + (i-j));
				j = tempArray[j-1];
			}
		}
		
	}

	 static int[] computeLPS(char[] pattern) {
		int temp[]=new int[pattern.length];
		int j=0;
		int i=1;
		temp[0]=0;
		while(i<pattern.length){
			if(pattern[i]==pattern[j]){
				temp[i]=j+1;
				j++;
				i++;
			}
			else{
				if(j!=0){
					j=temp[j-1];
				}
				else{
					temp[i]=0;
					i++;
				}
				
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		String str = "ABABCABABABDABACDABABCABAB";
        String subString = "ABABCABAB";
        KMP(str.toCharArray(),subString.toCharArray());
       
	}

}
