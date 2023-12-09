package array;

public class Array {
	public static void maxMin(int [] arr) {
		int min=arr[0];
		int max=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println("min"+min);
		System.out.println("max"+max);
		
	}

	public static void sortingArr(int[] arr) {

		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[i+1]) {
					int temp=arr[j];
					arr[j]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}

	public static void uni(int[] arr) {
		boolean flag;
		int count=0;
		int [] uniArr=new int[90];
		for(int i=0;i<arr.length;i++) {
			flag=true;
			for(int j=0;j<arr.length;j++) {
				if(i==0) {
					uniArr[0]=arr[0];
				}
				if(arr[i]==uniArr[j]) {
					flag=false;
					break;
				}
			}
			if(flag==true) {
				uniArr[count++]=arr[i];
			}
		}
		System.out.println();
		for(int a:uniArr) {
			
			if(a==0) {
				break;
			}
			System.out.print(a+" ");
		}
	}
	public static void main(String[] args) {
	int[] arr= {2,34,1,65,8,9,4,34,8};
	maxMin(arr);
	sortingArr(arr);
	uni(arr);
}
}
