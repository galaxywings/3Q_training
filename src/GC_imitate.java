import java.util.ArrayList;
import java.util.List;



public class GC_imitate {
	
	/**
	 * 	
	-verbose:gc
	-Xms4m
	-Xmx4m
	-Xmn2m
	-XX:+PrintGCDetails
	-XX:SurvivorRatio=8
	//-XX:MaxPermSize=1M
	//-Xloggc:c:/Gc.log
	 */

	public static void main(String[] args)  {
		List list = new ArrayList();
		Runtime run = Runtime.getRuntime();
//		byte[] a = new byte[1024*1024*5];
		for(long i=1;i<1000000;i++){
		  list.add("10000000000");
//		  System.out.println(i);
//		    System.out.print("最大内存=" + run.maxMemory() / 1024 / 1024 + "M,");
//	        System.out.print("已分配内存=" + run.totalMemory() /1024 / 1024 + "M,");
//	        System.out.print("剩余空间内存=" + run.freeMemory() / 1024 / 1024 + "M");
//	        System.out.println("最大可用内存=" + ( run.maxMemory() - run.totalMemory() + run.freeMemory() ) / 1024 / 1024 + "M");
		}
		
	}
	
	/**
	 *
[GC [PSYoungGen: 1552K->160K(1856K)] 1552K->797K(3904K), 0.0027676 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [PSYoungGen: 1291K->176K(1856K)] 6384K->5292K(8000K), 0.0088841 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
[GC [PSYoungGen: 176K->160K(1856K)] 5292K->5292K(8000K), 0.0017013 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC [PSYoungGen: 160K->0K(1856K)] [ParOldGen: 5132K->2597K(5312K)] 5292K->2597K(7168K) [PSPermGen: 2633K->2631K(21248K)], 0.0463403 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
[GC [PSYoungGen: 0K->0K(1856K)] 5762K->5762K(8000K), 0.0034188 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 
[Full GC [PSYoungGen: 0K->0K(1856K)] [ParOldGen: 5762K->3652K(6144K)] 5762K->3652K(8000K) [PSPermGen: 2631K->2631K(21248K)], 0.0365083 secs] [Times: user=0.05 sys=0.00, real=0.04 secs] 
[GC [PSYoungGen: 0K->0K(1856K)] 3652K->3652K(8000K), 0.0003945 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC [PSYoungGen: 0K->0K(1856K)] [ParOldGen: 3652K->3638K(6144K)] 3652K->3638K(8000K) [PSPermGen: 2631K->2631K(21248K)], 0.0201593 secs] [Times: user=0.05 sys=0.00, real=0.02 secs] 
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:2245)
	at java.util.Arrays.copyOf(Arrays.java:2219)
	at java.util.ArrayList.grow(ArrayList.java:213)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:187)
	at java.util.ArrayList.add(ArrayList.java:411)
	at GC_imitate.main(GC_imitate.java:25)
Heap
 PSYoungGen      total 1856K, used 31K [0x00000000ffe00000, 0x0000000100000000, 0x0000000100000000)
  eden space 1664K, 1% used [0x00000000ffe00000,0x00000000ffe07fe8,0x00000000fffa0000)
  from space 192K, 0% used [0x00000000fffa0000,0x00000000fffa0000,0x00000000fffd0000)
  to   space 192K, 0% used [0x00000000fffd0000,0x00000000fffd0000,0x0000000100000000)
 ParOldGen       total 6144K, used 3638K [0x00000000ff800000, 0x00000000ffe00000, 0x00000000ffe00000)
  object space 6144K, 59% used [0x00000000ff800000,0x00000000ffb8d960,0x00000000ffe00000)
 PSPermGen       total 21248K, used 2665K [0x00000000fa600000, 0x00000000fbac0000, 0x00000000ff800000)
  object space 21248K, 12% used [0x00000000fa600000,0x00000000fa89a4a0,0x00000000fbac0000)
*/
}




