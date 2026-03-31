public class StringConcatenationComparison{
	public static void main(String[] args){
		int n=1000000;
		String text="hello";
		long start,end;
		start=System.currentTimeMillis();
		stringConcat(text,n);
		end=System.currentTimeMillis();
		System.out.println("String Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		stringBuilderConcat(text,n);
		end=System.currentTimeMillis();
		System.out.println("StringBuilder Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		stringBufferConcat(text,n);
		end=System.currentTimeMillis();
		System.out.println("StringBuffer Time: "+(end-start)+" ms");
	}
	static void stringConcat(String s,int n){
		String result="";
		for(int i=0;i<n;i++){
			result=result+s;
		}
	}
	static void stringBuilderConcat(String s,int n){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(s);
		}
	}
	static void stringBufferConcat(String s,int n){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<n;i++){
			sb.append(s);
		}
	}
}
