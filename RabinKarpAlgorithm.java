package substringSearch;

public class RabinKarpAlgorithm {
	int prime=101;
	  void searchPattern(char[] text, char[] pattern) {
			int n=text.length;
			int m=pattern.length;
			long patternHash=createHash(pattern,m-1);
			long textHash=createHash(text,m-1);
			for(int i=1;i<=n-m+1;i++){
				if(patternHash==textHash && isEqual(text,pattern,i-1,i+m-2,0,m-1)){
					System.out.println("Pattern found at index "+(i-1));
				}
				if(i<n-m+1)
				{
					textHash=reallocateHash(text, textHash, i-1, i+m-1, m);
				}
			}
			
		}

	  private boolean isEqual(char[] str1,char[] str2, int start1,int end1,int start2,int end2){
		  if(end1-start1!=end2-start2)
			  return false;
		  while(start1<=end1 && start2<=end2){
			  if(str1[start1]!=str2[start2])
				  return false;
	
				  start1++;
				  start2++;
		  }
		  return true;
	  }
	  private long createHash(char[] str, int end) {
			long hash=0;
			for(int i=0;i<=end;i++){
				hash+= str[i]*Math.pow(prime, i);
			}
			return hash;
		}
	  private long reallocateHash(char[] text,long oldHash,int oldPos, int newPos,int patternSize){
			  long hash=oldHash-text[oldPos];
			  hash/=prime;
			  hash+=text[newPos]*Math.pow(prime,patternSize-1);
			  return hash;
		  }
	  public static void main(String[] args) {
		
		String text = "ABABCABABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        new RabinKarpAlgorithm().searchPattern(text.toCharArray(), pattern.toCharArray());
	  }

	

}
